public class Kocka extends Savec {
    public Kocka(String jmeno) {
        this.jmeno = jmeno;
        podDruh = "Kocka";
    }

    @Override
    public String toString() {
        return "Kocka{" + jmeno +
                "druh='" + druh + '\'' +
                ", pocetNohou=" + pocetNohou +
                ", podDruh='" + podDruh + '\'' +
                '}';
    }
}
