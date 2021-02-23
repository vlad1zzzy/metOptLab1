package solutions;

public class Lab1 {
    public static void main(String[] args) {
        double fib = Fibonacci.fibonacci(0.5, 4, 0.000001, 0.00001);
        double min = func(fib);
        System.out.println(fib + " " + min);
    }

    public static double func(double x) {
        return x - Math.log(x);
    }
}
