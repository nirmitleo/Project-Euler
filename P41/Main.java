package ProjectEuler.P41;

/**
 * Created by Nirmit on 30/07/2017.
 */
public class Main
{
    private int n = 7;
    private int[] a = new int[]{7, 6, 5, 4, 3, 2, 1};
    private int P = 1229;
    private int[] primes = new int[P];

    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        int N = (int) 1e4;
        boolean[] sieve = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                sieve[j] = true;
            }
        }
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (!sieve[i])
            {
                primes[j++] = i;
            }
        }

        do
        {
            String s = "";
            for (int i = 0; i < n; i++)
            {
                s += a[i];
            }
            long num = Long.parseLong(s);
            if (isPrime(num))
            {
                System.out.println(num);
                return;
            }
        } while (nextPermutation());
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

    public boolean nextPermutation()
    {
        int i = n - 2;
        for (; i >= 0; i--)
        {
            if (a[i] > a[i + 1])
            {
                break;
            }
        }
        if (i < 0)
        {
            return false;
        }
        for (int j = n - 1; j > i; j--)
        {
            if (a[i] > a[j])
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                break;
            }
        }
        for (int start = i + 1, end = n - 1; start < end; start++, end--)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }
        return true;
    }
}
