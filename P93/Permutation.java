package ProjectEuler.P93;

import java.util.Arrays;

/**
 * Created by Nirmit on 15/08/2017.
 */
public class Permutation
{
    int n;
    int[] a;

    public Permutation(int[] a)
    {
        Arrays.sort(a);
        this.a = a;
        this.n = a.length;
    }

    public boolean nextPermutation()
    {
        int i = n - 2;
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
        for (int j = n - 1; j >= i; j--)
        {
            if (a[i] < a[j])
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                break;
            }
        }
        for (int start = i + 1, end = n - 1; start < end; start++, end--)
        {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
        }
        return true;
    }


}
