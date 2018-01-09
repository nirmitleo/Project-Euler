package ProjectEuler.P49;

import java.util.*;

/**
 * Created by Nirmit on 01/08/2017.
 */
public class Main
{
    private int[] p;

    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        for (int a = 0; a <= 9; a++)
        {
            for (int b = a; b <= 9; b++)
            {
                for (int c = b; c <= 9; c++)
                {
                    outer:
                    for (int d = c; d <= 9; d++)
                    {
                        p = new int[4];
                        p[0] = a;
                        p[1] = b;
                        p[2] = c;
                        p[3] = d;
                        Arrays.sort(p);
                        TreeSet<Integer> set = new TreeSet<Integer>();
                        do
                        {
                            int num = p[0] * 1000 + p[1] * 100 + p[2] * 10 + p[3];
                            if (num >= 1000 && isPrime(num))
                            {
                                set.add(num);
                            }
                        } while (nextPermutation());
                        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
                        if (set.size() > 2)
                        {
                            int[] t = new int[set.size()];
                            for (int i = 0; !set.isEmpty(); i++)
                            {
                                int now = set.pollFirst();
                                t[i] = now;
                            }
                            for (int i = 0; i < t.length; i++)
                            {
                                for (int j = i + 1; j < t.length; j++)
                                {
                                    int diff = t[j] - t[i];
                                    ArrayList<Integer> temp = map.get(diff);
                                    if (temp == null)
                                    {
                                        temp = new ArrayList<>();
                                        temp.add(t[i]);
                                        temp.add(t[j]);
                                        map.put(diff, temp);
                                    } else
                                    {
                                        temp.add(t[j]);
                                    }
                                }
                            }
                            here:
                            for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
                            {
                                int diff = entry.getKey();
                                ArrayList<Integer> list = entry.getValue();
                                if (list.size() > 2)
                                {
                                    for (int i = 1; i < list.size(); i++)
                                    {
                                        if (list.get(i) - list.get(i - 1) != diff)
                                        {
                                            continue here;
                                        }
                                    }
                                    System.out.println(list.toString());
                                }
                            }
//                            System.out.println("*********************");
                        }
                    }
                }
            }
        }
    }

    private boolean isPrime(int n)
    {
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public boolean nextPermutation()
    {
        int n = p.length;
        int i = n - 2;
        for (; i >= 0; i--)
        {
            if (p[i] < p[i + 1])
            {
                break;
            }
        }
        if (i < 0)
        {
            return false;
        }
        for (int j = n - 1; j > i; j--)
        {
            if (p[i] < p[j])
            {
                int temp = p[j];
                p[j] = p[i];
                p[i] = temp;
                break;
            }
        }
        for (int start = i + 1, end = n - 1; start < end; start++, end--)
        {
            int temp = p[start];
            p[start] = p[end];
            p[end] = temp;
        }
        return true;
    }
}
