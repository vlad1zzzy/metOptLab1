package solutions;

public class Fibonacci {
    public static final int[] fibs = new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233};

    public static double fibonacci(double a, double b, double l, double eps) {
        double cnst = (b - a) / l;
        int n = -1;
        for (int i = 2; i < fibs.length; i++) {
            if (fibs[i] > cnst) {
                n = i;
                break;
            }
        }
        double x1 = a + ((fibs[n - 2] * 1.0) / fibs[n]) * (b - a);
        double x2 = a + ((fibs[n - 1] * 1.0) / fibs[n]) * (b - a);
        int k = 1;
        while (k < n) {
            double f1 = Lab1.func(x1);
            double f2 = Lab1.func(x2);
            if (f1 > f2) {
                // second step
                a = x1;
                x1 = x2;
                x2 = a + ((fibs[n - k - 1] * 1.0) / fibs[n - k]) * (b - a);
                if (k == n - 2) {
                    // 5th
                    x2 = x1 + eps;
                    if (Lab1.func(x1) == Lab1.func(x2)) {
                        a = x1;
                    } else {
                        b = x2;
                    }
                    break;
                } else {
                    // f(x2) and 4th
                    k++;
                }
            } else {
                // third step
                b = x2;
                x2 = x1;
                x1 = a + ((fibs[n - k - 2] * 1.0) / fibs[n - k]) * (b - a);
                if (k == n - 2) {
                    //5th
                    x2 = x1 + eps;
                    if (Lab1.func(x1) == Lab1.func(x2)) {
                        a = x1;
                    } else {
                        b = x2;
                    }
                    break;
                } else {
                    // f(x1) and 4th
                    k++;
                }
            }

        }
        return (a + b) / 2;
    }
}
