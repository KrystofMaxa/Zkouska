import java.io.Serializable;

public  class Kocka extends Zvire implements Serializable,Comparable {
    int pocetZivotu;

   public Kocka(String jmeno, int pocetZivotu){
       super(jmeno, pocetZivotu);
   }
    @Override
    public String toString() {
        return jmeno + " " + pocetZivotu;
    }
}
