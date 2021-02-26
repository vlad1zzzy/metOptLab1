package solutions;

import static solutions.Lab1.func;

public class Dichotomy implements MinimizationMethod {
    private double s = 0.00000001;

    public void setS(double s) {
        this.s = s;
    }

    @Override
    public double findMin(double a, double b, final double eps) {
        double x1, x2;
        if (s > eps) {
            s = eps;
        }
        do {
            x1 = (a + b - s) / 2;
            x2 = (a + b + s) / 2;
            if (func(x1) <= func(x2)) {
                b = x2;
            } else {
                a = x1;
            }
            System.out.println(a + " " + b);
        } while ((b - a) / 2 >= eps);
        return (a + b) / 2;
    }
}
