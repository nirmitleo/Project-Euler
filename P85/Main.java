package ProjectEuler.P85;

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
        long MAX = (long) 2e6;
        long count = 0;
        long diff = Long.MAX_VALUE;
        int result = 0;
        int X = -1;
        int Y = -1;
        for (int A = 1; A <= 1e4; A++)
        {
            for (int r = 1; r * r <= A; r++)
            {
                if (A % r == 0)
                {
                    count = getCount(r, A / r);
                    long delta = Math.abs(count - MAX);
                    if (delta < diff)
                    {
                        diff = delta;
                        result = A;
                        X = r;
                        Y = A / r;
                    }

                    count = getCount(r, A / r);
                    delta = Math.abs(count - MAX);
                    if (delta < diff)
                    {
                        diff = delta;
                        result = A;
                        X = r;
                        Y = A / r;
                    }
                }
            }
        }
        System.out.println(result + " " + X + " " + Y + " count = " + getCount(X, Y));
    }

    public long getCount(int row, int col)
    {
        long count = 0;
        for (int i = 1; i <= row; i++)
        {
            for (int j = 1; j <= col; j++)
            {
                count += (row - i + 1L) * (col - j + 1L);
            }
        }
        return count;
    }
}
