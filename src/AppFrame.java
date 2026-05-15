import java.awt.*;
import java.awt.event.*;

public class AppFrame extends Frame {
    private final Font FONT_LABEL = new Font("Arial", 1, 24);
    private final CheckboxGroup CBG_MATKUL = new CheckboxGroup();
    private Checkbox cbPemlan, cbProbstat, cbDDAP, cbDBD, cbBINDO, cbOS, cbAljab;
    private TextArea form;
    private Pemlan pemlan;
    private Probstat probstat;
    private DDAP ddap;
    private DBD dbd;
    private BINDO bindo;
    private OS os;
    private Aljab aljab;

    public AppFrame() {
        setSize(1024, 640);
        setLayout(null);
        setVisible(true);
        setTitle("My College Notes");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
        setResizable(false);
        this.componentJudul("MY COLLEGE NOTE");
        this.componentCB();
        this.componentForm();
        this.componentButton();
    }

    private void componentJudul(String judul) {
        Label lbJudul = new Label(judul, 0);
        lbJudul.setFont(this.FONT_LABEL);
        add(lbJudul);
        lbJudul.setBounds((1024 - 232) / 2, 40, 232, 40);
    }

    private void componentCB() {
        cbPemlan = new Checkbox("Pemlan", CBG_MATKUL, false);
        cbPemlan.setBounds(275, 90, 60, 20);
        cbProbstat = new Checkbox("Probstat", CBG_MATKUL, false);
        cbProbstat.setBounds(345, 90, 70, 20);
        cbDBD = new Checkbox("DBD", CBG_MATKUL, false);
        cbDBD.setBounds(415, 90, 45, 20);
        cbDDAP = new Checkbox("DDAP", CBG_MATKUL, false);
        cbDDAP.setBounds(470, 90, 60, 20);
        cbBINDO = new Checkbox("BInd", CBG_MATKUL, false);
        cbBINDO.setBounds(540, 90, 40, 20);
        cbAljab = new Checkbox("ADM", CBG_MATKUL, false);
        cbAljab.setBounds(590, 90, 40, 20);
        cbOS = new Checkbox("SO", CBG_MATKUL, false);
        cbOS.setBounds(640, 90, 40, 20);
        add(cbPemlan);
        add(cbProbstat);
        add(cbDBD);
        add(cbDDAP);
        add(cbBINDO);
        add(cbAljab);
        add(cbOS);
        cbPemlan.addItemListener(e -> resetForm());
        cbProbstat.addItemListener(e -> resetForm());
        cbDBD.addItemListener(e -> resetForm());
        cbDDAP.addItemListener(e -> resetForm());
        cbBINDO.addItemListener(e -> resetForm());
        cbAljab.addItemListener(e -> resetForm());
        cbOS.addItemListener(e -> resetForm());
    }

    private void componentForm() {
        Label lbNote = new Label("NOTE");
        add(lbNote);
        lbNote.setBounds(487, 120, 50, 20);
        Rectangle r = new Rectangle(112, 160, 800, 400);
        form = new TextArea();
        add(form);
        form.setBounds(r);
        pemlan = new Pemlan(this.form);
        dbd = new DBD(this.form);
        ddap = new DDAP(this.form);
        aljab = new Aljab(this.form);
        probstat = new Probstat(this.form);
        os = new OS(form);
        bindo = new BINDO(this.form);
    }

    private void componentButton() {
        Button btnSave = new Button("Simpan Catatan");
        add(btnSave);
        btnSave.setBounds(450, 580, 124, 20);
        btnSave.addActionListener(l -> saveText());
    }

    private void resetForm() {
        Checkbox selected = CBG_MATKUL.getSelectedCheckbox();

        if (selected == cbPemlan) {
            pemlan.setForm();
        } else if (selected == cbDBD) {
            dbd.setForm();
        } else if (selected == cbDDAP) {
            ddap.setForm();
        } else if (selected == cbAljab) {
            aljab.setForm();
        } else if (selected == cbBINDO) {
            bindo.setForm();
        } else if (selected == cbProbstat) {
            probstat.setForm();
        } else if (selected == cbOS) {
            os.setForm();
        } else if (selected == null) {
            form.setText("DEY!!! TURUN");
        }
    }

    private void saveText() {
        Checkbox selected = CBG_MATKUL.getSelectedCheckbox();
        if (selected == cbPemlan) {
            pemlan.writeText();
            pemlan.setForm();
        } else if (selected == cbDBD) {
            dbd.writeText();
            dbd.setForm();
        } else if (selected == cbDDAP) {
            ddap.writeText();
            ddap.setForm();
        } else if (selected == cbAljab) {
            aljab.writeText();
            aljab.setForm();
        } else if (selected == cbBINDO) {
            bindo.writeText();
            bindo.setForm();
        } else if (selected == cbProbstat) {
            probstat.writeText();
            probstat.setForm();
        } else if (selected == cbOS) {
            os.writeText();
            os.setForm();
        } else if (selected == null) {
            form.setText("DEY!!! TURUN");
        }
    }
}