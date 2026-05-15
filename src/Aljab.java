import java.awt.TextArea;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Aljab implements Matkul {
    private final String NAMA_MATKUL = "Aljabar Linear dan Matriks";
    private final String PATH_FILE = "D:\\Projects\\JAVA\\MyCollegeNote\\src\\NOTES\\" + NAMA_MATKUL + ".txt";
    private TextArea txt;
    public Aljab(TextArea txt){
        this.txt = txt;
    }

    @Override
    public void setForm(){
        this.txt.setText("==============\n"+ NAMA_MATKUL + "\n==============\n");
    }   

    @Override
    public void writeText(){
        File savedFile = new File(PATH_FILE);
        String note = this.txt.getText();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(savedFile))){
            writer.write(note);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
