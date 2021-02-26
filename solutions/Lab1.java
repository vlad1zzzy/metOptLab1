package solutions;

import java.util.List;

public class Lab1 {
    public static void main(String[] args) {
        final double eps = 0.00001;
        List<MinimizationMethod> methods = List.of(new Brent(), new Fibonacci(), new GoldenSection(), new Parabola(), new Dichotomy());
        methods.forEach(it -> solve(it, 0.5, 4, eps));
    }

    public static void solve(MinimizationMethod method, double a, double b, double eps) {
        double min = method.findMin(a, b, eps);
        double value = func(min);
        printData(method.getClass().getSimpleName(), min, value);
    }

    public static void printData(final String methodName, final double min, final double value) {
        System.out.printf("method: %-15s min: %10.9f value: %10.9f%n", methodName, min, value);
    }

    public static double func(double x) {
        return x - Math.log(x);
    }

    /*public static String toJson(List<Stat> stats) {
        StringBuilder s = new StringBuilder();
        s.append("[ \n");
        for (Stat stat : stats) {
            s.append("{ \n");
            s.append("\"k\" : ").append(stat.getK()).append(",\n");
            s.append("\"a\" : ").append(stat.getA()).append(",\n");
            s.append("\"b\" : ").append(stat.getB()).append(",\n");
            s.append("\"diff\" : ").append(stat.getDiff()).append(",\n");
            s.append("\"x1\" : ").append(stat.getX1()).append(",\n");
            s.append("\"x2\" : ").append(stat.getX2()).append(",\n");
            s.append("\"f1\" : ").append(stat.getF1()).append(",\n");
            s.append("\"f2\" : ").append(stat.getF2()).append(",\n");
            s.append("},");
        }
        s.append(" ]");
        return s.toString();
    }*/
}
