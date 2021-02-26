package solutions;

import static java.lang.Math.*;
import static solutions.Lab1.func;

public class Brent implements MinimizationMethod{
    @Override
    public double findMin(double a, double b, final double eps) {
        final double k = (3 - sqrt(5)) / 2;
        double x, w, v, u = 0, fx, fw, fv, fu, d, e, g, tol;
        boolean t;
        x = w = v = a + k * (b - a);
        fx = fw = fv = func(x);
        d = e = b - a;
        do {
            t = false;
            g = e;
            e = d;
            tol = eps * abs(x) + eps / 10;
            if (abs(x - (a + b) / 2) + (b - a) / 2 <= 2 * tol) {
                break;
            }
            if (x != w && x != v && w != v && fx != fw && fx != fv && fv != fw) {
                u = x - ((x - w) * (x - w) * (fx - fv) - (x - v) * (x - v) * (x - w))
                        / (2 * ((x - w) * (fx - fv) - (x - v) * (fx - fw)));
                if (a <= u && u <= b && abs(u - x) < g / 2) {
                    t = true;
                    if (u - a < 2 * tol || b - u < 2 * tol) {
                        u = x - signum(x - (a + b) / 2) * tol;
                    }
                }
            }
            if (!t) {
                if (x < (a + b) / 2) {
                    u = x + k * (b - x);
                    e = b - x;
                } else {
                    u = x - k * (x - a);
                    e = x - a;
                }
            }
            if (abs(u - x) < tol) {
                u = x + signum(u - x) * tol;
            }
            d = abs(u - x);
            fu = func(u);
            if (fu <= fx) {
                if (u >= x) {
                    a = x;
                } else {
                    b = x;
                }
                v = w;
                w = x;
                x = u;
                fv = fw;
                fw = fx;
                fx = fu;
            } else {
                if (u >= x) {
                    b = u;
                } else {
                    a = u;
                }
                if (fu <= fw || w == x) {
                    v = w;
                    w = u;
                    fv = fw;
                    fw = fu;
                } else if (fu <= fv || v == x || v == w) {
                    v = u;
                    fv = fu;
                }
            }
        } while (true);
        return x;
    }
}
