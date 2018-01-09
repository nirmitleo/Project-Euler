package ProjectEuler.P76;

/**
 * Created by Nirmit on 09/08/2017.
 */
public class Main
{
    public static void main(String[] a)
    {
        Main demo = new Main();
//        demo.test();
        demo.solve2();
    }

    public void solve2()
    {
        int N = 100;
        long[] dp = new long[N + 1];
        dp[0] = 1L;
        for (int coin = 1; coin <= N; coin++)
        {
            for (int j = 0; j < N + 1; j++)
            {
                if (j + coin <= N)
                {
                    dp[j + coin] += dp[j];
                }
            }
        }
        System.out.println(dp[N]);
    }

    public void solve()
    {
        int N = 100;
        int[][] dp = new int[N + 1][N + 1];
        dp[0][0] = 1;
        for (int coin = 1; coin <= N; coin++)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N + 1; j++)
                {
                    if (dp[i][j] != 0 && j + coin <= N)
                    {
                        dp[i + 1][j + coin] += dp[i][j];
                    }
                }
            }
        }
        long total = 0;
        for (int i = 2; i <= N; i++)
        {
            total += dp[i][N];
        }
        System.out.println(total);
    }
}
