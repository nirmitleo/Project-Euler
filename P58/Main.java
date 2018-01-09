package ProjectEuler.P58;

/**
 * Created by Nirmit on 03/08/2017.
 */
public class Main
{
    private int P = 78498;
    private int N = (int) 1e6;
    private boolean[] sieve = new boolean[N + 1];
    private int[] primes = new int[P];

    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
    }

    public boolean isPrime(long n)
    {
        for (long i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public void solve()
    {
        int count = 0;
        int total = 1;
        long s = 3;
        for (long i = 2; i <= 1e6; i++, s += 2)
        {
            long num = 4 * i * i - 6 * i + 3;
            if (isPrime(num))
            {
                count++;
            }
            num = 4 * (i - 1) * (i - 1) + 1;
            if (isPrime(num))
            {
                count++;
            }
            num = 4 * i * i - 10 * i + 7;
            if (isPrime(num))
            {
                count++;
            }
            total += 4;

            double value = (count * 100) / (total * 1.0);
            if (value < 10)
            {
                System.out.println(s);
                return;
            }
//            System.out.println(+" total = " + (s * s));
        }
    }
}
