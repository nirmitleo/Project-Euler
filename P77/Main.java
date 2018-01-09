package ProjectEuler.P77;

/**
 * Created by Nirmit on 09/08/2017.
 */
public class Main
{
    public static void main(String[] a)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        int N = (int) 1e5;
        int P = 9592;//1e5
        boolean[] sieve = new boolean[N + 1];
        int[] primes = new int[P];
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                sieve[j] = true;
            }
        }
//        int count = 0;
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (!sieve[i])
            {
//                count++;
                primes[j++] = i;
            }
        }
        long[] dp = new long[N + 1];
        dp[0] = 1;
        for (int i = 0; i < P; i++)
        {
            for (int j = 0; j < N + 1; j++)
            {
                if (dp[j] > 0 && primes[i] + j <= N)
                {
                    dp[primes[i] + j] += dp[j];
                }
            }
        }
        for (int i = 0; i < N + 1; i++)
        {
            if (dp[i] > 5000)
            {
                System.out.println(i);
                return;
            }
        }


    }
}
