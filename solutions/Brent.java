package solutions;

import static java.lang.Math.*;
import static solutions.Lab1.func;

public class Brent implements MinimizationMethod {
    private double eps;

    @Override
    public double findMin(double a, double c, final double eps) {
        this.eps = eps;
        final double k = (3 - sqrt(5)) / 2;
        double x, w, v, u = 0, fx, fw, fv, fu, d, e, g, tol;
        boolean accepted;
        x = w = v = a + k * (c - a);
        fx = fw = fv = func(x);
        d = e = c - a;
        do {
            accepted = false;
            g = e;
            e = d;
            tol = eps * abs(x) + eps / 10;
            if (abs(x - (a + c) / 2) + (c - a) / 2 <= 2 * tol) {
                break;
            }
            if (threeNotEquals(x, v, w, eps)) {
                u = Parabola.minOfParabola(w, x, v, fw, fx, fv);
                if (a <= u && u <= c && abs(u - x) < g / 2) {
                    accepted = true;
                    if (u - a < 2 * tol || c - u < 2 * tol) {
                        u = x - signum(x - (a + c) / 2) * tol;
                    }
                }
            }
            if (!accepted) {
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
                if (fu <= fw || equals(w, x, eps)) {
                    v = w;
                    w = u;
                    fv = fw;
                    fw = fu;
                } else if (fu <= fv || equals(v, x, eps) || equals(v, w, eps)) {
                    v = u;
                    fv = fu;
                }
            }
        } while (true);
        return x;
    }


}
//x^2, x1 = 0.1, x2 = -0.1;