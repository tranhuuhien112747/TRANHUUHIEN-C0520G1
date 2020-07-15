package javacollection_tree_and_map.exercise.arraylist;

import java.util.Comparator;

//giam dan theo gia
public class SortDescendingByPrice implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPriceProduct() - o2.getPriceProduct());
    }
}
