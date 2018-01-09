package ProjectEuler.P20;

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
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= 100; i++)
        {
            result = result.multiply(BigInteger.valueOf(i));
        }
        String s = result.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++)
        {
            sum += s.charAt(i) - '0';
        }
        System.out.println(sum);
    }
}
