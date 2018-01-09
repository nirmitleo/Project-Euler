package ProjectEuler.P55;

import java.math.BigInteger;

/**
 * Created by Nirmit on 03/08/2017.
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
        int count = 0;
        outer:
        for (int i = 0; i < 1e4; i++)
        {
            BigInteger num1 = BigInteger.valueOf(i);
            BigInteger num2 = new BigInteger(reverse(num1.toString()));
            BigInteger num = num1.add(num2);
            for (int t = 1; t <= 55; t++)
            {
                if (isPalindrome(num.toString()))
                {
                    count++;
                    System.out.println(i + " = " + num + "(" + (t) + ")");
                    continue outer;
                }
                num1 = num;
                num2 = new BigInteger(reverse(num.toString()));
                num = num1.add(num2);
            }
        }
        System.out.println(1e4 - count);

    }

    public boolean isPalindrome(String num)
    {
        String r = reverse(num);
        for (int i = 0, j = 0; i < num.length(); i++, j++)
        {
            if (num.charAt(i) != r.charAt(j))
            {
                return false;
            }
        }
        return true;
    }

    public String reverse(String num)
    {
        String ret = "";
        for (int i = num.length() - 1; i >= 0; i--)
        {
            ret += num.charAt(i);
        }
        return ret;
    }
}
