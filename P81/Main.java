package ProjectEuler.P81;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Nirmit on 10/08/2017.
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
        int N = 80;
        long[][] map = new long[N][N];
        long[][] dp = new long[N][N];
        try (Scanner scanner = new Scanner(new File("./ProjectEuler/P81/sample")))
        {
            for (int i = 0; scanner.hasNext(); i++)
            {
                String[] tokens = scanner.next().split(",");
                for (int j = 0; j < tokens.length; j++)
                {
                    map[i][j] = Integer.parseInt(tokens[j]);
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            dp[0][0] = map[0][0];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (j + 1 < N)
                    {
                        dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + map[i][j + 1]);
                    }
                    if (i + 1 < N)
                    {
                        dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + map[i + 1][j]);
                    }
                }
            }
            System.out.println(dp[N - 1][N - 1]);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }
}
