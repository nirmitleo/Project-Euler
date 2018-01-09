package ProjectEuler.P47;

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
        outer:
        for (int i = 646; ; )
        {
            for (int j = i; j < i + 4; j++)
            {
                int num = j;
                int count = 0;
                for (int k = 2; k * k <= num; k++)
                {
                    int c = 0;
                    while (num % k == 0)
                    {
                        num /= k;
                        c++;
                    }
                    if (c > 0)
                    {
                        count++;
                    }
                }
                if (num > 0)
                {
                    count++;
                }
                if (count != 4)
                {
                    i = j + 1;
                    continue outer;
                }
            }
            System.out.println(i);
            return;
        }
    }
}
