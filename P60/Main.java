package ProjectEuler.P60;

import java.math.BigInteger;

/**
 * Created by Nirmit on 03/08/2017.
 */
public class Main
{
    private int N = (int) 1e4;
    private boolean[] sieve = new boolean[N + 1];

//        private int P = 78498;
    private int P = 1229;
    private int[] primes = new int[P];

    public static void main(String[] a)
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
//        int count = 0;
        for (int i = 2, j = 0; i <= N; i++)
        {
            if (!sieve[i])
            {
//                count++;
                primes[j++] = i;
            }
        }
//        System.out.println(count);
//        long result = Long.MAX_VALUE;
//        for (int p1 = 0; p1 < P; p1++)
//        {
//            for (int p2 = p1 + 1; p2 < P; p2++)
//            {
//                for (int p3 = p2 + 1; p3 < P; p3++)
//                {
//                    for (int p4 = p3 + 1; p4 < P; p4++)
//                    {
//                        outer:
//                        for (int p5 = p4 + 1; p4 < P; p4++)
//                        {
//                            int[] set = new int[]{primes[p1], primes[p1], primes[p3], primes[p4], primes[p5]};
//                            for (int i = 0; i < 5; i++)
//                            {
//                                for (int j = i + 1; j < 5; j++)
//                                {
//                                    long num1 = Long.parseLong((set[i] + "" + set[j]));
//                                    long num2 = Long.parseLong((set[j] + "" + set[i]));
//
//                                    if (!isPrime(num1) || !isPrime(num2))
//                                    {
//                                        continue outer;
//                                    }
//                                }
//                            }
//                            int sum = 0;
//                            for (int i = 0; i < 5; i++)
//                            {
//                                sum += primes[i];
//                            }
//                            result = Math.min(result, sum);
//                        }
//                    }
//                }
//            }
//        }
        long result = Long.MAX_VALUE;
        for (int p1 = 0; p1 < P; p1++)
        {
            for (int p2 = p1; p2 < P; p2++)
            {
                if (check(primes[p1], primes[p2]))
                {
                    for (int p3 = p2; p3 < P; p3++)
                    {
                        if (check(primes[p1], primes[p3]) && check(primes[p2], primes[p3]))
                        {
                            for (int p4 = p3; p4 < P; p4++)
                            {
                                if (check(primes[p1], primes[p4]) && check(primes[p2], primes[p4]) && check(primes[p3], primes[p4]))
                                {
                                    for (int p5 = p4; p5 < P; p5++)
                                    {
                                        if (check(primes[p1], primes[p5]) && check(primes[p2], primes[p5]) && check(primes[p3], primes[p5]) && check(primes[p4], primes[p5]))
                                        {
                                            System.out.println(primes[p1]);
                                            System.out.println(primes[p2]);
                                            System.out.println(primes[p3]);
                                            System.out.println(primes[p4]);
                                            System.out.println(primes[p5]);
                                            System.out.println("***********************");
                                            int sum = primes[p1] + primes[p2] + primes[p3] + primes[p4] + primes[p5];
                                            result = Math.min(result, sum);
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    private boolean isPrime(long num)
    {
        for (int i = 0; i < P && primes[i] * primes[i] <= num; i++)
        {
            if (num % primes[i] == 0)
            {
                return false;
            }
        }
        return true;
    }

    //    private boolean check(int num1, int num2)
//    {
//        long N = Long.parseLong(num1 + "" + num2);
//        long M = Long.parseLong(num2 + "" + num1);
//        if (isPrime(N) && isPrime(M))
//        {
//            return true;
//        }
//        return false;
//    }
    private boolean check(int num1, int num2)
    {
        BigInteger a = new BigInteger(num1 + "" + num2);
        BigInteger b = new BigInteger(num2 + "" + num1);
        if (a.isProbablePrime(10) && b.isProbablePrime(10))
        {
            return true;
        }
        return false;
    }
}
