package ProjectEuler.P24;

import java.util.ArrayList;

/**
 * Created by Nirmit on 27/07/2017.
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
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i <= 9; i++)
        {
            a.add(i);
        }

        String f = "";
        int pos = (int) 1e6 - 1;
        for (int i = 1; pos > 0; i++)
        {
            f = (pos % i) + f;
            pos = pos / i;
        }

        String result = "";
        for (int i = 0; i < f.length(); i++)
        {
            int p = f.charAt(i) - '0';
            result += a.remove(p);
        }
        System.out.println(result);


    }
}
