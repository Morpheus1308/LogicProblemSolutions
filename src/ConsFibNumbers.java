import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

/** find consecutive fibo numbers, where the product results in a specific number
 * public class ProdFib { // must be public for codewars
 *
 *   public static long[] productFib(long prod) {
 *     long a = 0L;
 *     long b = 1L;
 *     while (a * b < prod) {
 *       long tmp = a;
 *       a = b;
 *       b = tmp + b;
 *     }
 *     return new long[] { a, b, a * b == prod ? 1 : 0 };
 *    }
 * }
 */
public class ConsFibNumbers {
    public static void main(String[] args) {
        for (long l :
                productFib(714)) {
            System.out.println(l);
        }
    }

    public static long[] productFib(long prod) {

        if(prod > 0){
            ArrayList<Long> fibo = new ArrayList<>();
            fibo.add((long)1);
            fibo.add((long)1);

            for (long i = 2; i < 50; i++) {
                if(fibo.get((int)i-1) * fibo.get((int)i-2) == prod){
                    return new long[] {fibo.get((int)i-2), fibo.get((int)i-1), 1};
                } else if(fibo.get((int)i-1) * fibo.get((int)i-2) > prod){
                    return new long[] {fibo.get((int)i-2), fibo.get((int)i-1), 0};
                } else {
                    fibo.add(fibo.get((int) i - 1) + fibo.get((int) i - 2));
                }
            }
        }
        return null;

    }

    public class Dubstep {
        public static String SongDecoder (String song)
        {
            StringBuilder sb = new StringBuilder();
            for (String s : song.split("WUB")) {
                if(s.length() > 0) {
                    sb.append(sb.length() > 0 ? " " + s : s);
                }
            }
            return sb.toString();
        }
    }

    public static String dashatize(int num) {
        String[] entireNum = ("" + Math.abs((long)num)).split("");
        if(String.valueOf(Math.abs(num)).length() <2){
            return String.valueOf(Math.abs(num));
        }
        StringBuilder sb = new StringBuilder(entireNum[0]);
        for (int i = 1; i < entireNum.length; i++) {
            if(Integer.valueOf(entireNum[i]) % 2 != 0 || Integer.valueOf(entireNum[i-1]) % 2 != 0){
                sb.append("-" + entireNum[i]);
            } else{
                sb.append(entireNum[i]);
            }
        }
        return sb.toString();
    }

    public static int minimumNumber(int[] numbers)
    {
        int addNumber = 0;
        while(!isPrime(Arrays.stream(numbers).sum() + addNumber)){
            addNumber++;
        }
        return addNumber;
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) Math.ceil(Math.sqrt(number))).noneMatch(i -> number%i == 0);
    }

    public static int minimumNumber(int[] numbers)
    {
        int addNumber = 0;
        while(!isPrime(Arrays.stream(numbers).sum() + addNumber)){
            addNumber++;
        }
        return addNumber;
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) Math.ceil(Math.sqrt(number))).noneMatch(i -> number%i == 0);
    }




    public static int solveSuperMarketQueue(int[] customers, int n) {
        if(n == 1){
            return Arrays.stream(customers).sum();
        } else{
            int[] queues = new int[n];
            for (int i = 0; i < customers.length; i++) {
                Arrays.sort(queues);
                queues[0] += customers[i];
            }
            Arrays.sort(queues);
            return queues[queues.length -1];
        }
    }

}
