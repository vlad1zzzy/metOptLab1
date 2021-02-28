package solutions;

import static solutions.Lab1.func;

public class Dichotomy implements MinimizationMethod {
    private double s = 0.00000001;

    public void setS(double s) {
        this.s = s;
    }

    @Override
    public double findMin(double a, double b, final double eps) {
        int k = 1;
        //double start = a, end = b;
        /*System.out.printf("%12s %12s %12s %12s %12s %12s %12s %12s%n",
                "a", "b", "b - a", "ratio" ,"x1", "x2", "f1", "f2");*/
        double x1, x2, f1, f2;
        if (s > eps) {
            s = eps;
        }
        do {
            x1 = (a + b - s) / 2;
            x2 = (a + b + s) / 2;
            f1 = func(x1);
            f2 = func(x2);
            /*System.out.printf("%2d) %11.10f %11.10f %11.10f %11.10f %11.10f %11.10f %11.10f %11.10f%n",
                    k, a, b, b - a, (b - a) / (end - start) ,x1, x2, f1, f2);*/
            if (f1 <= f2) {
                b = x2;
            } else {
                a = x1;
            }
            k++;
        } while ((b - a) / 2 >= eps);
        return (a + b) / 2;
    }
}
