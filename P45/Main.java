package ProjectEuler.P45;

import java.util.Arrays;

/**
 * Created by Nirmit on 01/08/2017.
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
        int N = (int) 1e6;
        long[] T = new long[N + 1];
        long[] P = new long[N + 1];
        long[] H = new long[N + 1];
        for (int i = 1; i < N + 1; i++)
        {
            long n = i;
            T[i] = (n * (n + 1)) / 2;
            P[i] = (n * (3 * n - 1)) / 2;
            H[i] = n * (2 * n - 1);
//            System.out.println(T[i] + " " + P[i] + " " + H[i]);
        }
        for (int i = 2; i < N + 1; i++)
        {
            long num = T[i];
            if (i == 285)
            {
                System.out.println("HI");
            }
            int index = Arrays.binarySearch(P, num);
            if (index >= 0 && index <= N)
            {
                index = Arrays.binarySearch(H, num);
                if (index >= 0 && index <= N)
                {
                    System.out.println(T[i]);
                }
            }
        }
    }
}
