package ProjectEuler.P50;

/**
 * Created by Nirmit on 01/08/2017.
 */
public class Main
{
    private int P;
    private int[] primes;
    private long[] dp;

    public static void main(String[] a)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        int N = (int) 1e6;
        P = 78498;
//        P = 25;
//        P = 168;

        primes = new int[P + 1];
        dp = new long[P + 1];
        boolean[] sieve = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                sieve[j] = true;
            }
        }
        int count = 0;
        for (int i = 2, j = 1; i <= N; i++)
        {
            if (!sieve[i])
            {
                count++;
                primes[j] = i;
                dp[j] = i;
                if (j > 0)
                {
                    dp[j] += dp[j - 1];
                }
                j++;
            }
        }
//        System.out.println(count);

        for (int len = P / 5; len >= 0; len--)
        {
//            System.out.println("Current length = " + len);
            for (int i = 0; i + len < P; i++)
            {
                long diff = dp[i + len] - dp[i];
                if (diff > N)
                {
                    break;
                }
                if (isPrime(diff) && diff <= N)
                {
                    System.out.println(primes[i + 1] + " " + primes[i + len]);
                    System.out.println(len);
                    System.out.println(diff);
                    return;
                }
            }
        }

    }

    private boolean isPrime(long n)
    {
        for (int i = 1; i < P && primes[i] * primes[i] <= n; i++)
        {
            if (n % primes[i] == 0)
            {
                return false;
            }
        }
        return true;
    }
}
