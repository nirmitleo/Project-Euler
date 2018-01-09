package ProjectEuler.P69;

/**
 * Created by Nirmit on 05/08/2017.
 */
public class Main
{
    private int P = 78498;
    private int[] primes = new int[P];

    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
//        demo.test1();
    }

    public void test()
    {
        System.out.println(getTotient(9));
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
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (!sieve[i])
            {
                primes[j++] = i;
            }
        }
        int result = -1;
        double max = 0;
        for (int i = 2; i <= N; i++)
        {
            double r = i / (getTotient(i) * 1.0);
            if (max < r)
            {
                max = r;
                result = i;
            }
        }
        System.out.println(result);
    }

    public long getTotient(int n)
    {
        int result = n;
        for (int i = 2; i * i <= n; i++)
        {
            int count = 0;
            while (n % i == 0)
            {
                count++;
                n /= i;
            }
            if (count > 0)
            {
                result = (result - (result / i));
            }
        }
        if (n > 1)
        {
            result = (result - (result / n));
        }
        return result;
    }

    public long pow(long b, int e)
    {
        long result = 1;
        while (e > 0)
        {
            if (e % 2 != 0)
            {
                result = result * b;
            }
            e /= 2;
            b = b * b;
        }
        return result;
    }

}
