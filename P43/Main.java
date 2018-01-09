package ProjectEuler.P43;

/**
 * Created by Nirmit on 30/07/2017.
 */
public class Main
{
    private int n = 10;
    private int[] a = new int[]{1, 0, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] a)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        long sum = 0;
        int[] primes = new int[]{1, 2, 3, 5, 7, 11, 13, 17};
        outer:
        do
        {
            for (int i = 1; i <= 7; i++)
            {
                String s = "";
                for (int j = i; j < i + 3; j++)
                {
                    s += a[j];
                }
                int num = Integer.parseInt(s);
                if (num % primes[i] != 0)
                {
                    continue outer;
                }
            }
            String s = "";
            for (int i = 0; i < 10; i++)
            {
                s += a[i];
            }
            sum += Long.parseLong(s);
        } while (nextPermutation());
        System.out.println(sum);

    }

    public boolean nextPermutation()
    {
        int i = n - 2;
        for (; i >= 0; i--)
        {
            if (a[i] < a[i + 1])
            {
                break;
            }
        }
        if (i < 0)
        {
            return false;
        }
        for (int j = n - 1; j > i; j--)
        {
            if (a[i] < a[j])
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                break;
            }
        }
        for (int start = i + 1, end = n - 1; start < end; start++, end--)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }
        return true;

    }
}
