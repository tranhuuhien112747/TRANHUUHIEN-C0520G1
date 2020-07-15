package javacollection_tree_and_map.exercise.arraylist;

import java.util.Comparator;

public class SortAscendingByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o2.getPriceProduct() - o1.getPriceProduct());
    }
}
