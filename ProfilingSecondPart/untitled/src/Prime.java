import java.util.ArrayList;

public class Prime {
    public static void main(String[] args) {
        int n = 2000000;
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }

        long sum = 0;
        for (int num : primeNumbers) {
            sum += num;
        }

        System.out.println("Sum of prime numbers up to " + n + " is equal to: " + sum);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}