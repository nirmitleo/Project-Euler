package ProjectEuler.P100;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Nirmit on 18/08/2017.
 */
public class Main
{
    public static void main(String[] a)
    {
        Main demo = new Main();
//        demo.test();
//        demo.test();
        demo.test1();
//        demo.test2();
    }

    public void test()
    {
        for (long i = 1; i <= 1e14; i++)
        {
            double nr = (1 + Math.sqrt(1 + 8 * i * (i + 1)));
            if (nr % 2 == 0)
            {
                System.out.println(((long) (nr / 2.0)));
            }
        }
    }

    public void test1()
    {
        BigDecimal prev = BigDecimal.ONE;
        BigDecimal now = BigDecimal.valueOf(3);
        BigDecimal SIX = BigDecimal.valueOf(6);
        BigDecimal TWO = BigDecimal.valueOf(2);
//        System.out.println(prev);
//        System.out.println(now);
        for (long i = 2; i < 30; i++)
        {
            BigDecimal next = now.multiply(SIX).subtract(prev).subtract(TWO);

            prev = now;
            now = next;

            BigDecimal blue = next;
            BigInteger total = getTotalBalls(blue);
            System.out.println(blue + " " + total);
            if (total.compareTo(BigInteger.TEN.pow(12)) > 0)
            {
                return;
            }
        }
    }

    public BigInteger getTotalBalls(BigDecimal blue)
    {
        BigDecimal EIGHT = BigDecimal.valueOf(8);
        BigDecimal prod = blue.multiply(blue.add(BigDecimal.ONE));
        BigDecimal nr = BigDecimal.ONE.add(EIGHT.multiply(prod));

        BigDecimal ret = sqrt(nr).divide(BigDecimal.valueOf(2), 12, BigDecimal.ROUND_UP);
        return ret.toBigInteger();
    }

    public void test2()
    {
        double n = 36;
        System.out.println(sqrt(new BigDecimal(n)));
    }

    public BigDecimal sqrt(BigDecimal n)
    {
        BigDecimal now = n;
        BigDecimal next = BigDecimal.ONE;
        BigDecimal T = BigDecimal.valueOf(0.1).pow(9);
        for (; ; )
        {
            BigDecimal r = f(now, n).divide(fd(now), 10, BigDecimal.ROUND_UP);
            next = now.subtract(r);
            if (now.subtract(next).compareTo(T) <= 0)
            {
                return next;
            }
            now = next;
        }
    }

    public BigDecimal f(BigDecimal x, BigDecimal n)
    {
        BigDecimal result = x.multiply(x);
        return result.subtract(n);
    }

    public BigDecimal fd(BigDecimal x)
    {
        return x.multiply(BigDecimal.valueOf(2));
    }

    public double sqrt(double n)
    {
        double now = 2;
        double next = 0;
        for (; ; )
        {
            next = now - (f(now, n) / df(now));
            if (Math.abs(next - now) <= 1e-6)
            {
                return next;
            }
            now = next;
        }
    }

    public double f(double x, double n)
    {
        return x * x - n;
    }

    public double df(double x)
    {
        return 2 * x;
    }
}
