import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * For building the encrypted string:
 * Take every 2nd char from the string, then the other chars, that are not every 2nd char, and concat them as new String.
 * Do this n times!
 */

@SuppressWarnings("Duplicates")
public class EncryptionAlternateSplit {

    public static void main(String[] args) {
        String encrypted = encrypt("This is a test!", 4);
        System.out.println(encrypted);
        System.out.println(decrypt(encrypted, 4));
    }

    public static String encrypt(final String text, final int n) {
        String string = text;
        for (int i = 0; i < n; i++) {
            final String s = string;
            StringBuilder sb = new StringBuilder();
            sb.append(IntStream.range(0, s.length())
                    .filter(k -> k%2 == 1)
                    .mapToObj(k -> s.charAt(k))
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());

            sb.append(IntStream.range(0, s.length())
                    .filter(k -> k%2 == 0)
                    .mapToObj(k -> s.charAt(k))
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());

            string = sb.toString();
        }
        return string;
    }

    public static String decrypt(final String encryptedText, final int n) {
        String result = encryptedText;
        for (int i = 0; i < n; i++) {
            String first = result.substring(0, (int) Math.floor(result.length()/2));
            String second = result.substring((int)Math.floor(result.length()/2));
            StringBuilder sb = new StringBuilder();

            int one = 0;
            int two = 0;
            while(sb.length() < encryptedText.length()){
                if(sb.length() % 2 == 1){
                    sb.append(first.charAt(one));
                    one++;
                } else{
                    sb.append(second.charAt(two));
                    two++;
                }
            }
            result = sb.toString();
        }
        return result;
    }
}
