package ProjectEuler.P7;

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
        int N = (int) 1e7;
        boolean[] sieve = new boolean[N];
        for (int i = 2; i * i < N; i++)
        {
            for (int j = i * i; j < N; j += i)
            {
                sieve[j] = true;
            }
        }
        int count = 0;
        for (int i = 2; i < N; i++)
        {
            if (!sieve[i])
            {
                count++;
                if (count == 10001)
                {
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
