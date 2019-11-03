import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IntegersSqare {
    public static void main(String[] args) {
        System.out.println(listSquared(41, 250));
    }

    public static String listSquared(long m, long n) {
        StringBuilder sb = new StringBuilder("[");
        for (long i = m; i < n; i++) {
            long x = i;
            List<Long> divisorList = LongStream.range(1, i).filter(e -> x % e == 0).boxed().collect(Collectors.toList());
            divisorList.stream().forEach(System.out::print);
            double sum = divisorList.stream().map(e -> Math.pow((double) e,2)).mapToDouble(Double::doubleValue).sum();
            System.out.println("i: " + i);
            System.out.println("sum:"  + sum);
            System.out.println("result: " + Math.pow((long) Math.sqrt(sum), 2));
            if (Math.pow((long) Math.sqrt(sum), 2) - sum == 0){

                sb.append("[" + i + ", " + divisorList.stream().mapToLong(Long::longValue).sum() + "], ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
