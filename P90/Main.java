package ProjectEuler.P90;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by Nirmit on 15/08/2017.
 */
public class Main
{
    private int N = 6;
    private int[] num = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private int[] now = new int[N];
    private TreeSet<Item> set = new TreeSet<>();

    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
//        demo.test1();
    }

    public void test()
    {
        Item a = new Item(new int[]{0, 5, 6, 7, 8, 9});
        Item b = new Item(new int[]{1, 2, 3, 4, 8, 9});
        System.out.println(check(a, b));
    }

    public void solve()
    {
        go(0, 0);
        int n = set.size();
        System.out.println(set.size());
        Item[] b = new Item[n];
        for (int i = 0; !set.isEmpty(); i++)
        {
            b[i] = set.pollFirst();
        }
//        System.out.println(Arrays.toString(b));
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (i == j)
                {
                    continue;
                }
                if (check(b[i], b[j]))
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public boolean check(Item p, Item q)
    {
        TreeSet<Integer> P = new TreeSet<>();
        TreeSet<Integer> Q = new TreeSet<>();
        for (int i = 0; i < 6; i++)
        {
            if (p.a[i] == 6 || p.a[i] == 9)
            {
                P.add(6);
                P.add(9);
            } else
            {
                P.add(p.a[i]);
            }

            if (q.a[i] == 6 || q.a[i] == 9)
            {
                Q.add(6);
                Q.add(9);
            } else
            {
                Q.add(q.a[i]);
            }
        }

        for (int i = 1; i <= 9; i++)
        {
            int num = i * i;
            int x = num / 10;
            int y = num % 10;
            if ((P.contains(x) && Q.contains(y)) || (P.contains(y) && Q.contains(x)))
            {
                continue;
            } else
            {
                return false;
            }
        }
        return true;
    }

    public void go(int i, int j)
    {
        if (i == num.length)
        {
            if (j == N)
            {
                int[] b = now.clone();
                Item item = new Item(b);
                set.add(item);
            }
        } else
        {
            go(i + 1, j);
            if (j < N)
            {
                now[j] = num[i];
                go(i + 1, j + 1);
            }
        }
    }

    class Item implements Comparable<Item>
    {
        int[] a;

        public Item(int[] a)
        {
            Arrays.sort(a);
            this.a = a;
        }

        public int compareTo(Item that)
        {
            int lenDiff = Integer.compare(a.length, that.a.length);
            if (lenDiff == 0)
            {
                for (int i = 0; i < a.length; i++)
                {
                    int diff = Integer.compare(this.a[i], that.a[i]);
                    if (diff != 0)
                    {
                        return diff;
                    }
                }
                return 0;
            }
            return lenDiff;
        }

        public String toString()
        {
            return Arrays.toString(a);
        }
    }

}
