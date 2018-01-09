package ProjectEuler.P53;

import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Nirmit on 02/08/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
//        demo.test1();
    }

    public void solve()
    {
        int count = 0;
        for (int N = 1; N <= 100; N++)
        {
            for (int R = 1; R <= N / 2; R++)
            {
                TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
                for (int i = N, j = R; j >= 1; j--, i--)
                {
                    int num = i;
                    for (int f = 2; f * f <= num; f++)
                    {
                        int c = 0;
                        while (num % f == 0)
                        {
                            num /= f;
                            c++;
                        }
                        if (c > 0)
                        {
                            Integer cc = map.get(f);
                            cc = cc == null ? c : cc + c;
                            map.put(f, cc);
                        }
                    }
                    if (num > 1)
                    {
                        Integer cc = map.get(num);
                        cc = cc == null ? 1 : cc + 1;
                        map.put(num, cc);
                    }
                    num = j;
                    for (int f = 2; f * f <= num; f++)
                    {
                        int c = 0;
                        while (num % f == 0)
                        {
                            num /= f;
                            c++;
                        }
                        if (c > 0)
                        {
                            Integer cc = map.get(f);
                            cc = cc == null ? -c : cc - c;
                            map.put(f, cc);
                        }
                    }
                    if (num > 1)
                    {
                        Integer cc = map.get(num);
                        cc = cc == null ? -1 : cc - 1;
                        map.put(num, cc);
                    }
                }
                long result = 1;
                outer:
                for (Map.Entry<Integer, Integer> entry : map.entrySet())
                {
                    int f = entry.getKey();
                    int e = entry.getValue();
                    if (e < 0)
                    {
                        throw new RuntimeException();
                    }
                    for (int k = 1; k <= e; k++)
                    {
                        result *= f;
                        if (result > 1e6)
                        {
                            count++;
                            if (N - R != R)
                            {
                                count++;
                            }
                            break outer;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public void test()
    {
        int count = 0;
        BigInteger MAX = BigInteger.TEN.pow(6);
        for (int n = 1; n <= 100; n++)
        {
            for (int r = 1; r <= n; r++)
            {
                BigInteger R = BigInteger.ONE;
                BigInteger N = BigInteger.ONE;
                for (int i = 1, j = n; i <= r; i++, j--)
                {
                    R = R.multiply(BigInteger.valueOf(i));
                    N = N.multiply(BigInteger.valueOf(j));
                }
                if (N.divide(R).compareTo(MAX) > 0)
                {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
