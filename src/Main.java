import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import app.Product;
import app.ProductComparator;
import app.Util;

public class Main {

    public static void main(String[] args) {
        int count = 10;
        int nameLength = 3;
        Random rand = new Random();

        List<Product> list = new LinkedList<Product>();

        for (int i = 0; i < count; i++) {
            char[] arr = new char[nameLength];
            for (int j = 0; j < arr.length; j++) {
                char c = (char)(rand.nextInt(26) + 'a');
                arr[j] = c;
            }
            String name = new String(arr);
            Product product1 = new Product(name);
            list.add(product1);
            Product product2 = new Product(product1);
            list.add(product2);
        }

        System.out.println("------------Initial list---------------");
        System.out.println(list);

        System.out.println("------------After sort---------------");
        ProductComparator comparator = new ProductComparator();
        list.sort(comparator);
        System.out.println(list);

        System.out.println("------------After removing duplicates---------------");
        Util.removeListDuplicates(list);
        System.out.println(list);
    }
}
