package ProjectEuler.P56;

import java.math.BigInteger;

/**
 * Created by Nirmit on 03/08/2017.
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
        int max = 0;
        for (long a = 1; a <= 100; a++)
        {
            BigInteger base = BigInteger.valueOf(a);
            for (int b = 1; b <= 100; b++)
            {
                BigInteger result = base.pow(b);
                int sum = digitSum(result);
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }

    private int digitSum(BigInteger num)
    {
        int sum = 0;
        while (num.compareTo(BigInteger.ZERO) > 0)
        {
            int d = num.mod(BigInteger.TEN).intValue();
            num = num.divide(BigInteger.TEN);
            sum += d;
        }
        return sum;
    }
}
