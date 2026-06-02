# 📓 MyCollegeNote

Aplikasi desktop berbasis Java AWT untuk mencatat materi kuliah per mata kuliah, dengan fitur simpan otomatis ke file `.txt` lokal.

---

## 📁 Struktur Proyek

```
MyCollegeNote/
└── src/
    ├── App.java          # Entry point
    ├── AppFrame.java     # Main window & logika UI
    ├── Matkul.java       # Interface kontrak matkul
    ├── Aljab.java        # Aljabar Linear dan Matriks
    ├── BINDO.java        # Bahasa Indonesia
    ├── DBD.java          # Desain Basis Data
    ├── DDAP.java         # Dasar Desain Antarmuka Pengguna
    ├── OS.java           # Sistem Operasi
    ├── Pemlan.java       # Pemrograman Lanjut
    ├── Probstat.java     # Probabilitas & Statistika
    └── NOTES/            # Folder output catatan (auto-generated)
```

---

## ⚙️ Prasyarat — Instalasi JDK

Aplikasi ini membutuhkan **JDK (Java Development Kit)** untuk compile dan **JRE (Java Runtime Environment)** untuk menjalankan file `.jar`.

> ✅ JDK sudah include JRE di dalamnya, jadi cukup install JDK saja.

### 🪟 Windows

1. Download JDK dari situs resmi:
   - **Oracle JDK**: [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
   - **OpenJDK (gratis)**: [https://adoptium.net/](https://adoptium.net/) ← rekomendasi
2. Pilih versi **JDK 17** atau **JDK 21** (LTS), pilih installer `.msi` untuk Windows.
3. Jalankan installer, ikuti wizard instalasi hingga selesai.
4. Verifikasi instalasi — buka **Command Prompt** lalu ketik:
   ```cmd
   java -version
   javac -version
   ```
   Output yang diharapkan:
   ```
   java version "21.x.x" ...
   javac 21.x.x
   ```

5. **Set Environment Variable** (jika belum otomatis):
   - Buka *System Properties* → *Environment Variables*
   - Pada **System Variables**, cari `Path` → klik *Edit*
   - Tambahkan path ke folder `bin` JDK, contoh:
     ```
     C:\Program Files\Java\jdk-21\bin
     ```
   - Klik OK, restart Command Prompt.

---

### 🐧 Linux (Ubuntu/Debian)

```bash
sudo apt update
sudo apt install openjdk-21-jdk -y
java -version
```

### 🍎 macOS

```bash
# Menggunakan Homebrew
brew install openjdk@21
java -version
```

---

## 🔨 Kompilasi Source Code

> Pastikan kamu berada di root folder proyek (`MyCollegeNote/`).

### Langkah 1 — Buat folder output & folder NOTES

```cmd
mkdir out
mkdir src\NOTES
```

### Langkah 2 — Kompilasi semua file `.java`

```cmd
javac -d out src\*.java
```

Jika berhasil, folder `out/` akan berisi file-file `.class` hasil kompilasi.

---

## 📦 Membuat File `.jar` (Executable)

File `.jar` memungkinkan aplikasi dijalankan hanya dengan **double-click**, tanpa perlu membuka terminal.

### Langkah 1 — Buat file Manifest

Buat file bernama `manifest.txt` di root proyek, isi dengan:

```
Main-Class: App
```

> ⚠️ Pastikan ada **baris kosong** di akhir file manifest (tekan Enter sekali setelah `Main-Class: App`).

### Langkah 2 — Package semua `.class` menjadi `.jar`

```cmd
jar cfm MyCollegeNote.jar manifest.txt -C out .
```

Penjelasan flag:
| Flag | Fungsi |
|------|--------|
| `c`  | Create — buat archive baru |
| `f`  | File — nama output file `.jar` |
| `m`  | Manifest — gunakan file manifest custom |
| `-C out .` | Ambil semua file dari folder `out/` |

### Langkah 3 — Jalankan `.jar`

**Via double-click:**
Cukup double-click file `MyCollegeNote.jar` di File Explorer.

**Via terminal (opsional, untuk debugging):**
```cmd
java -jar MyCollegeNote.jar
```

---

## 📂 Konfigurasi Path Penyimpanan Catatan

Secara default, setiap file catatan disimpan di path hardcoded berikut:

```
D:\Projects\JAVA\MyCollegeNote\src\NOTES\<NamaMatkul>.txt
```

Jika kamu menjalankan proyek di direktori berbeda, **ubah konstanta `PATH_FILE`** di setiap file matkul (contoh di `Aljab.java`):

```java
// Sebelum
private final String PATH_FILE = "D:\\Projects\\JAVA\\MyCollegeNote\\src\\NOTES\\" + NAMA_MATKUL + ".txt";

// Sesudah — sesuaikan dengan path proyekmu
private final String PATH_FILE = "C:\\Users\\NamaKamu\\Desktop\\MyCollegeNote\\src\\NOTES\\" + NAMA_MATKUL + ".txt";
```

> 💡 **Tips:** Untuk path yang lebih fleksibel dan tidak hardcoded, kamu bisa menggunakan path relatif seperti:
> ```java
> private final String PATH_FILE = "src/NOTES/" + NAMA_MATKUL + ".txt";
> ```

---

## 🚀 Cara Penggunaan Aplikasi

1. Jalankan `MyCollegeNote.jar` (double-click atau via terminal).
2. Pilih **mata kuliah** menggunakan checkbox di bagian atas (hanya bisa pilih satu).
3. Area teks akan otomatis ter-reset dengan header matkul yang dipilih.
4. Ketik catatanmu di area teks.
5. Klik tombol **"Simpan Catatan"** untuk menyimpan ke file `.txt`.
6. File catatan tersimpan di folder `NOTES/` sesuai nama mata kuliah.

---

## 🎓 Mata Kuliah yang Tersedia

| Checkbox | Nama Lengkap Matkul |
|----------|---------------------|
| Pemlan   | Pemrograman Lanjut |
| Probstat | Probabilitas & Statistika |
| DBD      | Desain Basis Data |
| DDAP     | Dasar Desain Antarmuka Pengguna |
| BInd     | Bahasa Indonesia |
| ADM      | Aljabar Linear dan Matriks |
| SO       | Sistem Operasi |

---

## 🐛 Troubleshooting

**❌ Error: `Could not find or load main class App`**
→ Pastikan manifest sudah benar dan tidak ada typo. Coba rebuild ulang dari langkah kompilasi.

**❌ Error: `IOException` saat menyimpan**
→ Folder `NOTES/` belum ada. Buat manual dulu:
```cmd
mkdir src\NOTES
```

**❌ Double-click `.jar` tidak membuka aplikasi**
→ File `.jar` belum ter-associate dengan Java. Fix:
- Klik kanan `.jar` → *Open With* → *Java(TM) Platform SE Binary*
- Atau jalankan via terminal: `java -jar MyCollegeNote.jar`

**❌ `javac` tidak dikenali di terminal**
→ JDK belum ditambahkan ke PATH. Ulangi langkah *Set Environment Variable* di atas.

---

## 📌 Catatan Pengembangan

Proyek ini menggunakan **Java AWT** (Abstract Window Toolkit), bukan Swing atau JavaFX. AWT adalah library GUI bawaan Java yang paling dasar, cocok untuk aplikasi desktop sederhana tanpa dependency eksternal.

Setiap mata kuliah mengimplementasikan interface `Matkul` dengan dua method:
- `setForm()` — reset tampilan TextArea dengan header matkul
- `writeText()` — simpan isi TextArea ke file `.txt`

---

*Dibuat untuk keperluan akademis — MyCollegeNote © 2024*
