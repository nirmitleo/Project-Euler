package ProjectEuler.P99;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Nirmit on 18/08/2017.
 */
public class Main
{
    private Random r = new Random();

    public static void main(String[] a)
    {
        Main demo = new Main();
        demo.test1();
        demo.solve();
    }

    public void solve()
    {
        int line = 0;
        double result = 0;
        try
        {
            Scanner in = new Scanner(new File("./ProjectEuler/P99/sample"));
            for (int i = 1; in.hasNext(); i++)
            {
                int a = in.nextInt();
                int b = in.nextInt();
                double bloga = b * Math.log10(a);
                if (result < bloga)
                {
                    result = bloga;
                    line = i;
                }
            }
            System.out.println(line);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    public void test1()
    {
        for (int i = 1; i <= 1000; i++)
        {
//            long a = getNext();
//            long b = getNext();
//
//            long c = getNext();
//            long d = getNext();
            long a = 632382;
            long b = 518061;

            long c = 519432;
            long d = 525806;

            boolean result1 = Math.pow(a, b) < Math.pow(c, d);
            boolean result2 = b * Math.log10(a) < d * Math.log10(c);
            if (result1 != result2)
            {
                System.out.println(a + " e = " + b + " slow = " + Math.pow(a, b) + " log = " + b * Math.log10(a));
                System.out.println(c + " e = " + d + " slow = " + Math.pow(c, d) + " log = " + d * Math.log10(c));
                return;
            }
        }
    }

    public int getNext()
    {
        int min = 2;
        int max = 100;
        return r.nextInt(max - min + 1) + min;

    }

}
