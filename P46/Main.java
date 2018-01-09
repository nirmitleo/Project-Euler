package ProjectEuler.P46;

/**
 * Created by Nirmit on 01/08/2017.
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
        int N = (int) 1e6;
        boolean[] sieve = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                sieve[j] = true;
            }
        }
        int S = (int) 1e3;
        int[] sq = new int[S + 1];
        for (int i = 0; i < S + 1; i++)
        {
            sq[i] = i * i;
        }
        outer:
        for (int i = 3; ; i += 2)
        {
            if (sieve[i])
            {
                for (int j = 0; j < S && 2 * sq[j] <= i; j++)
                {
                    int diff = i - 2 * sq[j];
                    if (diff >= 0 && !sieve[diff])
                    {
                        continue outer;
                    }
                }
                System.out.println(i);
                return;
            }
        }
    }
}
