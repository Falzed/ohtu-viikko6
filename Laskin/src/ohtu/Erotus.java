package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskenttä;
    private JTextField syötekenttä;
    private int syöte;
    
    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskenttä, JTextField syötekenttä) {
        this.sovellus=sovellus;
        this.tuloskenttä=tuloskenttä;
        this.syötekenttä=syötekenttä;
    }
    @Override
    public void suorita() {
        this.syöte = Integer.parseInt(syötekenttä.getText());
        this.sovellus.miinus(Integer.parseInt(syötekenttä.getText()));
        int laskunTulos = sovellus.tulos();
        syötekenttä.setText("");
        tuloskenttä.setText("" + laskunTulos);
    } 
    @Override
    public void peru() {
        this.sovellus.plus(syöte);
        int laskunTulos = sovellus.tulos();
        syötekenttä.setText("");
        tuloskenttä.setText("" + laskunTulos);
    } 
}
