public class Prime {
    public static void main(String[] args) {
        int n = 2000000;
        boolean[] isPrime = isPrime(n);

        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                sum += i;
            }
        }

        System.out.println("Sum of prime numbers up to " + n + " is equal to: " + sum);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean[] isPrime(int num) {
        boolean[] isPrime = new boolean[num + 1];
        for (int i = 2; i <= num; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= num; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= num; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        return isPrime;
    }
}