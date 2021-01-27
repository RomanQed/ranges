package com.github.romanqed.ranges;

public class CycledRange extends AbstractRange {
    private final boolean isInverted;

    public CycledRange(int left, int right, int step) {
        super(left, right, step);
        boolean leftMoreRight = left > right && step > 0;
        isInverted = leftMoreRight || (left < right && step < 0);
        if (isInverted) {
            this.step *= -1;
            this.left = left + this.step * (size() - 1);
            this.right = leftMoreRight ? left + 1 : left % step - 1;
            this.step *= -1;
        }
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

    public boolean isInverted() {
        return isInverted;
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
