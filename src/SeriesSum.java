import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SeriesSum {
    public static void main(String[] args) {
    }

    public static String seriesSum(int n) {
        String returnString = "";
        double sum = 1;
        for (double i = 4; i < 3*n-1; i += 3) {
            sum += 1/i;
        }

        return String.format(Locale.CANADA, "%.2f", sum);
    }
    }
