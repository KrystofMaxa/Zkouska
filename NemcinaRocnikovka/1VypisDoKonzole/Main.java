import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main implements Serializable {
    int poradi;
    String cesky;
    String nemecky;
    String pravidelnost;
    static int chciPoradi;
    static String pockat;
    static String pravid = "Er hat";
    static String nepravid = "Er ist";

    static ArrayList<CelyObjekt> arr = new ArrayList<CelyObjekt>();
    static ArrayList<Integer> list = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("data.dat");
        // if(file.exists()){
           // FileInputStream inFile = new FileInputStream(file);
        //ObjectInputStream in = new ObjectInputStream(inFile);
          //  arr = (ArrayList<CelyObjekt>) in.readObject();
        //}
        //System.out.println(arr.get(0));
        Scanner sc = new Scanner(file);
        Scanner kon = new Scanner(System.in);
        for(int i = 0; i<2; i++){
            int poradi = sc.nextInt();
            String cz = sc.next();
            String de = sc.next();
            String pr = sc.next();
            arr.add(new CelyObjekt(poradi,cz,de,pr));
        }
        for(int k = 0; k<2; k++) {
            chciPoradi = kon.nextInt();
            System.out.println(arr.get(chciPoradi).cesky);
            pockat = kon.next();
            System.out.println(arr.get(chciPoradi).nemecky);
            pockat = kon.next();
            if (arr.get(chciPoradi).pravidelnost.equals("N")){
                System.out.println(nepravid + " " + arr.get(chciPoradi).nemecky);
            }else {
                System.out.println(pravid + " " + arr.get(chciPoradi).nemecky);
            }
            pockat = kon.next();
        }

    }
}

