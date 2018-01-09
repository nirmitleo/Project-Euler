package ProjectEuler.P4;

/**
 * Created by Nirmit on 26/07/2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Main demo = new Main();
//        demo.test1();
        demo.test();
    }

    public void test()
    {
        for (int a = 9; a >= 0; a--)
        {
            for (int b = 9; b >= 0; b--)
            {
                for (int c = 9; c >= 0; c--)
                {
                    int num = a * 100000 + b * 10000 + c * 1000 + c * 100 + b * 10 + a;
                    for (int i = 100; i * i <= num; i++)
                    {
                        if (num % i == 0)
                        {
                            int d = num / i;
                            if (d >= 100 && d <= 999)
                            {
                                System.out.println(num);
                                return;
                            }
                        }
                    }
                }
            }
        }

    }

    public void solve()
    {
        int best = -1;
        for (int a = 100; a <= 999; a++)
        {
            outer:
            for (int b = 100; b <= 999; b++)
            {
                String s = (a * b) + "";
                int n = s.length();
                for (int i = 0, j = n - 1; i < n / 2; i++, j--)
                {
                    if (s.charAt(i) != s.charAt(j))
                    {
                        continue outer;
                    }
                }
                best = Math.max(best, a * b);
            }
        }
        System.out.println(best);
    }
}
