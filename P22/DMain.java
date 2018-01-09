package ProjectEuler.P22;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Nirmit on 27/07/2017.
 */
public class DMain
{
    public static void main(String[] a)
    {
        DMain demo = new DMain();
        demo.solve();
    }

    public void solve()
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
        {
            list.add(i);
        }

        int pos = (int) 1e6 - 1;
        Stack<Integer> fact = new Stack<Integer>();
        for (int i = 1; pos > 0 || fact.size() < list.size(); i++)
        {
            fact.push(pos % i);
            pos = pos / i;
        }
        String result = "";
        while (!fact.isEmpty())
        {
            int p = fact.pop();
            result += list.remove(p);
        }
        System.out.println(result);
    }
}
