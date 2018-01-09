package ProjectEuler.P52;

/**
 * Created by Nirmit on 02/08/2017.
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
        for (long i = (long) 1e5; ; i++)
        {
            String num1 = i + "";
            for (int j = 1; j <= 6; j++)
            {
                String num2 = (i * j) + "";
                if (num1.length() != num2.length())
                {
                    continue outer;
                }
                for (int k = 0; k < num1.length(); k++)
                {
                    char ch = num1.charAt(k);
                    if (!num2.contains(ch + ""))
                    {
                        continue outer;
                    }
                }
            }
            System.out.println(i);
            return;
        }
    }
}
