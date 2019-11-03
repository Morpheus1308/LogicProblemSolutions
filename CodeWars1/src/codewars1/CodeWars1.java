/**
 *
 * @author bende
 */

package codewars1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;


public class CodeWars1 {
    public static void main(String[] args) {
        assertEquals(true, isIsogram("Dermatoglyphics"));
        assertEquals(true, isIsogram("isogram"));
        assertEquals(false, isogram.isIsogram("moose"));
        assertEquals(false, isogram.isIsogram("isIsogram"));
        assertEquals(false, isogram.isIsogram("aba"));
        assertEquals(false, isogram.isIsogram("moOse"));
        assertEquals(true, isogram.isIsogram("thumbscrewjapingly"));
        assertEquals(true, isogram.isIsogram("")); 
    }
    
    public static boolean  isIsogram(String str) {
        List<String> chars = Arrays.asList(str.split(""));
        return chars.stream().distinct().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString().equals(str);
    }

}
