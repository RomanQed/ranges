package com.github.romanqed.ranges;

public class Range extends AbstractRange {
    public Range(int left, int right, int step) {
        super(left, right, step);
    }

    public Range(int left, int right) {
        this(left, right, 1);
    }

    public Range(int right) {
        this(0, right, 1);
    }

    @Override
    public int size() {
        return Math.max(rawSize(), 0);
    }
}

