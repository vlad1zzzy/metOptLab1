package solutions;

public class Lab1 {
    public static void main(String[] args) {
        double fib = Fibonacci.fibonacci(0.5, 4, 0.05, 0.01);
        System.out.println(fib);
    }

    public static double func(double x) {
        return x - Math.log(x);
    }
}
