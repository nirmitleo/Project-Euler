package ProjectEuler.P66;

import java.math.BigInteger;

/**
 * Created by Nirmit on 05/08/2017.
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
        BigInteger max = BigInteger.ZERO;
        int Dmax = -1;
        int N = (int) 1e3;
        outer:
        for (int D = 14; D <= N; D++)
        {
            int m = 0;
            int d = 1;
            int a0 = (int) Math.sqrt(D);
            int a = a0;
            if (a * a == D)
            {
                continue;
            }
            int S = D;
            BigInteger p0 = BigInteger.valueOf(a0);
            BigInteger q0 = BigInteger.valueOf(1);

            BigInteger p1 = null;
            BigInteger q1 = null;

            for (int i = 1; ; i++)
            {
                m = d * a - m;
                d = (S - m * m) / d;
                a = (a0 + m) / d;
                if (i == 1)
                {
                    p1 = p0.multiply(BigInteger.valueOf(a)).add(BigInteger.ONE);
                    q1 = BigInteger.valueOf(a);
                    if (check(p1, q1, D))
                    {
                        if (max.compareTo(p1) < 0)
                        {
                            max = p1;
                            Dmax = D;
                        }
                        continue outer;
                    }
                } else
                {
                    BigInteger p2 = p1.multiply(BigInteger.valueOf(a)).add(p0);
                    BigInteger q2 = q1.multiply(BigInteger.valueOf(a)).add(q0);
                    if (check(p2, q2, D))
                    {
                        if (max.compareTo(p2) < 0)
                        {
                            max = p2;
                            Dmax = D;
                        }
                        continue outer;
                    }

                    p0 = p1;
                    q0 = q1;

                    p1 = p2;
                    q1 = q2;
                }

            }
        }
        System.out.println(Dmax);
    }

    public boolean check(BigInteger x, BigInteger y, int d)
    {
        x = x.multiply(x);
        y = y.multiply(y);
        y = y.multiply(BigInteger.valueOf(d));
        return x.subtract(y).compareTo(BigInteger.ONE) == 0;
    }


    class Item implements Comparable<Item>
    {
        int m;
        int d;
        int a;

        public Item(int m, int d, int a)
        {
            this.m = m;
            this.d = d;
            this.a = a;
        }

        public int compareTo(Item that)
        {
            int mDiff = Integer.compare(this.m, that.m);
            if (mDiff == 0)
            {
                int dDiff = Integer.compare(this.d, that.d);
                return dDiff != 0 ? dDiff : Integer.compare(this.a, that.a);
            }
            return mDiff;
        }
    }
}
