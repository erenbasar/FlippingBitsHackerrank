package com.ebasar;

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

public class Main {

    public static void main(String[] args) {
        System.out.println(Result.flippingBits(123));
    }



    class Result {

        /*
         * Complete the 'flippingBits' function below.
         *
         * The function is expected to return a LONG_INTEGER.
         * The function accepts LONG_INTEGER n as parameter.
         */

        public static long flippingBits(long n) {
            long flippedNumber = 0;
            String numberBinary;
            StringBuffer flippedBinary = new StringBuffer();

            flippedBinary.append(String.format("%32s", Long.toBinaryString(n)).replace(' ', '0'));
            for (int i = 0;i<flippedBinary.length();i++){
                if(flippedBinary.charAt(i) == '0')
                    flippedBinary.setCharAt(i,'1');
                else
                    flippedBinary.setCharAt(i,'0');;
            }

            flippedNumber = Long.parseLong(flippedBinary.toString(),2);

            return flippedNumber;
        }

    }

    public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            IntStream.range(0, q).forEach(qItr -> {
                try {
                    long n = Long.parseLong(bufferedReader.readLine().trim());

                    long result = Result.flippingBits(n);

                    bufferedWriter.write(String.valueOf(result));
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}
