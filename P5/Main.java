package ProjectEuler.P5;

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
        int result = 1;
        for (int i = 1; i <= 20; i++)
        {
            result = lcm(result, i);
        }
        System.out.println(result);
    }

    public int lcm(int a, int b)
    {
        return a / gcd(a, b) * b;
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
