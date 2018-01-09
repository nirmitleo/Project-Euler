package ProjectEuler.P35;

/**
 * Created by Nirmit on 29/07/2017.
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
        int total = 0;
        outer:
        for (int i = 2; i <= N; i++)
        {
            String now = i + "";
            int count = now.length();
            while (count-- > 0)
            {
                int num = Integer.parseInt(now);
                if (sieve[num])
                {
                    continue outer;
                }
                now = rotate(now);
            }
            System.out.println(now);
            total++;
        }
        System.out.println(total);
    }

    public String rotate(String s)
    {
        return s.substring(1) + s.charAt(0);
    }
}
