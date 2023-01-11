import java.io.Serializable;

public  class Kocka extends Zvire {
    int pocetZivotu;

    public Kocka(String jmeno, int pocetZivotu){
        super(jmeno, pocetZivotu);
    }
    @Override
    public String toString() {
        return jmeno + " " + pocetZivotu;
    }
    @Override
    public int compareTo(Zvire o) {
        if (pocet < o.pocet){
            return 1;
        }else if (pocet>o.pocet){
            return -1;
        }else if (pocet==o.pocet){
            if(jmeno.compareTo(o.jmeno)>0){
                return 1;
            }else if (jmeno.compareTo(o.jmeno)<0){
                return -1;
            }
        }
        return 0;
    }
}