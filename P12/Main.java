package ProjectEuler.P12;

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
        for (int i = 1; ; i++)
        {
            long num = T(i);
            int count = 0;
            for (long j = 2; j * j <= num; j++)
            {
                if (num % j == 0)
                {
                    count++;
                    if (num / j != j)
                    {
                        count++;
                    }
                }
            }
            if (count > 500)
            {
                System.out.println(T(i));
                return;
            }
        }
    }

    public long T(long n)
    {
        return (n * (n + 1)) / 2;
    }
}
