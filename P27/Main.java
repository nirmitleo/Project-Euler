package ProjectEuler.P27;

/**
 * Created by Nirmit on 27/07/2017.
 */
public class Main
{
    private int P = 78498;
    private int[] primes = new int[P];

    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        int N = (int) 1e6;
        boolean[] sieve = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                sieve[j] = true;
            }
        }
        int count = 0;
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (!sieve[i])
            {
                primes[j++] = i;
                count++;
            }
        }
//        System.out.println(count);

        int max = 0;
        long prod = 1;
        for (int a = -1000; a <= 1000; a++)
        {
            for (int b = -1000; b <= 1000; b++)
            {
                for (int i = 0; ; i++)
                {
                    int p = Math.abs(i * i + a * i + b);
                    if (!isPrime(p))
                    {
                        if (max < i)
                        {
                            max = i;
                            prod = a * b;
                        }
//                        System.out.println(a + " " + b + " " + i + " " + max);
                        break;
                    }
                }
            }
        }
        System.out.println(prod);
    }

    public boolean isPrime(long n)
    {
        for (int i = 0; i < P && primes[i] * 1L * primes[i] <= n; i++)
        {
            if (n % primes[i] == 0)
            {
                return false;
            }
        }
        return true;
    }
}
