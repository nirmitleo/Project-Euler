package ProjectEuler.P62;

import java.util.Arrays;

/**
 * Created by Nirmit on 04/08/2017.
 */
public class Main
{
    private int N;
    private int[] a;

    public static void main(String[] args)
    {
        Main demo = new Main();
//        demo.test2();
        demo.test1();
    }

    public void test1()
    {
        int C = (int) 1e4;
        Item[] cubes = new Item[C + 1];
        for (int i = 0; i <= C; i++)
        {
            long c = i * 1L * i * 1L * i;
            cubes[i] = new Item(c);
        }
        for (int i = 10; i < C + 1; i++)
        {
            int count = 1;
            Item a = cubes[i];
            for (int j = i + 1; j < C + 1; j++)
            {
                Item b = cubes[j];
                if (Arrays.equals(a.digits, b.digits))
                {
                    count++;
                }
            }
            if (count == 5)
            {
                System.out.println(a.c);
                return;
            }
        }

    }


    class Item
    {
        long c;
        int[] digits = new int[10];

        public Item(long num)
        {
            this.c = num;
            while (num > 0)
            {
                int d = (int) (num % 10);
                digits[d]++;
                num /= 10;
            }
        }
    }

    public void solve()
    {
        int C = (int) 1e4;
        long[] cubes = new long[C + 1];
        for (int i = 0; i <= C; i++)
        {
            cubes[i] = i * 1L * i * 1L * i;
        }

        for (int i = 20; i < C + 1; i++)
        {
            a = toDigits(cubes[i]);
            N = a.length;
//            Arrays.sort(a);
            int count = 0;
            do
            {
                long num = toNumber(a);
                if (getDigitCount(num) == N)
                {
                    int index = Arrays.binarySearch(cubes, num);
                    if (index >= 0 && index <= C)
                    {
                        count++;
                    }
                }
            } while (nextPermutation());
            if (count == 5)
            {
                System.out.println(i + " " + cubes[i]);
                return;
            }
        }
    }

    public long toNumber(int[] a)
    {
        long num = 0;
        for (int i = 0; i < a.length; i++)
        {
            num = num * 10 + a[i];
        }
        return num;
    }

    public int[] toDigits(long num)
    {
        int n = getDigitCount(num);
        int[] a = new int[n];
        for (int i = n - 1; i >= 0; i--)
        {
            a[i] = (int) (num % 10);
            num /= 10;
        }
        return a;
    }

    public int getDigitCount(long n)
    {
        return ((int) Math.log10(n)) + 1;
    }

    public boolean nextPermutation()
    {
        int i = N - 2;
        for (; i >= 0; i--)
        {
            if (a[i] < a[i + 1])
            {
                break;
            }
        }
        if (i < 0)
        {
            return false;
        }
        for (int j = N - 1; j >= i; j--)
        {
            if (a[i] < a[j])
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                break;
            }
        }
        for (int start = i + 1, end = N - 1; start < end; start++, end--)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }
        return true;
    }
}
