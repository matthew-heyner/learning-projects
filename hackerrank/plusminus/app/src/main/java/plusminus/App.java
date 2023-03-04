package plusminus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static void plusMinus(List<Integer> arr) {
        var negatives = new ArrayList<Integer>();
        var positives = new ArrayList<Integer>();
        var zeros = new ArrayList<Integer>();

        for (var value : arr) {
            if (value < 0) {
                negatives.add(value);
            } else if (value > 0) {
                positives.add(value);
            } else {
                zeros.add(value);
            }
        }
        
        var arraySize = Double.valueOf(arr.size());
        var negativeRatio = new BigDecimal(negatives.size() / arraySize).setScale(6, RoundingMode.HALF_DOWN);
        var positiveRatio = new BigDecimal(positives.size() / arraySize).setScale(6, RoundingMode.HALF_DOWN);
        var zeroRatio = new BigDecimal(zeros.size() / arraySize).setScale(6, RoundingMode.HALF_DOWN);

        System.out.println(positiveRatio);
        System.out.println(negativeRatio);
        System.out.println(zeroRatio);

        // Avoid sorting an array - This approach has a time complexity of O(n)
        // Inversly using a sorting operation would leave us with a time complexity of
        // O(n log n)

        // Time complexity O(n)
        var maxRatioNegativePositive = negativeRatio.compareTo(positiveRatio) > 0 ? negativeRatio : positiveRatio;
        var maxRatioNegativeZero = negativeRatio.compareTo(zeroRatio) > 0 ? negativeRatio : zeroRatio;
        var maxRatioPositiveZero = positiveRatio.compareTo(zeroRatio) > 0 ? positiveRatio : zeroRatio;

        // Is the positiveRatio the largest fraction?
        if (maxRatioNegativePositive == positiveRatio) {
            // Print it
            System.out.println(positiveRatio);
            // Is the negativeRatio the next highest fraction?
            if (maxRatioNegativeZero == negativeRatio) {
                // Print it 
                System.out.println(negativeRatio);
                // finally zero
                System.out.println(zeroRatio);
            // Is the zeroRation larger than the negativeRatio?
            } else {
                // Print it
                System.out.println(zeroRatio);
                // Finaly negative
                System.out.println(negativeRatio);
            }
        }

        if(maxRatioNegativePositive == negativeRatio) {
            System.out.println(negativeRatio);
            if (maxRatioPositiveZero == positiveRatio) {
                System.out.println(positiveRatio);
                System.out.println(zeroRatio);
            } else {
                System.out.println(zeroRatio);
                System.out.println(positiveRatio);
            }
        }
        
        if (maxRatioNegativeZero == zeroRatio && maxRatioPositiveZero == zeroRatio) {
            System.out.println(zeroRatio);
            if (maxRatioPositiveZero == positiveRatio) {
                System.out.println(positiveRatio);
                System.out.println(negativeRatio);
            } else {
                System.out.println(negativeRatio);
                System.out.println(positiveRatio);
            }
        }
    }

}

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
