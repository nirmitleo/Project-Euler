package ProjectEuler.P9;

/**
 * Created by Nirmit on 26/07/2017.
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
        for (int a = 3; a <= 1000; a++)
        {
            for (int b = a + 1; b <= 1000; b++)
            {
                int c = 1000 - a - b;
                if (a * a + b * b == c * c)
                {
                    System.out.println(a * b * c);
                }
            }
        }
    }
}
