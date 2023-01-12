import org.apache.commons.lang.RandomStringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Zvire implements Serializable, Comparable<Zvire> {
    String jmeno;
    int pocet;
    static ArrayList<Zvire> list = new ArrayList<>();

    public Zvire(String jmeno, int pocet) {
        this.jmeno = jmeno;
        this.pocet = pocet;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("data.dat");
       if (file.exists()) {
           FileInputStream inFile = new FileInputStream(file);
           ObjectInputStream in = new ObjectInputStream(inFile);

           list = (ArrayList<Zvire>) in.readObject();
           Collections.sort(list);
           System.out.println(list);
           inFile.close();
           in.close();
       }
       FileOutputStream outFile = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(outFile);

        for (int i = 0; i < 10; i++) {
            list.add(new Zvire(randomString(), randomNumber()));
            list.add(new Had(randomString(),randomNumber()));
        }

        out.writeObject(list);
        out.close();
        outFile.close();

    }

    public static String randomString() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public static int randomNumber() {
        return ThreadLocalRandom.current().nextInt(10);
    }

    @Override
    public String toString() {
        return jmeno + " " + pocet;
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