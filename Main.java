import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Comparable;

public class Main {
    public static ArrayList<Product> Ucomplekt(ArrayList<Product> list, int value) {
        ArrayList<Product> zagruz = new ArrayList<>();
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).getIndex() > list.get(j + 1).getIndex()) {
                    Product tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }


        }
        int zagrujeno =0;
        for (int i = list.size()-1; i>= 0;i--) {
            if ((zagrujeno + list.get(i).weigth > 50)) {
                break;
            } else {
                zagruz.add(list.get(i));
                zagrujeno += list.get(i).weigth;
            }
        }
        return zagruz;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int value = Integer.parseInt(reader.readLine());
        ArrayList<Product> listProd = new ArrayList<>();
        String str = reader.readLine();
        String name;
        int weigth;
        int cost;
        String[] subStr;
        String[] subStr2;
        subStr = str.split(" ");

        for (int i = 0; i < subStr.length; i++) {
            String vvodTowar = subStr[i];
            subStr2 = vvodTowar.split("/");
            name = subStr2[0];
            weigth = Integer.parseInt(subStr2[1]);
            cost = Integer.parseInt(subStr2[2]);
            listProd.add(new Product(name, weigth, cost));
        }
        ArrayList<Product> gruz = new ArrayList<>();
        gruz = Ucomplekt(listProd, value);
        String names = "";
        int price = 0;
        for(int i =0; i<gruz.size(); i++)
        {
            names += gruz.get(i).name+" ";
            price +=gruz.get(i).cost;
        }

        System.out.println(names+price);

    }
}
