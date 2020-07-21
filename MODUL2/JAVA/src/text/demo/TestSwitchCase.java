package text.demo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestSwitchCase {
    private int numerator, denominator;

    public TestSwitchCase(int n, int d) throws FileNotFoundException {
        if (d == n) System.out.println("sdsds");
        else System.out.println("Ok");
        this.numerator = n;
        this.denominator = d;
    }

}
