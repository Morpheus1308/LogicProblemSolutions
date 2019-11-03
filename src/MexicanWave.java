import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MexicanWave {
    public static void main(String[] args) {
        Arrays.asList(wave("hello you")).stream().forEach(System.out::println);
    }

    public static String[] wave(String str) {
        String[] mWave = new String[str.replaceAll("\\s", "").length()];
        char[] cs = str.toCharArray();
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '){
                cs = str.toCharArray();
                cs[i] = Character.toUpperCase(str.charAt(i));
                mWave[index] = String.valueOf(cs);
                index++;
            }
        }
        return mWave;
    }

    @Test
    public void basicTest1() {
        String[] result = new String[] { "Hello", "hEllo", "heLlo", "helLo", "hellO" };
        Assert.assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave("hello"));
    }

    @Test
    public void basicTest2() {
        String[] result = new String[] { "Codewars", "cOdewars", "coDewars", "codEwars", "codeWars", "codewArs", "codewaRs", "codewarS" };
        Assert.assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave("codewars"));
    }

    @Test
    public void basicTest3() {
        String[] result = new String[] { };
        Assert.assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave(""));
    }

    @Test
    public void basicTest4() {
        String[] result = new String[] { "Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS" };
        Assert.assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave("two words"));
    }

    @Test
    public void basicTest5() {
        String[] result = new String[] { " Gap ", " gAp ", " gaP " };
        Assert.assertArrayEquals("it should return '" + Arrays.toString(result) + "'", result, wave(" gap "));
    }
    
    
}
