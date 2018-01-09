package ProjectEuler.P34;

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
        int[] f = new int[10];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < 10; i++)
        {
            f[i] = f[i - 1] * i;
        }
        int total = 0;
        for (int i = 10; i <= 1e5; i++)
        {
            int num = i;
            int sum = 0;
            while (num > 0)
            {
                int d = num % 10;
                num /= 10;
                sum += f[d];
            }
            if (sum == i)
            {
                System.out.println(sum);
                total += sum;
            }
        }
        System.out.println(total);
    }
}
