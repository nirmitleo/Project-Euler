package ProjectEuler.P25;

import java.math.BigInteger;

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
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        for (int i = 3; ; i++)
        {
            BigInteger c = a.add(b);
            String s = c.toString();
            if (s.length() >= 1000)
            {
                System.out.println(i);
                return;
            }
            a = b;
            b = c;
        }
    }
}
