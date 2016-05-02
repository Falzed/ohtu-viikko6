package ohtu;

import javax.swing.JTextField;

public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private JTextField tuloskenttä;
    private JTextField syötekenttä;
    private int syöte;

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskenttä, JTextField syötekenttä) {
        this.sovellus = sovellus;
        this.syötekenttä = syötekenttä;
        this.tuloskenttä = tuloskenttä;
        //this.syöte=Integer.parseInt(syötekenttä.getText());
    }

    @Override
    public void suorita() {
        this.syöte=Integer.parseInt(syötekenttä.getText());
        this.sovellus.plus(Integer.parseInt(syötekenttä.getText()));
        int laskunTulos = sovellus.tulos();
        syötekenttä.setText("");
        tuloskenttä.setText("" + laskunTulos);
    }

    @Override
    public void peru() {
        this.sovellus.miinus(syöte);
        int laskunTulos = sovellus.tulos();
        syötekenttä.setText("");
        tuloskenttä.setText("" + laskunTulos);
    }
}
