package ProjectEuler.P93;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by Nirmit on 15/08/2017.
 */
public class Main
{
    private int O = 4;
    private int[] all = new int[]{0, 1, 2, 3};
    private int[] op = new int[O - 1];
    private TreeSet<Operation> set = new TreeSet<>();

    public static void main(String[] a)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void go(int i, int j)
    {
        if (i == O)
        {
            if (j == O - 1)
            {
                int[] b = op.clone();
                Operation o = new Operation(b);
                set.add(o);
            }
        } else
        {
            go(i + 1, j);
            if (j < O - 1)
            {
                op[j] = all[i];
                go(i, j + 1);
                go(i + 1, j + 1);
            }
        }
    }

    class Operation implements Comparable<Operation>
    {
        int[] op;

        public Operation(int[] op)
        {
            this.op = op;
        }

        public int compareTo(Operation that)
        {
            for (int i = 0; i < op.length; i++)
            {
                int diff = Integer.compare(this.op[i], that.op[i]);
                if (diff != 0)
                {
                    return diff;
                }
            }
            return 0;
        }

        public String toString()
        {
            return Arrays.toString(op);
        }

    }

    public void solve()
    {
        go(0, 0);
        int n = set.size();
        Operation[] list = new Operation[n];
        for (int i = 0; i < n; i++)
        {
            list[i] = set.pollFirst();
        }

        int count = 0;
        String result = "";
        for (int a = 1; a <= 9; a++)
        {
            for (int b = a + 1; b <= 9; b++)
            {
                for (int c = b + 1; c <= 9; c++)
                {
                    for (int d = c + 1; d <= 9; d++)
                    {
                        TreeSet<Integer> ans = new TreeSet<>();
                        int[] num = new int[]{a, b, c, d};
                        Permutation p = new Permutation(num);
                        do
                        {
                            for (int i = 0; i < n; i++)
                            {
                                int[] opNow = list[i].op;
                                Permutation q = new Permutation(opNow);
                                do
                                {
                                    // a + b + c + d //
                                    double aux = p.a[0];
                                    aux = getResult(aux, p.a[1], opNow[0]);
                                    aux = getResult(aux, p.a[2], opNow[1]);
                                    aux = getResult(aux, p.a[3], opNow[2]);
                                    if (aux > 0 && aux % 1 == 0)
                                    {
                                        ans.add(((int) aux));
                                    }
                                    // (a + b) + (c + d) //
                                    double a1 = getResult(p.a[0], p.a[1], opNow[0]);
                                    double a2 = getResult(p.a[2], p.a[3], opNow[2]);
                                    aux = getResult(a1, a2, opNow[1]);
                                    if (aux > 0 && aux % 1 == 0)
                                    {
                                        ans.add(((int) aux));
                                    }

                                    // a + (b + c) + d //
                                    a1 = getResult(p.a[1], p.a[2], opNow[1]);
                                    a2 = getResult(p.a[0], a1, opNow[0]);
                                    aux = getResult(a2, p.a[3], opNow[2]);
                                    if (aux > 0 && aux % 1 == 0)
                                    {
                                        ans.add(((int) aux));
                                    }

                                    // a + (b + c + d) //
                                    a1 = getResult(p.a[1], p.a[2], opNow[1]);
                                    a2 = getResult(a1, p.a[3], opNow[2]);
                                    aux = getResult(p.a[0], a2, opNow[0]);
                                    if (aux > 0 && aux % 1 == 0)
                                    {
                                        ans.add((int) aux);
                                    }

//                                    t++;
                                } while (q.nextPermutation());
                            }
                        } while (p.nextPermutation());

                        int cc = 0;
                        int prev = 0;
                        String temp = "";
                        while (!ans.isEmpty())
                        {
                            int now = ans.pollFirst();
                            if (now != prev + 1)
                            {
                                break;
                            }
                            cc++;
                            prev = now;
                            temp += now + ", ";
                        }
                        if (cc > count)
                        {
                            count = cc;
                            result = a + " " + b + " " + c + " " + d;
                            System.out.println("result = " + result + " count = " + count + " nos = " + temp);
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }

    public double getResult(double op1, double op2, int op)
    {
        switch (op)
        {
            case 0:
                return op1 + op2;
            case 1:
                return op1 - op2;
            case 2:
                return op1 * op2;
            case 3:
                if (op2 == 0)
                {
                    return (int) -1e7;
                }
                return op1 / (op2 * 1.0);
        }
        throw new RuntimeException();
    }
}
