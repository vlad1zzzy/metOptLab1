package solutions;

import java.util.List;

public class Lab1 {
    public static void main(String[] args) {
        double fib = Fibonacci.fibonacci(0.5, 4, 0.000001, 0.00001);
        double min = func(fib);
        System.out.println(fib + " " + min);
    }

    public static double func(double x) {
        return x - Math.log(x);
    }

    public static String toJson(List<Stat> stats) {
        StringBuilder s = new StringBuilder();
        s.append("[ \n");
        for (Stat stat: stats) {
            s.append("{ \n");
            s.append("\"k\" : ").append(stat.k).append(",\n");
            s.append("\"a\" : ").append(stat.a).append(",\n");
            s.append("\"b\" : ").append(stat.b).append(",\n");
            s.append("\"diff\" : ").append(stat.diff).append(",\n");
            s.append("\"x1\" : ").append(stat.x1).append(",\n");
            s.append("\"x2\" : ").append(stat.x2).append(",\n");
            s.append("\"f1\" : ").append(stat.f1).append(",\n");
            s.append("\"f2\" : ").append(stat.f2).append(",\n");
            s.append("},");
        }
        s.append(" ]");
        return s.toString();
    }
}
