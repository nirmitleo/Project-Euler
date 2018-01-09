package ProjectEuler.P57;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Nirmit on 03/08/2017.
 */
public class Main
{
    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        int M = in.nextInt();
        BigInteger N = BigInteger.valueOf(3);
        BigInteger D = BigInteger.valueOf(2);
        int count = 0;
        for (int t = 2; t <= M; t++)
        {
            BigInteger d = N.add(D);
            BigInteger n = d.add(D);
            N = n;
            D = d;
            if (getLenth(N) > getLenth(D))
            {
                out.println(t);
            }
        }
//        out.println(count);
        out.flush();
        out.close();
    }

    public int getLenth(BigInteger n)
    {
//        int count = 0;
//        while (n.compareTo(BigInteger.ZERO) > 0)
//        {
//            n = n.divide(BigInteger.TEN);
//            count++;
//        }
//        return count;
        double factor = Math.log(2) / Math.log(10);
        int digitCount = (int) (factor * n.bitLength() + 1);
        if (BigInteger.TEN.pow(digitCount - 1).compareTo(n) > 0)
        {
            return digitCount - 1;
        }
        return digitCount;
    }
}
