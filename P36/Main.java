package ProjectEuler.P36;

/**
 * Created by Nirmit on 29/07/2017.
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
        int N = (int) 1e6;
        int total = 0;
        for (int i = 1; i <= N; i++)
        {
            String num = i + "";
            if (isPalindrome(num))
            {
                String s = Integer.toString(i, 2);
                s = trim(s);
                if (isPalindrome(s))
                {
                    System.out.println(i + " " + Integer.toString(i, 2));
                    total += i;
                }
            }
        }
        System.out.println(total);
    }

    public String trim(String s)
    {
        while (s.charAt(0) == '0')
        {
            s = s.substring(1);
        }
//        while (s.charAt(s.length() - 1) == '0')
//        {
//            s = s.substring(0, s.length() - 1);
//        }
        return s;
    }

    public boolean isPalindrome(String s)
    {
        String r = reverse(s);
        return s.equals(r);
    }

    public String reverse(String s)
    {
        String ret = "";
        for (int i = s.length() - 1; i >= 0; i--)
        {
            ret += s.charAt(i);
        }
        return ret;
    }
}
