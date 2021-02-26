package solutions;

import static java.lang.Math.*;
import static solutions.Lab1.func;

public class Brent {
    public static double findMin(double a, double c, final double eps) {
        final double k = (3 - sqrt(5)) / 2;
        double x, w, v, u = 0, fx, fw, fv, fu, d, e, g, tol;
        boolean t;
        x = w = v = a + k * (c - a);
        fx = fw = fv = func(x);
        d = e = c - a;
        do {
            t = false;
            g = e;
            e = d;
            tol = eps * abs(x) + eps / 10;
            if (abs(x - (a + c) / 2) + (c - a) / 2 <= 2 * tol) {
                break;
            }
            if (x != w && x != v && w != v && fx != fw && fx != fv && fv != fw) {
                u = x - ((x - w) * (x - w) * (fx - fv) - (x - v) * (x - v) * (x - w))
                        / (2 * ((x - w) * (fx - fv) - (x - v) * (fx - fw)));
                if (a <= u && u <= c && abs(u - x) < g / 2) {
                    t = true;
                    if (u - a < 2 * tol || c - u < 2 * tol) {
                        u = x - signum(x - (a + c) / 2) * tol;
                    }
                }
            }
            if (!t) {
                if (x < (a + c) / 2) {
                    u = x + k * (c - x);
                    e = c - x;
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
                    c = x;
                }
                v = w;
                w = x;
                x = u;
                fv = fw;
                fw = fx;
                fx = fu;
            } else {
                if (u >= x) {
                    c = u;
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
