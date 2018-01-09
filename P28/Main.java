package ProjectEuler.P28;

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
        int n = 1001;
        int[][] a = new int[n][n];
        int x = n / 2;
        int y = n / 2;
        int count = 1;
        int dir = 0;
        int prev = 0;
        int now = 1;

        int total = 0;
        while (count <= n * n)
        {
            for (int i = 0; i < now; i++)
            {
                a[x][y] = count;

                if (x == y || x + y + 1 == n)
                {
                    total += count;
                }

                count++;
                switch (dir)
                {
                    case 0:
                        y++;
                        break;
                    case 1:
                        x++;
                        break;
                    case 2:
                        y--;
                        break;
                    case 3:
                        x--;
                        break;
                }
            }
            if (prev != now)
            {
                prev = now;
            } else
            {
                now++;
                prev = 1;
            }
            dir = (dir + 1) % 4;
        }
//        System.out.println(total);
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == j || i + j == n - 1)
                {
                    sum += a[i][j];
                }
            }
        }
        System.out.println(sum);

    }
}
