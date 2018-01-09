package ProjectEuler.P70;

/**
 * Created by Nirmit on 06/08/2017.
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
        int N = (int) 1e7;
        double R = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 2; i < N; i++)
        {
            int t = getTotient(i);
            if (check(i, t))
            {
                double r = i / (t * 1.0);
                if (R > r)
                {
                    R = r;
                    ans = i;
                }
            }
        }
        System.out.println(ans);
    }

    public boolean check(int num1, int num2)
    {
        if (getLength(num1) != getLength(num2))
        {
            return false;
        }
        int[] digits = new int[10];
        while (num1 > 0)
        {
            int d = num1 % 10;
            digits[d]++;
            num1 /= 10;
        }
        while (num2 > 0)
        {
            int d = num2 % 10;
            digits[d]--;
            if (digits[d] < 0)
            {
                return false;
            }
            num2 /= 10;
        }
        return true;
    }

    public int getLength(int n)
    {
        return (int) (Math.log10(n)) + 1;
    }
    public int getTotient(int n)
    {
        int result = n;
        for (int i = 2; i * i <= n; i++)
        {
            int count = 0;
            while (n % i == 0)
            {
                n /= i;
                count++;
            }
            if (count > 0)
            {
                result = result - (result / i);
            }
        }
        if (n > 1)
        {
            result = result - (result / n);
        }
        return result;
    }
}
