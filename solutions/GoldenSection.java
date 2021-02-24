package solutions;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static solutions.Lab1.func;

public class GoldenSection {
    static double findMin(double l, double r, double eps) {
        final double phi = (1 + sqrt(5)) / 2;
        final double resphi = 2 - phi;
        double x1 = l + resphi * (r - l);
        double x2 = r - resphi * (r - l);
        double f1 = func(x1);
        double f2 = func(x2);
        do {
            if (f1 < f2) {
                r = x2;
                x2 = x1;
                f2 = f1;
                x1 = l + resphi * (r - l);
                f1 = func(x1);
            } else {
                l = x1;
                x1 = x2;
                f1 = f2;
                x2 = r - resphi * (r - l);
                f2 = func(x2);
            }
        } while (abs(r - l) > eps);
        return (x1 + x2) / 2;
    }
}
