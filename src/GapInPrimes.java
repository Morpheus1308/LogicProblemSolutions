import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
So this function should return the first pair of two prime numbers spaced with a gap of g between the limits m, n if
these numbers exist otherwise nil or null or None or Nothing (depending on the language).
 */

public class GapInPrimes {
    public static void main(String[] args) {
        System.out.println("Fixed Tests");
        Assert.assertEquals("[101, 103]", Arrays.toString(GapInPrimes.gap(2,100,110)));
        Assert.assertEquals("[103, 107]", Arrays.toString(GapInPrimes.gap(4,100,110)));
        Assert.assertEquals(null, GapInPrimes.gap(6,100,110));
        Assert.assertEquals("[359, 367]", Arrays.toString(GapInPrimes.gap(8,300,400)));
        Assert.assertEquals("[337, 347]", Arrays.toString(GapInPrimes.gap(10,300,400)));
        System.out.println(gap(20, 10, 10000)[0] +" " + gap(22, 10, 100000)[1]);
    }

    public static long[] gap(int g, long m, long n) {
        List<Integer> primeNrs = IntStream.range((int)m, (int)n).filter(e -> isPrime(e)).boxed().collect(Collectors.toList());
        Optional<Integer> primeCorrectGap = primeNrs.stream()
                .filter(e -> primeNrs.indexOf(e) < primeNrs.size()-1 ? primeNrs.get(primeNrs.indexOf(e)+1) - e == g : false)
                .findFirst();
        return primeCorrectGap.isPresent() ? new long[]{ primeCorrectGap.get(), primeNrs.get(primeNrs.indexOf(primeCorrectGap.get())+1)}
        : null;
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2).noneMatch(i -> number%i == 0);
    }
}
