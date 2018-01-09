package ProjectEuler.P48;

import java.math.BigInteger;

/**
 * Created by Nirmit on 01/08/2017.
 */
public class Main
{
    private final static BigInteger MOD = BigInteger.valueOf((long) 1e10);

    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
    }

//    public void test3()
//    {
//        BigInteger num = BigInteger.valueOf(MOD);
//        while (true)
//        {
//            num = num.nextProbablePrime();
//            for(int i = 0)
//        }
//    }

    public void solve()
    {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger i = BigInteger.ONE; i.compareTo(BigInteger.valueOf((long)1e3)) <= 0; i = i.add(BigInteger.ONE))
        {
            sum = sum.add(i.modPow(i, MOD));
            sum = sum.mod(MOD);
        }
        System.out.println(sum);
    }

}
