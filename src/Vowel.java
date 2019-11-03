import java.util.Arrays;
import java.util.List;

public class Vowel {
    public static void main(String[] args) {
    }

    public static int getCount(String str) {
        List<String> chars = Arrays.asList(str.split("/"));
        return (int) chars.stream().filter(e -> e.toLowerCase().matches("a|e|i|o|u")).count();
    }
}
