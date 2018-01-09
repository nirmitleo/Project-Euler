package ProjectEuler.P40;

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
        int max = (int) 1e6;
        int now = 1;
        int count = 0;
        int result = 1;
        for (int i = 1; ; i++)
        {
            String num = (i + "");
            for (int j = 0; j < num.length(); j++)
            {
                int d = num.charAt(j) - '0';
                count++;
                if (count == now)
                {
                    result *= d;
                    now *= 10;
                    if (now > max)
                    {
                        System.out.println(result);
                        return;
                    }
                }
            }
        }
    }
}
