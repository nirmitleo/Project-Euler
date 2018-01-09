package ProjectEuler.P38;

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
        int max = 0;
        for (int i = 192; i <= 1e5; i++)
        {
            String s = "";
            for (int j = 1; ; j++)
            {
                s += (i * j);
                if (s.length() >= 9)
                {
                    if (check(s))
                    {
                        max = Math.max(max, Integer.parseInt(s));
                    }
                    break;
                }
            }
        }
        System.out.println(max);
    }

    public boolean check(String s)
    {
        int count = 0;
        boolean[] was = new boolean[10];
        for (int i = 0; i < s.length(); i++)
        {
            int d = s.charAt(i) - '0';
            if (d == 0 || was[d])
            {
                return false;
            }
            was[d] = true;
            count++;
        }
        return count == 9;
    }
}
