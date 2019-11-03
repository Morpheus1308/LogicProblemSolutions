import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.core.IsEqual.equalTo;

/*Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.

 Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

 If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.
 */

public class YourOrderPlease {
    public static void main(String[] args) {
        Assert.assertThat(order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
        Assert.assertThat(order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    public static String order(String words) {
        if (words != "") {
            String[] arr = words.split(" ");
            String[] rightOrder = new String[arr.length];

            for (int i = 0; i < arr.length; i++) {
                rightOrder[filterNumber(arr[i]) - 1] = arr[i].concat(filterNumber(arr[i]) == arr.length ? "" : " ");
            }
            return Arrays.asList(rightOrder).stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
        } else {
            return "";
        }
    }

    public static int filterNumber(String word) {
        return Integer.parseInt(word.replaceAll("\\D+", ""));
    }

}
