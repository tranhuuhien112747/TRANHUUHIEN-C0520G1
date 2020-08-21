package bai_thi;

import java.util.Comparator;

public class SortProduct implements Comparator<Product> {
    @Override
    public int compare(Product e1, Product e2) {
        return e1.getNameProduct().compareTo(e2.getNameProduct());
    }
}
