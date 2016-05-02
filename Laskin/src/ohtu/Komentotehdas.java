package ohtu;

import java.util.HashMap;
import javax.swing.JTextField;
        

public class Komentotehdas {
    private HashMap<String, Komento> komennot;

    public Komentotehdas(Sovelluslogiikka sovellus, JTextField tuloskenttä, JTextField syötekenttä) {
        komennot = new HashMap<String, Komento>();
        komennot.put("plus", new Summa(sovellus, tuloskenttä, syötekenttä));
        komennot.put("miinus", new Erotus(sovellus, tuloskenttä, syötekenttä));
        komennot.put("nollaa", new Nollaa(sovellus, tuloskenttä, syötekenttä));
//        komennot.put("tuntematon", new Tuntematon(io));
    }

    public Komento hae(String operaatio) {
        Komento komento = komennot.get(operaatio);
        if (komento == null) {
            komento = komennot.get("tuntematon");
        }
        return komento;
    }
}