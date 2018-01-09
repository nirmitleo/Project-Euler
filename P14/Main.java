package ProjectEuler.P14;

/**
 * Created by Nirmit on 27/07/2017.
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

        long best = 0;
        long max = 0;
        for (long i = 13; i <= N; i++)
        {
            int count = 1;
            long num = i;
            while (num != 1)
            {
                if (num % 2 == 0)
                {
                    num /= 2;
                } else
                {
                    num = 3 * num + 1;
                }
                count++;
            }
            if (count > max)
            {
                max = count;
                best = i;
            }
        }
        System.out.println(best);
    }
}
