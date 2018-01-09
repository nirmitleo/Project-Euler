package ProjectEuler.P72;

/**
 * Created by Nirmit on 06/08/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Main demo = new Main();
        demo.solve();
//        demo.test1();
    }


    public void test()
    {
        System.out.println(getTotient(2));
    }

    public void solve()
    {
        long count = 0;
        for (int i = 2; i < 1e6 + 1; i++)
        {
            count += getTotient(i);
        }
        System.out.println(count);
    }

    public int getTotient(int n)
    {
        int result = n;
        for (int i = 2; i * i <= n; i++)
        {
            int count = 0;
            while (n % i == 0)
            {
                count++;
                n /= i;
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
