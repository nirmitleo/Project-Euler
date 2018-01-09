package ProjectEuler.P97;

/**
 * Created by Nirmit on 16/08/2017.
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
        long MOD = 1000L * 1000 * 1000 * 10L;
        long num = 28433;
        for (int i = 1; i <= 7830457; i++)
        {
            num = num * 2;
            num = num % MOD;
        }
        System.out.println(num + 1);
    }
}
