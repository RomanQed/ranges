package com.github.romanqed.ranges;

public class CycledRange extends AbstractRange {
    public CycledRange(int left, int right, int step) {
        super(left, right, step);
    }

    public CycledRange(int left, int right) {
        this(left, right, 1);
    }

    public CycledRange(int right) {
        this(0, right, 1);
    }

    protected int cycleValue(int value) {
        int size = Math.abs(right - left) + 1;
        int ret = value - (value / size) * size;
        return ret >= 0 ? ret : size + ret;
    }

    @Override
    public boolean valueIn(int value) {
        return super.valueIn(cycleValue(value));
    }

    @Override
    public int size() {
        return Math.abs(rawSize());
    }

    @Override
    public int indexOf(int value) {
        return super.indexOf(cycleValue(value));
    }
}
