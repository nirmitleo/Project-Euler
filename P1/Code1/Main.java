package ProjectEuler.P1.Code1;

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
        int sum = 3 * T(999 / 3);
        sum += 5 * T(999 / 5);
        sum -= 15 * T(999 / 15);
        System.out.println(sum);
    }

    public int T(int n)
    {
        return n * (n + 1) / 2;
    }
}
