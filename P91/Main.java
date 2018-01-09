package ProjectEuler.P91;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by Nirmit on 15/08/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
        demo.test1();
    }

    public void test1()
    {
        int N = 50;
        int count = N * N * 3;
        for (int x = 0; x <= N; x++)
        {
            for (int y = 0; y <= N; y++)
            {
                if (Math.min(x, y) == 0)
                {
                    continue;
                }
                int g = gcd(x, y);
                int nr = y / g;
                int dr = x / g;

                int n = Math.min((N - x) / nr, (y / dr));
                count += (2 * n);
            }
        }
        System.out.println(count);
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }

    public void solve()
    {
        int count = 0;
        TreeSet<Item> set = new TreeSet<>();
        int N = 50;
        for (int x1 = 0; x1 <= N; x1++)
        {
            for (int y1 = 0; y1 <= N; y1++)
            {
                for (int x2 = 0; x2 <= N; x2++)
                {
                    for (int y2 = 0; y2 <= N; y2++)
                    {
                        long A = dist(0, 0, x1, y1);
                        long B = dist(x1, y1, x2, y2);
                        long C = dist(0, 0, x2, y2);
                        long a = Math.min(A, Math.min(B, C));
                        if (a == 0)
                        {
                            continue;
                        }
                        long c = Math.max(A, Math.max(B, C));
                        long b = A + B + C - a - c;
                        if (a + b == c)
                        {
                            set.add(new Item(new Pair(x1, y1), new Pair(x2, y2)));
                        }
                    }
                }
            }
        }
        System.out.println(set.size());
        while (!set.isEmpty())
        {
            System.out.println(set.pollFirst());
        }
    }

    class Item implements Comparable<Item>
    {
        Pair[] a = new Pair[2];

        public Item(Pair x, Pair y)
        {
            a[0] = x;
            a[1] = y;
            Arrays.sort(a);
        }

        public int compareTo(Item that)
        {
            int d = a[0].compareTo(that.a[0]);
            if (d == 0)
            {
                return a[1].compareTo(that.a[1]);
            }
            return d;
        }

        public String toString()
        {
            return a[0].toString() + "----" + a[1].toString();
        }
    }

    class Pair implements Comparable<Pair>
    {
        int x;
        int y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Pair that)
        {
            int xDiff = Integer.compare(this.x, that.x);
            return xDiff != 0 ? xDiff : Integer.compare(this.y, that.y);
        }

        public String toString()
        {
            return " (" + x + "," + y + ")";
        }
    }

    public long dist(int x1, int y1, int x2, int y2)
    {
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        return x * x + y * y;
    }
}
