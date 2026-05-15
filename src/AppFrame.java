import java.awt.*;
import java.awt.event.*;

public class AppFrame extends Frame {
    private final Font FONT_LABEL = new Font("Arial", 1, 24);
    private final CheckboxGroup CBG_MATKUL = new CheckboxGroup();
    public AppFrame(){
        setSize(1024, 640);
        setLayout(null);
        setVisible(true);
        setTitle("My College Notes");
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
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

    private void componentJudul(String judul){
        Label lbJudul = new Label(judul, 0);
        lbJudul.setFont(this.FONT_LABEL);
        add(lbJudul);
        lbJudul.setBounds((1024 - 232) / 2,40,232,40);
    }

    private void componentCB(){
        Checkbox cbPemlan = new Checkbox("Pemlan",CBG_MATKUL,false);
        cbPemlan.setBounds(275,90,60,20);
        Checkbox cbProbstat = new Checkbox("Probstat",CBG_MATKUL,false);
        cbProbstat.setBounds(345,90,70,20);
        Checkbox cbDBD = new Checkbox("DBD",CBG_MATKUL,false);
        cbDBD.setBounds(415,90,45,20);
        Checkbox cbDDAP = new Checkbox("DDAP",CBG_MATKUL,false);
        cbDDAP.setBounds(470,90,60,20);
        Checkbox cbBINDO = new Checkbox("BInd",CBG_MATKUL,false);
        cbBINDO.setBounds(540,90,40,20);
        Checkbox cbAljab = new Checkbox("ADM",CBG_MATKUL,false);
        cbAljab.setBounds(590,90,40,20);
        Checkbox cbOS = new Checkbox("SO",CBG_MATKUL,false);
        cbOS.setBounds(640,90,40,20);
        add(cbPemlan);
        add(cbProbstat);
        add(cbDBD);
        add(cbDDAP);
        add(cbBINDO);
        add(cbAljab);
        add(cbOS);
    }

    private void componentForm(){
        Label lbNote = new Label("NOTE");
        add(lbNote);
        lbNote.setBounds(487,120,50,20);
        Rectangle r = new Rectangle( 112,160,800,400);
        TextArea form = new TextArea();
        add(form);
        form.setBounds(r);
    }

    private void componentButton(){
        Button btnSave = new Button("Simpan Catatan");
        add(btnSave);
        btnSave.setBounds(450,580,124,20);
    }
}