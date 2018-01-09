package ProjectEuler.P31;

/**
 * Created by Nirmit on 28/07/2017.
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
        int N = 200;
        int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100, 200};
        int[] dp = new int[N + 1];
//        Arrays.fill(dp, -1);
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++)
        {
            for (int j = 0; j < N + 1; j++)
            {
                if (dp[j] != -1)
                {
                    if (j + coins[i] <= N)
                    {
                        dp[j + coins[i]] += dp[j];
                    }
                }
            }
        }
        System.out.println(dp[N]);
    }
}
