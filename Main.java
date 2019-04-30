import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Comparable;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int capacity = Integer.parseInt(reader.readLine());
        Truck truck = new Truck(capacity);

        ArrayList<Product> listProduct = new ArrayList<>();
        String str = reader.readLine();
        String[] subStr;
        String[] subStr2;
        subStr = str.split(" ");
        String name;
        int weigth;
        int cost;
        for (int i = 0; i < subStr.length; i++)
        {
            String inputProduct = subStr[i];
            subStr2 = inputProduct.split("/");
            name = subStr2[0];
            weigth = Integer.parseInt(subStr2[1]);
            cost = Integer.parseInt(subStr2[2]);
            listProduct.add(new Product(name, weigth, cost));
        }

        ArrayList<Product> cargo = new ArrayList<>();
        cargo = manningСargo(listProduct, truck);
        String names = "";
        int priceAll = 0;
        for(int i =0; i<cargo.size(); i++)
        {
            names += cargo.get(i).getName()+" ";
            priceAll +=cargo.get(i).getCost();
        }

        System.out.println(names+priceAll);


    }

    public static ArrayList<Product> manningСargo(ArrayList<Product> list, Truck truck)
    {
        ArrayList<Product> value = new ArrayList<>();
        for (int i = list.size() - 1; i > 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (benefitIndex(list.get(j),truck)> benefitIndex(list.get(j+1),truck)) {
                    Product tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
        int cargoIn =0;
        for (int i = list.size()-1; i>= 0;)
        {
            if((list.get(i).getWeigth()+cargoIn)<=truck.getCapacity()){cargoIn += list.get(i).getWeigth(); value.add(list.get(i));i--;}
            else i--;
//            if ((cargoIn + list.get(i).getWeigth() > truck.getCapacity()))
//            { break
//            } else {
//                value.add(list.get(i));
//                cargoIn += list.get(i).getWeigth();
//            }
        }
        return value;
    }

    public static double benefitIndex (Product product, Truck truck){
        double index = (product.getWeigth()/product.getCost())*truck.getCapacity();
        return index;
    }

}
