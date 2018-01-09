package ProjectEuler.P21;

/**
 * Created by Nirmit on 27/07/2017.
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
        int result = 0;
        for (int a = 1; a < 1e4; a++)
        {
            int b = D(a);
            int c = D(b);
            if (c == a && b != a)
            {
                result += a + b;
            }
        }
        System.out.println(result / 2);
    }

    public int D(int n)
    {
        int sum = 1;
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                sum += i;
                if (n / i != i)
                {
                    sum += n / i;
                }
            }
        }
        return sum;
    }
}
