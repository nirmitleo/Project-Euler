package ProjectEuler.P2;

/**
 * Created by Nirmit on 26/07/2017.
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
        int a = 1;
        int b = 2;
        int sum = 2;
        for (int n = 3; ; n++)
        {
            int c = a + b;
            if (c > 4e6)
            {
                System.out.println(sum);
                return;
            }
            if (c % 2 == 0)
            {
                sum += c;
            }
            a = b;
            b = c;
        }
    }
}
