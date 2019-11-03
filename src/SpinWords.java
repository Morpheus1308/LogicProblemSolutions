import org.junit.Assert;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SpinWords {
    public static void main(String[] args) {
        Assert.assertEquals("emocleW", spinWords("Welcome"));
        Assert.assertEquals("Hey wollef sroirraw", spinWords("Hey fellow warriors"));
    }

    public static String spinWords(String sentence) {
        List<String> words = Arrays.asList(sentence.split(" "));
        return words.stream().map(e -> spinWord(e)).collect(Collectors.joining(" ")).toString();

        /*return Arrays.stream(sentence.split(" "))
                 .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                 .collect(Collectors.joining(" "));
  }*/

    }

    public static String spinWord(String sentence) {
        return sentence.length() >= 5 ?  new StringBuilder(sentence).reverse().toString() : sentence;

    }


}
