package ProjectEuler.P92;

/**
 * Created by Nirmit on 15/08/2017.
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
        int count = 0;
        outer:
        for (int i = 2; i <= 1e7; i++)
        {
            int now = i;
            while (true)
            {
                int next = getNext(now);
                if (next == 1 || next == 89)
                {
                    if (next == 89)
                    {
//                        System.out.println(i);
                        count++;
                    }
                    continue outer;
                }
                now = next;
            }
        }
        System.out.println(count);
    }

    public int getNext(int num)
    {
        int result = 0;
        while (num > 0)
        {
            int d = num % 10;
            result += d * d;
            num /= 10;
        }
        return result;
    }
}
