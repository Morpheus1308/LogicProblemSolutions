import java.util.Arrays;
import java.util.List;

public class Isograms {
    public static void main(String[] args) {
    }
    public static boolean isIsogram(String str) {
        List<String> chars = Arrays.asList(str.toLowerCase().split(""));
        return chars.stream().distinct().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString().equals(str.toLowerCase());
    }

}
