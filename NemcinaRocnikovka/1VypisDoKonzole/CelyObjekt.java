public class CelyObjekt extends Main {
    public CelyObjekt(int poradi, String cesky,String nemecky, String pravidelnost) {
        this.poradi = poradi;
        this.cesky = cesky;
        this.nemecky = nemecky;
        this.pravidelnost = pravidelnost;
    }

    @Override
    public String toString() {
        return  "cesky='" + cesky + '\'' +
                ", nemecky='" + nemecky + '\'';
    }
}
