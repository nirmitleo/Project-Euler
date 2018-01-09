package ProjectEuler.P22;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nirmit on 27/07/2017.
 */
public class Main
{
    private Scanner in;

    public static void main(String[] args) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        in = new Scanner(new FileReader(new File("./ProjectEuler/P22/sample")));
        int n = 5163;
        String[] list = new String[n];
        int index = 0;
        while (in.hasNext())
        {
            list[index++] = in.next();
        }
        Arrays.sort(list);
        int total = 0;
        for (int i = 0; i < n; i++)
        {
            String s = list[i];
            int score = 0;
            for (int j = 0; j < s.length(); j++)
            {
                int d = s.charAt(j) - 'A' + 1;
                score += d;
            }
            score = score * (i + 1);
            total += score;
        }
        System.out.println(total);
    }
}
