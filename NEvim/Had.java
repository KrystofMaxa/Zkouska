import java.io.Serializable;

public  class Had extends Zvire implements Serializable, Comparable {
    int delka;
    public Had(String jmeno, int delka) {
        super(jmeno, delka);
    }

    @Override
    public String toString() {
        return jmeno + " " + delka;
    }


}
