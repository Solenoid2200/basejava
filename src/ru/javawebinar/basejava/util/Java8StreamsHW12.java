package ru.javawebinar.basejava.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8StreamsHW12 {

    public static void main(String[] args) {
        // HW 12.1
        int array1[] = new int[]{1, 2, 3, 3, 2, 3};
        int array2[] = new int[]{9, 8};
        System.out.println(minValue(array1));
        System.out.println(minValue(array2));

        // HW 12.2
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(oddOrEven(integers));
    }

    static int minValue(int[] values) {
        return Arrays.stream(values).distinct().sorted().reduce((a, b) -> a * 10 + b).getAsInt();
    }

    static List<Integer> oddOrEven(List<Integer> integers) {
        int summ = integers.stream().mapToInt(i -> i.intValue()).sum();
        return integers.stream().filter(s -> (s % 2 == 0 && summ % 2 != 0 || s % 2 != 0 && summ % 2 == 0))
                .collect(Collectors.toList());
    }

}
