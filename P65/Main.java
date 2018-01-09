package ProjectEuler.P65;

import java.math.BigInteger;

/**
 * Created by Nirmit on 05/08/2017.
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
        int[] a = new int[101];
        a[0] = 2;
        a[1] = 1;
        for (int i = 2, j = 2; i < 101; i += 3, j += 2)
        {
            a[i] = j;
            if (i + 1 < 101)
            {
                a[i + 1] = 1;
            }
            if (i + 2 < 101)
            {
                a[i + 2] = 1;
            }
        }
        BigInteger[] p = new BigInteger[101];
        p[0] = BigInteger.valueOf(a[0]);
        p[1] = BigInteger.valueOf(a[1]).multiply(BigInteger.valueOf(a[0])).add(BigInteger.ONE);
        for (int i = 2; i < 101; i++)
        {
            p[i] = BigInteger.valueOf(a[i]).multiply(p[i - 1]).add(p[i - 2]);
            System.out.println(p[i]);
        }
        int sum = 0;
        BigInteger num = p[99];
        while (num.compareTo(BigInteger.ZERO) > 0)
        {
            int d = num.mod(BigInteger.TEN).intValue();
            sum += d;
            num = num.divide(BigInteger.TEN);
        }
        System.out.println(sum);


    }
}
