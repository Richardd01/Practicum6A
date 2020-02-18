import java.time.LocalDate;
import java.util.Locale;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String naam, int releaseJaar, double nieuwprijs) {
        this.naam = naam;
        this.releaseJaar = releaseJaar;
        this.nieuwprijs = nieuwprijs;
    }

    public String getNaam() {
        return naam;
    }

    public double huidigeWaarde() {
        int huidigeJaar = LocalDate.now().getYear();
        int jaarverschil =  huidigeJaar - releaseJaar;
        return nieuwprijs * Math.pow(0.70, jaarverschil);
    }

    public boolean equals(Object andereObject) {
        if(andereObject instanceof Game) {
            Game andereGame = (Game) andereObject;
            if(this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return String.format(Locale.GERMANY, "%s, uitgegeven in %d; nieuwprijs: €%.2f nu voor: €%.2f", naam, releaseJaar, nieuwprijs, huidigeWaarde());
    }

}
