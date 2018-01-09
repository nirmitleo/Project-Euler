package ProjectEuler.P64;

import java.util.TreeMap;

/**
 * Created by Nirmit on 04/08/2017.
 */
public class Main
{
    public static void main(String[] arg)
    {
        Main demo = new Main();
        demo.solve();
    }


    public void solve()
    {
        int count = 0;
        int N = (int) 1e4;
        for (int i = 2; i <= N; i++)
        {
            int S = i;
            int m = 0;
            int d = 1;
            int a0 = (int) Math.sqrt(S);
            int a = a0;
            if (a * a == S)
            {
                continue;
            }
            TreeMap<Item, Integer> map = new TreeMap<Item, Integer>();
            for (int j = 1; ; j++)
            {
                m = d * a - m;
                d = (S - m * m) / d;
                a = (a0 + m) / d;
                Item item = new Item(m, d, a);
                Integer prev = map.get(item);
                if (prev == null)
                {
                    map.put(item, j);
                } else
                {
                    int p = j - prev;
//                    System.out.println(i + " period = " + p);
                    if (p % 2 != 0)
                    {
                        count++;
                    }
                    break;
                }
            }
        }
        System.out.println(count);
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
