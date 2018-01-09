package ProjectEuler.P88;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by Nirmit on 11/08/2017.
 */
class Main
{
    private int t;
    private int[] F;

    private int N = (int) 2e5;
    private int M = 2 * N;
    //    private int M = 12;
    private int number;
    private int len;
    private int[] f;
    private int[] dp;
    private int left;
    private boolean ok;
    private int max = 0;

//    private int P = 1438;
//    private int[] primes = new int[P];


    public static void main(String[] a)
    {
        Main demo = new Main();
//        demo.test1();
//        demo.test2();
//        demo.test3();
        demo.test4();
    }

    public void test4()
    {
        dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);


    }

    public void go(int prod, int sum, int count, int left)
    {
        if (prod <= 2 * N)
        {
            int k = prod - sum + count;
            if (dp[k] > prod)
            {
                dp[k] = prod;
            }
            for (int i = 2; i * i <= 2 * N; i++)
            {
//                go(prod * i, sum + i, count + 1)
            }
        }
    }

    public int length(int num)
    {
        int len = 0;
        for (int i = 2; i * i <= num; i++)
        {
            int count = 0;
            while (num % i == 0)
            {
                num /= i;
                count++;
            }
            if (count > 0)
            {
                len += count;
            }
        }
        if (num > 1)
        {
            return len + 1;
        }
        return len;
    }

    public void test3()
    {
        int len = 0;
        for (int i = 2; i <= 200400; i++)
        {
            len = Math.max(len, length(i));
        }
        System.out.println(len);
        System.out.println(max);
    }

    public void test2()
    {
        dp = new int[M + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        left = M - 2 + 1;

        for (int n = 2; n <= M + M; n++)
        {
            if (!isPrime(n))
            {
                number = n;
                f = new int[20];
                go(n, 0);
            }
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 2; i < M + 1; i++)
        {
            set.add(dp[i]);
        }
        int prev = 0;
        int sum = 0;
        while (!set.isEmpty())
        {
            int num = set.pollFirst();
            sum += num;
//            System.out.println(num + " diff = " + (num - prev));
            System.out.println(num);
            prev = num;
        }
        System.out.println("The sum = " + sum);
    }

    public boolean isPrime(int n)
    {
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public void test1()
    {
        int total = 0;
        TreeSet<Integer> set = new TreeSet<>();
        outer:
        for (int k = 2; k <= 100; k++)
        {
            F = new int[k];
            ok = false;
            for (int n = k; ; n++)
            {
                if (!isPrime(n))
                {
                    for (int i = 2; i <= k; i++)
                    {
                        t = i;
                        f = new int[i];
                        ok = false;
                        go(n, 0, i);
                        if (ok)
                        {
                            boolean flag = set.add(n);
                            if (flag)
                            {
                                total += n;
                            }
                            Arrays.sort(F);
                            System.out.println(k + " = " + n + " total = " + total + " solution = " + Arrays.toString(F));
                            continue outer;
                        }
                    }
                }
            }
        }
        long sum = 0;
        while (!set.isEmpty())
        {
            sum += set.pollFirst();
        }
        System.out.println(sum);
    }

    public int getSum(int[] f)
    {
        int sum = 0;
        for (int i = 0; i < f.length; i++)
        {
            sum += f[i];
        }
        return sum;
    }

    public int getSum(int[] f, int index)
    {
        int sum = 0;
        for (int i = 0; i <= index; i++)
        {
            sum += f[i];
        }
        return sum;
    }

    public int getProduct(int[] f)
    {
        int prod = 1;
        for (int i = 0; i < f.length; i++)
        {
            prod *= f[i];
        }
        return prod;
    }

    public int getProduct(int[] f, int index)
    {
        int prod = 1;
        for (int i = 0; i <= index; i++)
        {
            prod *= f[i];
        }
        return prod;
    }

    public void go(int num, int index)
    {
        if (num > 1 && index != 0)
        {
            f[index] = num;
            int sum = getSum(f, index);
            int prod = getProduct(f, index);
            if (prod >= sum)
            {
                len = (index + 1) + (prod - sum);
                if (len >= 0 && len <= M && dp[len] > number)
                {
                    dp[len] = number;
                    this.left--;
                }
            }
        }
        for (int i = 2; i * i <= num; i++)
        {
            if (num % i == 0)
            {
                f[index] = i;
                go(num / i, index + 1);
            }
        }

    }

    public void go(int num, int index, int left)
    {
        if (left == 1)
        {
            if (num > 1)
            {
                f[index] = num;
                int sum = getSum(f);
                int prod = getProduct(f);
                if (prod >= sum)
                {
                    len = f.length + (prod - sum);
                    if (len >= 0 && len <= M && dp[len] > number)
                    {
                        dp[len] = number;
                        this.left--;
                        max = Math.max(max, f.length);
                    }
                }
            }
        } else
        {
            for (int i = 2; i * i <= num; i++)
            {
                if (num % i == 0)
                {
                    f[index] = i;
                    go(num / i, index + 1, left - 1);
                }
            }
        }
    }

}