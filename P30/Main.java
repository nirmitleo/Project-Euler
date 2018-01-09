package ProjectEuler.P30;

/**
 * Created by Nirmit on 28/07/2017.
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
        int[] pow = new int[10];
        for (int i = 0; i < 10; i++)
        {
            pow[i] = i * i * i * i * i;
        }
        int total = 0;
        for (int i = 10; i <= 1e6; i++)
        {
            int num = i;
            int sum = 0;
            while (num > 0)
            {
                int d = num % 10;
                sum += pow[d];
                num /= 10;
            }
            if (sum == i)
            {
//                System.out.println(i);
                total += i;
            }
        }
        System.out.println(total);
    }
}
