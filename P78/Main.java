package ProjectEuler.P78;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Nirmit on 09/08/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Main demo = new Main();
//        demo.solve();
//        demo.test1();
        demo.test2();
    }

    public void test2()
    {
        int N = (int) 1e6;
        int[] p = new int[N + 1];
        for (int i = 1, j = 1; i <= N; i++)
        {
            int num = i;
            p[j] = num * (3 * num - 1);
            p[j++] /= 2;
            if (j == N + 1)
            {
                break;
            }

            num = -i;
            p[j] = num * (3 * num - 1);
            p[j++] /= 2;
            if (j == N + 1)
            {
                break;
            }
        }
        int MOD = (int) 1e6;
        long[] dp = new long[N + 1];
        dp[0] = 1l;
        for (int n = 1; n <= N; n++)
        {
            boolean positive = true;
            for (int j = 1, c = 0; j < N + 1 && n - p[j] >= 0; j++)
            {
                if (positive)
                {
                    dp[n] = dp[n] + dp[n - p[j]];
                    dp[n] %= MOD;
                } else
                {
                    dp[n] = dp[n] - dp[n - p[j]];
                    dp[n] %= MOD;
                }
                c++;
                if (c % 2 == 0)
                {
                    positive = !positive;
                }
            }
            if (dp[n] == 0)
            {
                System.out.println(n);
                return;
            }
        }

    }

    public void test1()
    {
        int N = (int) 1e6;
        int p[] = new int[N + 1];
        for (int i = 1, j = 1; i < N + 1; i++)
        {
            int num = i;
            long value = (3 * num * num - num) / 2;
            p[j++] = (int) value;
            if (j == N)
            {
                break;
            }

            num = -i;
            value = (3 * num * num - num) / 2;
            p[j++] = (int) value;
            if (j == N)
            {
                break;
            }
        }
        BigInteger dp[] = new BigInteger[N + 1];
        dp[0] = BigInteger.ONE;
        for (int n = 1; n <= N; n++)
        {
            dp[n] = BigInteger.ZERO;
            boolean pos = true;
            for (int j = 1, c = 0; j <= N && n - p[j] >= 0; j++)
            {
                if (pos)
                {
                    dp[n] = dp[n].add(dp[n - p[j]]);
                } else
                {
                    dp[n] = dp[n].subtract(dp[n - p[j]]);
                }
                c++;
                if (c % 2 == 0)
                {
                    pos = !pos;
                }
            }
            if (dp[n].mod(BigInteger.TEN.pow(6)).compareTo(BigInteger.ZERO) == 0)
            {
                System.out.println(n);
                return;
            }
        }

    }

    public void solve()
    {
        int N = (int) 1e6;
        BigInteger[] dp = new BigInteger[N + 1];
        Arrays.fill(dp, BigInteger.ZERO);
        dp[0] = BigInteger.ONE;
        for (int i = 1; i <= N; i++)
        {
            for (int j = 0; j <= N && i + j <= N; j++)
            {
                if (j + i <= N)
                {
                    dp[j + i] = dp[j + i].add(dp[j]);
                }
            }
        }
        BigInteger MOD = BigInteger.valueOf((long) 1e6);
        for (int i = 0; i < N + 1; i++)
        {
            System.out.println(dp[i] + ",");
            if (dp[i].mod(MOD).compareTo(BigInteger.ZERO) == 0)
            {
                System.out.println(i);
                System.out.println("------------------------");
                return;
            }
        }

    }
}
