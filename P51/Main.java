package ProjectEuler.P51;

import java.util.TreeSet;

/**
 * Created by Nirmit on 02/08/2017.
 */
public class Main
{
    private int N = (int) 1e6;
    private boolean[] sieve = new boolean[N + 1];
    private int P = 78498;
    private int[] primes = new int[P];
    private TreeSet<Long> set;
    private int[] digits;

    public static void main(String[] ar)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        for (int i = 2; i * i <= N; i++)
        {
            for (int j = i * i; j <= N; j += i)
            {
                sieve[j] = true;
            }
        }
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (!sieve[i])
            {
                primes[j++] = i;
            }
        }
        int start = -1;
        for (int i = 0; i < P; i++)
        {
            if (primes[i] >= 1e5)
            {
                start = i;
                break;
            }
        }
        for (int i = start; i < P; i++)
        {
            int n = getLength(primes[i]);

            //One position//
            for (int p1 = n - 1; p1 >= 0; p1--)
            {
                digits = getDigits(primes[i]);
                set = new TreeSet<>();
                for (int d = 0; d <= 9; d++)
                {
                    if (p1 == 0 && d == 0)
                    {
                        continue;
                    }
                    digits[p1] = d;
                    long num = getNumber(digits);
                    if (isPrime(num))
                    {
                        set.add(num);
                    }
                }
                if (set.size() == 8)
                {
                    System.out.println(set.pollFirst());
                    return;
                }
            }

            //Two positions//
            for (int p1 = n - 2; p1 >= 0; p1--)
            {
                for (int p2 = n - 1; p2 > p1; p2--)
                {
                    digits = getDigits(primes[i]);
                    set = new TreeSet<>();
                    for (int d = 0; d <= 9; d++)
                    {
                        if (p1 == 0 && d == 0)
                        {
                            continue;
                        }
                        digits[p1] = digits[p2] = d;
                        long num = getNumber(digits);
                        if (isPrime(num))
                        {
                            set.add(num);
                        }
                    }
                    if (set.size() == 8)
                    {
                        while (!set.isEmpty())
                        {
                            System.out.println(set.pollFirst());
                        }
                        return;
                    }
                }
            }
            //Three positions//
            for (int p1 = n - 3; p1 >= 0; p1--)
            {
                for (int p2 = n - 2; p2 > p1; p2--)
                {
                    for (int p3 = n - 1; p3 > p2; p3--)
                    {
                        digits = getDigits(primes[i]);
                        set = new TreeSet<>();
                        for (int d = 0; d <= 9; d++)
                        {
                            if (p1 == 0 && d == 0)
                            {
                                continue;
                            }
                            digits[p1] = digits[p2] = digits[p3] = d;
                            long num = getNumber(digits);
                            if (isPrime(num))
                            {
                                set.add(num);
                            }
                        }
                        if (set.size() == 8)
                        {
                            while (!set.isEmpty())
                            {
                                System.out.println(set.pollFirst());
                            }
                            return;
                        }
                    }
                }
            }
            //Four positions//
            for (int p1 = n - 4; p1 >= 0; p1--)
            {
                for (int p2 = n - 3; p2 > p1; p2--)
                {
                    for (int p3 = n - 2; p3 > p2; p3--)
                    {
                        for (int p4 = n - 1; p4 > p3; p4--)
                        {
                            digits = getDigits(primes[i]);
                            set = new TreeSet<>();
                            for (int d = 0; d <= 9; d++)
                            {
                                if (p1 == 0 && d == 0)
                                {
                                    continue;
                                }
                                digits[p1] = digits[p2] = digits[p3] = digits[p4] = d;
                                long num = getNumber(digits);
                                if (isPrime(num))
                                {
                                    set.add(num);
                                }
                            }
                            if (set.size() == 8)
                            {
                                while (!set.isEmpty())
                                {
                                    System.out.println(set.pollFirst());
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private int getLength(long num)
    {
        int count = 0;
        while (num > 0)
        {
            num /= 10;
            count++;
        }
        return count;
    }

//    private void test1(int pos, int left, int d)
//    {
//        if (pos == -1)
//        {
//            return;
//        }
//        if (left == 0)
//        {
//            long num = getNumber(digits);
//            if (isPrime(num))
//            {
//                set.add(num);
//            }
//            return;
//        }
//        int temp = digits[pos];
//        digits[pos] = d;
//        test1(pos - 1, left - 1, d);
//        digits[pos] = temp;
//        test1(pos - 1, left, d);
//    }

    private int[] getDigits(long num)
    {
        int n = getLength(num);
        int[] d = new int[n];
        for (int i = n - 1; i >= 0; i--)
        {
            d[i] = (int) (num % 10);
            num /= 10;
        }
        return d;
    }


    private long getNumber(int[] digits)
    {
        String s = "";
        for (int i = 0; i < digits.length; i++)
        {
            s += digits[i];
        }
        return Long.parseLong(s);
    }

    private boolean isPrime(long value)
    {
        for (int i = 0; i < P && primes[i] * 1L * primes[i] <= value; i++)
        {
            if (value % primes[i] == 0)
            {
                return false;
            }
        }
        return true;
    }
}
