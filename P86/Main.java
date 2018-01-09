package ProjectEuler.P86;

/**
 * Created by Nirmit on 10/08/2017.
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
        int count = 0;
//        int M = 3000;
        for (int a = 1; ; a++)
        {
            for (int b = 1; b <= a; b++)
            {
                for (int c = 1; c <= b; c++)
                {
                    int sum = (b + c) * (b + c) + a * a;
                    int sqrt = (int) Math.sqrt(sum);
                    if (sqrt * sqrt == sum)
                    {
                        count++;
                        if (count > 1e6)
                        {
                            System.out.println(a);
                            return;
                        }
                    }
                }
            }
        }
//        System.out.println(count);
    }
}
