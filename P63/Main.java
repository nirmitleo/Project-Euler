package ProjectEuler.P63;

import java.math.BigInteger;

/**
 * Created by Nirmit on 04/08/2017.
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
        int count = 0;
        for (int b = 1; b <= 9; b++)
        {
            for (int e = 1; e <= 21; e++)
            {
                if (check(b, e))
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private boolean check(int b, int e)
    {
        BigInteger base = BigInteger.valueOf(b);
        BigInteger result = base.pow(e);
        int count = getDigitCount(result);
        return count == e;
    }

    public int getDigitCount(BigInteger number)
    {
        double factor = Math.log(2) / Math.log(10);
        int digitCount = (int) (factor * number.bitLength() + 1);
        if (BigInteger.TEN.pow(digitCount - 1).compareTo(number) > 0)
        {
            return digitCount - 1;
        }
        return digitCount;
    }
}
