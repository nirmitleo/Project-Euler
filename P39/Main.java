package ProjectEuler.P39;

import java.util.Arrays;

/**
 * Created by Nirmit on 29/07/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        int S = (int) 1e3 + 1;
        int N = 1000;
        int[] sq = new int[S];
        for (int i = 0; i < S; i++)
        {
            sq[i] = i * i;
        }
        int[] dp = new int[N + 1];
        outer:
        for (int a = 1; a <= N; a++)
        {
            for (int b = a; b <= N; b++)
            {
                int c = (a * a) + (b * b);
                int index = Arrays.binarySearch(sq, c);
                if (index >= 0 && index < S)
                {
                    int p = a + b + index;
                    if (p > N)
                    {
                        continue outer;
                    }
                    dp[p]++;
                }
            }
        }
        int max = 0;
        int result = 0;
        for (int i = 0; i <= N; i++)
        {
            if (max < dp[i])
            {
                max = dp[i];
                result = i;
            }
        }
        System.out.println(result);
    }
}
