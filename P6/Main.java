package ProjectEuler.P6;

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
        System.out.println(G(100) - F(100));
    }

    public long G(int n)
    {
        long result = n * (n + 1);
        result = result / 2;
        return result * result;
    }

    public long F(int n)
    {
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }
}
