package solutions;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static List<Stat> result = new ArrayList<>();

    public static final int[] fibs = new int[]{
            1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597,
            2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418,
            317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465,
            14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296,
            433494437, 701408733, 1134903170, 1836311903
    };

    public static double findMin(double a, double b, double l, final double eps) {
        double anchor = (b - a) / l;
        int n = -1;
        for (int i = 2; i < fibs.length; i++) {
            if (fibs[i] > anchor) {
                n = i;
                break;
            }
        }
        if (n == -1) {
            System.out.println("Cannot find F for this data. Choose different 'l'.");
            return -1;
        }
        //System.out.printf("%11s %11s %11s %11s %11s %11s %11s%n",
        //        "a", "b", "b - a", "x1", "x2", "f1", "f2");
        double x1 = a + ((fibs[n - 2] * 1.0) / fibs[n]) * (b - a);
        double x2 = a + ((fibs[n - 1] * 1.0) / fibs[n]) * (b - a);
        for (int k = 1; k < n - 1; k++) {
            double f1 = Lab1.func(x1);
            double f2 = Lab1.func(x2);
            // System.out.printf("%2d) %10.9f %10.9f %10.9f %10.9f %10.9f %10.9f %10.9f%n",
            //         k, a, b, b - a, x1, x2, f1, f2);
            result.add(new Stat(k, a, b, b - a, x1, x2, f1, f2));
            if (f1 > f2) {
                a = x1;
                x1 = x2;
                x2 = a + ((fibs[n - k - 1] * 1.0) / fibs[n - k]) * (b - a);
            } else {
                b = x2;
                x2 = x1;
                x1 = a + ((fibs[n - k - 2] * 1.0) / fibs[n - k]) * (b - a);
            }
        }
        x2 = x1 + eps;
        if (Math.abs(Lab1.func(x1) - Lab1.func(x2)) < eps) {
            a = x1;
        } else {
            b = x2;
        }

        //System.out.println(Lab1.toJson(result));

        return (a + b) / 2;
    }
}
