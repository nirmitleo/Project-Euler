package ProjectEuler.P29;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by Nirmit on 28/07/2017.
 */
public class Main
{
    public static void main(String[] a)
    {
        Main demo = new Main();
//        demo.test1();
        demo.go();
    }


    public void go()
    {
        int N = (int) 1e2;
//        BigInteger value = new BigInteger("5070602400912917605986812821504");
        TreeSet<BigInteger> set = new TreeSet<>();
        for (int i = 1; i <= N; i = ++i)
        {
            BigInteger b = BigInteger.valueOf(i);
            BigInteger result = BigInteger.valueOf(i);
//            String s = i + ": ";
            int count = 0;
            for (int e = 2; e <= N; e++)
            {
                result = result.multiply(b);
                boolean ok = set.add(result);
                if (ok)
                {
//                    s += e + ", ";
                    count++;
                }
            }
//            System.out.println(s);
            System.out.println(i + " " + count);
            System.out.println();
        }
        System.out.println(set.size());
    }

    public void solve()
    {
        int N = 100;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 2);
        outer:
        for (int num = 2; num <= 10; num++)
        {
            if (isPrime(num))
            {
                int b = num;
                for (int e = 2; ; )
                {
                    b = b * num;
                    if (b > N)
                    {
                        continue outer;
                    }
                    int start = (N / e) + 1;
                    dp[b] = Math.min(start, 100);
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= N; i++)
        {
            count += (N - dp[i] + 1);
        }
        System.out.println(count);
    }

    public boolean isPrime(int n)
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

}
