import java.io.Serializable;

public  class Had extends Zvire{
    int delka;
    public Had(String jmeno, int delka) {
        super(jmeno, delka);
    }

    @Override
    public String toString() {
        return "Had " + jmeno + " " + delka;
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
