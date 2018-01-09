package ProjectEuler.P17;

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
        int start = 200;
        int end = 200;
        int sum = 0;
        for (int i = start; i <= end; i++)
        {
            if (i >= 21 && i <= 99)
            {
                if (i % 10 == 0)
                {
                    sum += getCount(i);
                } else
                {
                    sum += getCount((i / 10) * 10);
                    sum += getCount(i % 10);
                }
            } else if (i >= 100)
            {
                if (i % 100 == 0)
                {
                    sum += getCount(i / 100);
                    sum += getCount(100);
                } else if (i % 10 == 0)
                {
                    sum += getCount(i / 100);
                    sum += getCount(100);
                    sum += 3;
                    sum += getCount(((i / 10) % 10) * 10);
                } else
                {
                    sum += getCount(i / 100);
                    sum += getCount(100);
                    sum += 3;
                    sum += getCount(((i / 10) % 10) * 10);
                    sum += getCount(i % 10);
                }
            } else
            {
                sum += getCount(i);
            }
        }
        System.out.println(sum);
    }

    public int getCount(int n)
    {
        switch (n)
        {
            case 1:
            case 2:
            case 6:
            case 10:
                return 3;
            case 3:
            case 7:
            case 8:
            case 40:
            case 50:
            case 60:
                return 5;
            case 4:
            case 5:
            case 9:
                return 4;
            case 11:
            case 12:
            case 20:
            case 30:
            case 80:
            case 90:
                return 6;
            case 13:
            case 14:
            case 18:
                return 8;
            case 15:
            case 16:
            case 19:
            case 70:
            case 100:
                return 7;
            case 17:
                return 9;
            case 1000:
                return 11;
            default:
                return 0;
        }
    }
}
