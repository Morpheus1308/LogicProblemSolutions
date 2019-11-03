import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Fold 1-times:
[1,2,3,4,5] -> [6,6,3]

A little visualization (NOT for the algorithm but for the idea of folding):

 Step 1         Step 2        Step 3       Step 4       Step5
                     5/           5|         5\
                    4/            4|          4\
1 2 3 4 5      1 2 3/         1 2 3|       1 2 3\       6 6 3
----*----      ----*          ----*        ----*        ----*


Fold 2-times:
[1,2,3,4,5] -> [9,6]

Optimal solution
public static int[] foldArray(int[] a, int r) {
    int[] f = java.util.Arrays.copyOfRange(a,0,(int)Math.ceil(a.length/2.));
    for (int i=0; i<a.length/2; i++) f[i] += a[a.length-1-i];
    return f.length==1|r==1 ? f : foldArray(f,--r);
  }
 */

public class foldArray {
    public static void main(String[] args) {
        int[] input = new int[] { 1, 2, 3, 4, 5 };
        int[] expected = new int[] { 6, 6, 3 };
        Assert.assertEquals(Arrays.toString(expected), Arrays.toString(foldArray(input, 1)));
    }

    public static int[] foldArray(int[] array, int runs) {
        for (int i = 0; i < runs; i++) {
            int[] half = new int[array.length % 2 == 0 ? array.length / 2 : (array.length / 2) + 1];
            for (int j = 0; j < Math.floor(array.length / 2); j++) {
                half[j] = array[j] + array[array.length-1-j];
            }
            if(array.length % 2 != 0){
                half[half.length-1] = array[(int) Math.floor(array.length / 2)];
            }
            array = half;
        }
        return array;
    }

}
