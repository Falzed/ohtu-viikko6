package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskenttä;
    private JTextField syötekenttä;
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskenttä, JTextField syötekenttä) {
        this.sovellus=sovellus;
        this.syötekenttä=syötekenttä;
        this.tuloskenttä=tuloskenttä;
    }
    @Override
    public void suorita() {
        this.sovellus.nollaa();
        int laskunTulos = sovellus.tulos();
        syötekenttä.setText("");
        tuloskenttä.setText("" + laskunTulos);
    } 
    @Override
    public void peru() {
        
    } 
}
