package ProjectEuler.P44;

import java.util.Arrays;

/**
 * Created by Nirmit on 30/07/2017.
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
        int N = (int) 1e4;
        long[] p = new long[N + 1];
        for (int i = 1; i <= N; i++)
        {
            p[i] = i * (3 * i - 1);
            p[i] /= 2;
        }
        long min = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++)
        {
            for (int j = i + 1; j <= N; j++)
            {
                long sum = p[i] + p[j];
                long diff = p[j] - p[i];
                int index = Arrays.binarySearch(p, sum);
                if (index >= 0 && index <= N)
                {
                    index = Arrays.binarySearch(p, diff);
                    if (index >= 0 && index <= N)
                    {
                        min = Math.min(min, diff);
                    }
                }
            }
        }
        System.out.println(min);
    }
}
