package ProjectEuler.P74;

import java.util.TreeSet;

/**
 * Created by Nirmit on 06/08/2017.
 */
public class Main
{
    public int[] f = new int[10];

    public static void main(String[] a)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        f[0] = 1;
        for (int i = 1; i < 10; i++)
        {
            f[i] = f[i - 1] * i;
        }

        int count = 0;
        outer:
        for (int i = 2; i < 1e6; i++)
        {
            long now = i;
            long sum = 0;
            TreeSet<Long> set = new TreeSet<>();
            set.add(now);
            while (true)
            {
                sum = getSum(now);
                if (set.contains(sum))
                {
                    if (set.size() == 60)
                    {
                        count++;
                    }
                    continue outer;
                }
                set.add(sum);
                now = sum;
            }
        }
        System.out.println(count);
    }

    public long getSum(long n)
    {
        long sum = 0;
        while (n > 0)
        {
            int d = (int) (n % 10);
            sum += f[d];
            n /= 10;
        }
        return sum;
    }
}
