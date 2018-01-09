package ProjectEuler.P71;

/**
 * Created by Nirmit on 06/08/2017.
 */
public class Main
{
    public static void main(String[] a)
    {
        Main demo = new Main();
//        demo.test2();
//        demo.test1();
        demo.solve();
    }

    public void solve()
    {
        int a = 3;
        int b = 7;
        int bestN = 0;
        int bestD = 1;
        int diff = Integer.MAX_VALUE;
        for (int d = (int) 1e6; d >= 1; d--)
        {
            int n = (a * d - 1) / b;
            if (bestN * d < n * bestD)
            {

                bestN = n;
                bestD = d;
            }
        }
    }

    public void test()
    {
        int n = 8;
        int d = 19;
        for (; Math.max(n, d) < 1e6; n += 3, d += 7)
        {

        }
        n = n - 3;
        d = d - 7;
        int g = (int) gcd(n, d);
        System.out.println((n / g) + " " + (d / g));

    }

    public void test2()
    {
        int N = (int) 1e7;
        int N1 = 3;
        int D1 = 7;
//        long min = Long.MAX_VALUE;
        int ansN = 1;
        int ansD = 1;
        outer:
        for (int d = N; d >= 1; d--)
        {
            for (int n = 1; n < d; n++)
            {
                if (n % 3 == 0 && d % 7 == 0)
                {
                    continue;
                }
                int gcd = (int) gcd(n, d);
                if (gcd != 1)
                {
                    continue;
                }

                long diff = isLess(N1, D1, ansN, ansD, n, d);
                if (diff == -1)
                {
                    continue outer;
                }
                if (diff == -2)
                {
                    continue;
                }
                ansN = n;
                ansD = d;
//                System.out.println(min + " " + ansN + " / " + ansD);
                System.out.println(ansN + " / " + ansD);
            }
        }
//        System.out.println(min);
        System.out.println(ansN + " " + ansD);
    }


    public long isLess(int n1, int d1, int n2, int d2, int n3, int d3)
    {
        long L = lcm(d1, d2, d3);
        long a = L / d1;
        a *= n1;
        long b = L / d2;
        b *= n2;
        long c = L / d3;
        c *= n3;

        if (a < c)
        {
            return -1;
        } else
        {
            if (n2 == d2 && n2 == 1)
            {
                return n3;
            }
            if (b < c)
            {
                return n3;
            }
            return -2;
        }
    }

    public long gcd(long a, long b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long lcm(long a, long b, long c)
    {
        return lcm(a, lcm(b, c));
    }

    public long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }
}
