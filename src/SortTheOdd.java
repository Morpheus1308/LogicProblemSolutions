import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;



/*You have an array of numbers.
Your task is to sort ascending odd numbers but even numbers must be on their places.

Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.

Optimal solution
 // Sort the odd numbers only
    final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();

    // Then merge them back into original array
    for (int j = 0, s = 0; j < array.length; j++) {
      if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
    }

    return array;
 */

public class SortTheOdd {
    public static void main(String[] args) {
        for (int i : sortArray(new int[]{5, 3, 2, 8, 1, 4})) {
            System.out.println(i);
        };
    }

    public static int[] sortArray(int[] array) {
        IntStream numbers = Arrays.stream(array);
        int[] odd = numbers.filter(e -> e % 2 != 0).toArray();
        Arrays.sort(odd);
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] % 2 != 0){
                array[i] = odd[index];
                index++;
            }
        }
        return array;

    }
}