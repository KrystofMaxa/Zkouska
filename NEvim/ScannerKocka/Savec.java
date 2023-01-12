import java.io.*;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.Scanner;

public class Savec implements Serializable {
    String jmeno;
    String druh = "Savci";
    int pocetNohou = 4;
    String podDruh;
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> arr = new ArrayList();
        ArrayList<Savec> list = new ArrayList<>();
        File file = new File("data.dat");
        Scanner sc = new Scanner(file);


        for (int i = 0; i<2; i++){
            String slovo = sc.next();
            list.add(new Kocka(slovo));
        }


        System.out.println(list);
    }

}