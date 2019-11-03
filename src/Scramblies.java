import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/* Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

optimal solution
    public static boolean scramble(String str1, String str2) {
        if (str2.length() > str1.length()) return false;
        for (String s: str2.split("")) {
          if (!str1.contains(s))  return false;
          str1 = str1.replaceFirst(s,"");
        }

        return true;
    }
 */

public class Scramblies {
    public static void main(String[] args) {

    }
    private static void testing(boolean actual, boolean expected) {
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests scramble");
        testing(Scramblies.scramble("rkqodlw","world"), true);
        testing(Scramblies.scramble("cedewaraaossoqqyt","codewars"),true);
        testing(Scramblies.scramble("katas","steak"),false);
        testing(Scramblies.scramble("scriptjavx","javascript"),false);
        testing(Scramblies.scramble("scriptingjava","javascript"),true);
        testing(Scramblies.scramble("scriptsjava","javascripts"),true);
        testing(Scramblies.scramble("javscripts","javascript"),false);
        testing(Scramblies.scramble("aabbcamaomsccdd","commas"),true);
        testing(Scramblies.scramble("commas","commas"),true);
        testing(Scramblies.scramble("sammoc","commas"),true);
    }


    public static boolean scramble(String str1, String str2) {
        List<String> scramble = new ArrayList<>(Arrays.asList(str1.split("")));
        List<String> word = new ArrayList<>(Arrays.asList(str2.split("")));
        for (Iterator<String> iterator = word.iterator(); iterator.hasNext(); ) {
            String value = iterator.next();
            if (scramble.contains(value)) {
                iterator.remove();
                scramble.remove(value);
            }
        }
        return word.size() <= 0;
        
        
       // System.out.println(Arrays.asList(str2.split("")).stream().filter(e -> str1.contains(e)).collect(Collectors.toList()).size());
       // System.out.println("str2 = " + str2.length());
       // return Arrays.asList(str2.split("")).stream().filter(e -> str1.contains(e)).collect(Collectors.toList()).size() == str2.length();
        // your code
    }
}
