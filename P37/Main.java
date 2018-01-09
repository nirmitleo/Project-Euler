package ProjectEuler.P37;

/**
 * Created by Nirmit on 29/07/2017.
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
        int N = (int) 1e6;
        boolean[] sieve = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                sieve[j] = true;
            }
        }
        sieve[0] = true;
        sieve[1] = true;
        int sum = 0;
        outer:
        for (int i = 10; i <= N; i++)
        {
            if (!sieve[i])
            {
                String num = i + "";
                while (num.length() > 0)
                {
                    int n = Integer.parseInt(num);
                    if (sieve[n])
                    {
                        continue outer;
                    }
                    num = num.substring(1);
                }
                num = i + "";
                while (num.length() > 0)
                {
                    int n = Integer.parseInt(num);
                    if (sieve[n])
                    {
                        continue outer;
                    }
                    num = num.substring(0, num.length() - 1);
                }
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
