package ProjectEuler.P32;

import java.util.TreeSet;

/**
 * Created by Nirmit on 28/07/2017.
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
        TreeSet<Long> set = new TreeSet<>();
        int total = 0;
        for (long i = 1; i <= 1e4; i++)
        {
            outer:
            for (long j = i; j <= 1e4; j++)
            {
                boolean[] was = new boolean[10];
                int count = 0;
                long num = i;
                while (num > 0)
                {
                    int d = (int) (num % 10);
                    if (was[d] || d == 0)
                    {
                        continue outer;
                    }
                    was[d] = true;
                    num /= 10;
                    count++;
                }
                num = j;
                while (num > 0)
                {
                    int d = (int) (num % 10);
                    if (was[d] || d == 0)
                    {
                        continue outer;
                    }
                    was[d] = true;
                    num /= 10;
                    count++;
                }
                num = i * j;
                while (num > 0)
                {
                    int d = (int) (num % 10);
                    if (was[d] || d == 0)
                    {
                        continue outer;
                    }
                    was[d] = true;
                    num /= 10;
                    count++;
                }
                if (count == 9)
                {
                    System.out.println(i + " x " + j + " = " + (i * j));
                    set.add(i * j);
                }
            }
        }
        while (!set.isEmpty())
        {
            total += set.pollFirst();
        }
        System.out.println(total);
    }
}
