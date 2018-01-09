package ProjectEuler.P18;

/**
 * Created by Nirmit on 27/07/2017.
 */
public class Main
{
    private int[][] a = {
            {75},
            {95, 64},
            {17, 47, 82},
            {18, 35, 87, 10},
            {20, 4, 82, 47, 65},
            {19, 1, 23, 75, 3, 34},
            {88, 2, 77, 73, 7, 63, 67},
            {99, 65, 4, 28, 6, 16, 70, 92},
            {41, 41, 26, 56, 83, 40, 80, 70, 33},
            {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
            {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
            {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
            {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
            {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
            {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
    };
//    private int[][] a = {
//            {3},
//            {7, 4},
//            {2, 4, 6},
//            {8, 5, 9, 3}};

    public static void main(String[] a)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        int row = a.length;
        int[][] b = new int[row][row];
        System.arraycopy(a[row - 1], 0, b[row - 1], 0, a[row - 1].length);
        for (int i = row - 1; i >= 1; i--)
        {
            int col = a[i].length;
            for (int j = 0; j < col; j++)
            {
                if (j < a[i - 1].length)
                {
                    b[i - 1][j] = Math.max(b[i - 1][j], b[i][j] + a[i - 1][j]);
                }
                if (j - 1 >= 0)
                {
                    b[i - 1][j - 1] = Math.max(b[i - 1][j - 1], b[i][j] + a[i - 1][j - 1]);
                }
            }
        }
        System.out.println(b[0][0]);
    }
}
