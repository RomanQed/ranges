package com.github.romanqed.ranges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ranges {
    public static CycledRange invertRange(Rangeable range) {
        return new CycledRange(range.getLeft(), range.getRight(), range.getStep() * -1);
    }

    public static List<Integer> toList(Rangeable range) {
        return Arrays.asList(range.toArray());
    }

    public static Set<Integer> toSet(Rangeable range) {
        return new HashSet<>(toList(range));
    }

    public static long sum(Rangeable range) {
        long ret = 0;
        for (int value : range.toArray()) {
            ret += value;
        }
        return ret;
    }

    public static long sum(Rangeable... ranges) {
        long ret = 0;
        for (Rangeable range : ranges) {
            ret += sum(range);
        }
        return ret;
    }

    public static double average(Rangeable range) {
        try {
            return (double) sum(range) / range.size();
        } catch (Exception e) {
            return 0;
        }
    }
}
