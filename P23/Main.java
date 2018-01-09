package ProjectEuler.P23;

import java.util.ArrayList;

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
        int N = 28123;
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 12; i < N; i++)
        {
            int sum = getSum(i);
            if (sum > i)
            {
                A.add(i);
            }
        }
        int M = A.size();
        boolean[] can = new boolean[N];
        for (int i = 0; i < M; i++)
        {
            for (int j = i; j < M; j++)
            {
                int index = A.get(i) + A.get(j);
                if (index < N)
                {
                    can[A.get(i) + A.get(j)] = true;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < N; i++)
        {
            if (!can[i])
            {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public int getSum(int n)
    {
        int sum = 1;
        for (int i = 2; i * i <= n; i++)
        {
            if (n % i == 0)
            {
                sum += i;
                if (n / i != i)
                {
                    sum += n / i;
                }
            }
        }
        return sum;
    }
}
