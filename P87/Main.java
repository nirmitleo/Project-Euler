package ProjectEuler.P87;

import java.util.TreeSet;

/**
 * Created by Nirmit on 11/08/2017.
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
        int N = (int) 8000;
        int M = (int) 50e6;
        int P = 1007;
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
        for (int i = 2, j = 0; i < N + 1; i++)
        {
            if (!sieve[i])
            {
                primes[j++] = i;
//                count++;
            }
        }
//        System.out.println(count);
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < P; i++)
        {
            long first = sq(primes[i]);
            for (int j = 0; j < P; j++)
            {
                long second = cube(primes[j]);
                for (int k = 0; k < P && first + second < M; k++)
                {
                    long third = fourth(primes[k]);
                    long sum = first + second + third;
                    if (sum <= M)
                    {
                        set.add(sum);
//                        System.out.println(set.size());

                    }
                }
            }
        }
        System.out.println(set.size());
    }

    public long sq(long x)
    {
        return x * x;
    }

    public long cube(long x)
    {
        return sq(x) * x;
    }

    public long fourth(long x)
    {
        long result = sq(x);
        return result * result;
    }
}
