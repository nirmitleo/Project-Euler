package ProjectEuler.P80;

import java.math.BigDecimal;

/**
 * Created by Nirmit on 09/08/2017.
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
        int T = (int) 1e2;
        long total = 0;
        for (int i = 2; i <= 100; i++)
        {
            int sq = (int) Math.sqrt(i);
            if (sq * sq == i)
            {
                continue;
            }

            BigDecimal ans = sqrt(i, T + 2);
            String s = ans.toString();
            int dot = s.indexOf(".");
            String t = s.substring(0, dot);
            t += s.substring(dot + 1);
            for (int d = 0; d < 100; d++)
            {
                int digit = t.charAt(d) - '0';
                total += digit;
            }
        }
        System.out.println(total);
    }

    public BigDecimal sqrt(int n, int t)
    {
        BigDecimal T = BigDecimal.valueOf(1 / 10.0).pow(t);
//        System.out.println("String = " + T.toPlainString());
        BigDecimal N = BigDecimal.valueOf(n);
        BigDecimal now = BigDecimal.valueOf((int) Math.sqrt(n) + 1);
        for (; ; )
        {
            BigDecimal next = now.subtract(f(now, N).divide(fDash(now), 200, BigDecimal.ROUND_UP));
            if (now.subtract(next).compareTo(T) <= 0)
            {
                return next;
            }
            now = next;
        }
    }

    public BigDecimal f(BigDecimal x, BigDecimal n)
    {
        return (x.multiply(x)).subtract(n);
    }

    public BigDecimal fDash(BigDecimal x)
    {
        return x.multiply(BigDecimal.valueOf(2));
    }

}
