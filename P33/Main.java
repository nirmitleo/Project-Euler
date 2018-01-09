package ProjectEuler.P33;

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
        int resultN = 1;
        int resultD = 1;
        for (int N = 10; N < 100; N++)
        {
            for (int D = N + 1; D < 100; D++)
            {
                int g = gcd(N, D);
                int n1 = N / g;
                int d1 = D / g;
                g = gcd(N / 10, D % 10);
                int n2 = N / 10 / g;
                int d2 = (D % 10) / g;
                if (n1 == n2 && d1 == d2 && (N % 10) == D / 10)
                {
                    resultN *= n1;
                    resultD *= d1;
                    System.out.println(N + "/" + D);
                }
            }
        }
        int g = gcd(resultN, resultD);
        System.out.println(resultD / g);
    }

    public int gcd(int a, int b)
    {
        return b == 0 ? a : gcd(b, a % b);
    }
}
