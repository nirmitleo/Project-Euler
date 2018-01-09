package ProjectEuler.P26;

/**
 * Created by Nirmit on 27/07/2017.
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
        int num = -1;
        int max = 0;
        for (int i = 1; i <= 1000; i++)
        {
            boolean[] rem = new boolean[i];
            int nr = 10;
            int dr = i;
            int count = 1;
            while (true)
            {
                nr = nr % dr;
                if (rem[nr])
                {
                    if (max < count)
                    {
                        max = count;
                        num = i;
                    }
                    break;
                }
                rem[nr] = true;
                nr *= 10;
                count++;
            }
        }
        System.out.println(max);
//        System.out.println(num);
    }
}
