package ProjectEuler.P75;

/**
 * Created by Nirmit on 09/08/2017.
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
        int N = (int) 15e5;
        int[] dp = new int[N + 1];
        for (long m = 2; m * m < N; m++)
        {
            for (long n = 1; m * m + n * n <= N && n < m; n++)
            {
                if (!isSameParity(m, n) && gcd(m, n) == 1)
                {
                    long a = m * m - n * n;
                    long b = 2 * m * n;
                    long c = m * m + n * n;
                    int p = (int) (a + b + c);
                    for (int k = 1; k * c <= N; k++)
                    {
                        int index = p * k;
                        if (index >= 0 && index <= N)
                        {
                            dp[index]++;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N + 1; i++)
        {
            if (dp[i] == 1)
            {
                count++;
            }
            if (i < 121)
            {
                System.out.println(i + " = " + dp[i]);
            }
        }
        System.out.println(count);

    }

    public boolean isSameParity(long a, long b)
    {
        return (isEven(a) && isEven(b)) || (!isEven(a) && !isEven(b));
    }

    public boolean isEven(long a)
    {
        return a % 2 == 0;
    }


    public long gcd(long a, long b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
