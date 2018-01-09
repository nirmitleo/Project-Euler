package ProjectEuler.P16;

import java.math.BigInteger;

/**
 * Created by Nirmit on 27/07/2017.
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
        BigInteger b = BigInteger.valueOf(2L);
        int e = (int) 1e3;
        BigInteger result = pow(b, e);
        String s = result.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int num = s.charAt(i) - '0';
            sum += num;
        }
        System.out.println(sum);
    }

    public BigInteger pow(BigInteger b, int e)
    {
        BigInteger result = BigInteger.ONE;
        while (e > 0)
        {
            if (e % 2 != 0)
            {
                result = result.multiply(b);
            }
            b = b.multiply(b);
            e = e / 2;
        }
        return result;
    }
}
