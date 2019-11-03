import org.junit.Assert;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindEvenIndex {
    public static void main(String[] args) {
    }

    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.printf("%f, %f, %f, %d \n", sumRight(i, arr) - sumLeft(i, arr), sumLeft(i, arr), sumRight(i, arr), i);
            //System.out.println(sumRight(i, arr)-sumLeft(i, arr) <= 0.000001 && sumRight(i, arr)-sumLeft(i, arr) >= -0.000001);
            if (Double.compare(sumRight(i, arr), sumLeft(i, arr)) == 0) {
                return i;
            }
            double d = 0;

        }
        return -1;
    }

    public static double sumLeft(int index, int[] arr) {
        if (arr.length > 1 && index > 0) {
            //System.out.println("Left" + Arrays.stream(Arrays.copyOfRange(arr, 0, index)).sum());
            return Arrays.stream(Arrays.copyOfRange(arr, 0, index)).sum();
        } else {
            return 0;
        }
    }

    public static double sumRight(int index, int[] arr) {
        if (arr.length > 1 && index < arr.length - 1) {
            //System.out.println("Right" + Arrays.stream(Arrays.copyOfRange(arr, index+1, arr.length)).sum());
            return Arrays.stream(Arrays.copyOfRange(arr, index+1, arr.length)).sum();
        } else {
            return 0;
        }
    }
}
