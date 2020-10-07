import java.util.Scanner;
import java.util.TreeMap;


public class Products {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String name;
        String productName;
        int productCount;

        TreeMap<String, TreeMap<String, Integer>> customers = new TreeMap<>();

        while(true) {
            if (sc.nextLine().equals("end"))
                break;
            TreeMap<String, Integer> products = new TreeMap<>();
            String[] str = sc.nextLine().split(" ");
            name = str[0];
            productName = str[1];
            productCount = Integer.parseInt(str[2]);


            if (customers.containsKey(name)){
                products = customers.get(name);
                if(products.containsKey(productName)){
                    productCount+=products.get(productName);
                    products.put(productName,productCount);
                }else{
                    products.put(productName,productCount);
                }
                customers.put(name, products);
            }else{
                products.put(productName,productCount);
                customers.put(name, products);
            }
        }

        for(String customer : customers.keySet()){
            System.out.println(customer+":");

            for(String product : customers.get(customer).keySet()){
                System.out.println(product+" "+customers.get(customer).get(product));
            }
        }
    }
}
