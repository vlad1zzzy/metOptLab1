import {func, stats} from "./main.js";

export {brent}

function brent(a, b, eps) {
    let step = 1;
    const k = (3 - Math.sqrt(5)) / 2;
    let x, w, v, u = 0, fx, fw, fv, fu, d, e, g, tol;
    let t;
    x = w = v = a + k * (b - a);
    fx = fw = fv = func(x);
    d = e = b - a;
    do {
        stats.push([step, ...[a, b, x, w, v, fx, fw, fv].map(el => el.toFixed(10))])
        t = false;
        g = e;
        e = d;
        tol = eps * Math.abs(x) + eps / 10;
        if (Math.abs(x - (a + b) / 2) + (b - a) / 2 <= 2 * tol) {
            break;
        }
        if (x !== w && x !== v && w !== v && fx !== fw && fx !== fv && fv !== fw) {
            u = x - ((x - w) * (x - w) * (fx - fv) - (x - v) * (x - v) * (x - w))
                / (2 * ((x - w) * (fx - fv) - (x - v) * (fx - fw)));
            if (a <= u && u <= b && Math.abs(u - x) < g / 2) {
                t = true;
                if (u - a < 2 * tol || b - u < 2 * tol) {
                    u = x - Math.sign(x - (a + b) / 2) * tol;
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
        if (Math.abs(u - x) < tol) {
            u = x + Math.sign(u - x) * tol;
        }
        d = Math.abs(u - x);
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
            if (fu <= fw || w === x) {
                v = w;
                w = u;
                fv = fw;
                fw = fu;
            } else if (fu <= fv || v === x || v === w) {
                v = u;
                fv = fu;
            }
        }
        step++;
    } while (true);
    return x;
}