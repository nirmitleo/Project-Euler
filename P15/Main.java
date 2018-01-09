package ProjectEuler.P15;

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
        int n = 20;
        BigInteger nr = BigInteger.ONE;
        BigInteger dr = BigInteger.ONE;
        for (int i = 40; i >= 21; i--)
        {
            nr = nr.multiply(BigInteger.valueOf(i));
        }
        for (int i = 20; i >= 1; i--)
        {
            dr = dr.multiply(BigInteger.valueOf(i));
        }
        System.out.println(nr.divide(dr));
    }
}
