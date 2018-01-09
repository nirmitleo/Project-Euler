package ProjectEuler.P3;

import java.util.Arrays;

/**
 * Created by Nirmit on 26/07/2017.
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
        long num = 600851475143L;
        int N = 775147;
        boolean[] sieve = new boolean[N];
        Arrays.fill(sieve, true);
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                sieve[j] = false;
            }
        }
        for (int i = N - 1; i >= 0; i--)
        {
            if (sieve[i] && num % i == 0)
            {
                System.out.println(i);
                return;
            }
        }
    }
}
