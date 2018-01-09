package ProjectEuler.P10;

/**
 * Created by Nirmit on 26/07/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        int N = (int) 2e6;
//        int N = 10;
        boolean[] sieve = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                sieve[j] = true;
            }
        }
        long sum = 0;
        for (int i = 2; i <= N; i++)
        {
            if (!sieve[i])
            {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
