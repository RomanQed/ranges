package com.github.romanqed.ranges;

import java.util.function.Consumer;

public abstract class AbstractRange implements Rangeable {
    protected int left;
    protected int right;
    protected int step;

    public AbstractRange(int left, int right, int step) {
        this.left = left;
        this.right = right;
        this.step = step != 0 ? step : 1;
    }

    @Override
    public int getLeft() {
        return left;
    }

    @Override
    public int getRight() {
        return right;
    }

    @Override
    public int getStep() {
        return step;
    }

    protected int rawSize() {
        return (int) Math.ceil((float) (right - left) / step);
    }

    @Override
    public boolean valueIn(int value) {
        int eLeft = step < 0 ? right + 1 : left;
        int eRight = step < 0 ? left + 1 : right;
        return (value - left) % step == 0 && value >= eLeft && value < eRight;
    }

    @Override
    public Integer[] toArray() {
        Integer[] ret = new Integer[size()];
        if (ret.length == 0) {
            return ret;
        }
        ret[0] = left;
        for (int i = 1; i < ret.length; ++i) {
            ret[i] = ret[i - 1] + step;
        }
        return ret;
    }

    @Override
    public void forEach(Consumer<Integer> action) {
        int size = size();
        for (int i = 0, value = left; i < size; ++i) {
            action.accept(value);
            value += step;
        }
    }

    @Override
    public int indexOf(int value) {
        if (!valueIn(value)) {
            throw new IllegalArgumentException(value + " not in range");
        }
        return Math.abs(value / step);
    }

    @Override
    public String toString() {
        return "[" + left + ", " + right + ") (" + step + ")";
    }
}
