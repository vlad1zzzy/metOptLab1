package solutions;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static solutions.Lab1.func;

public class GoldenSection implements MinimizationMethod {
    public double findMin(double a, double b, final double eps) {
        /*System.out.printf("%12s %12s %12s %12s %12s %12s %12s %12s%n",
                "a", "b", "b - a", "ratio" ,"x1", "x2", "f1", "f2");
        double start = a, end = b;*/
        final double phi = (1 + sqrt(5)) / 2;
        final double resPhi = 2 - phi;
        double x1 = a + resPhi * (b - a);
        double x2 = b - resPhi * (b - a);
        double f1 = func(x1);
        double f2 = func(x2);
        int k = 1;
        do {
            /*System.out.printf("%2d) %11.10f %11.10f %11.10f %11.10f %11.10f %11.10f %11.10f %11.10f%n",
                    k, a, b, b - a, (b - a) / (end - start) ,x1, x2, f1, f2);*/
            if (f1 < f2) {
                b = x2;
                x2 = x1;
                f2 = f1;
                x1 = a + resPhi * (b - a);
                f1 = func(x1);
            } else {
                a = x1;
                x1 = x2;
                f1 = f2;
                x2 = b - resPhi * (b - a);
                f2 = func(x2);
            }
            k++;
        } while (abs(b - a) > eps);
        return (x1 + x2) / 2;
    }
}
