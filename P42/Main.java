package ProjectEuler.P42;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nirmit on 30/07/2017.
 */
public class Main
{
    public static void main(String[] args) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int N = (int) 2e8;
        long[] t = new long[N + 1];
        for (int i = 1; i <= N; i++)
        {
            t[i] = i * 1L * (i + 1);
            t[i] /= 2;
        }
//        System.out.println(t[N]);
        int count = 0;
        Scanner in = new Scanner(new FileReader(new File("./ProjectEuler/P42/sample")));
        while (in.hasNext())
        {
            int sum = 0;
            String name = in.next();
            for (int i = 0; i < name.length(); i++)
            {
                int num = name.charAt(i) - 'A' + 1;
                sum += num;
            }
            int index = Arrays.binarySearch(t, sum);
            if (index >= 0 && index <= N)
            {
                count++;
            }
        }
        System.out.println(count);

    }
}
