package com.github.romanqed.ranges;

import java.util.function.Consumer;


/**
 * An interface defined for a set of the form [x; y).
 */
public interface Rangeable {

    /**
     * @return Returns the left value (inclusive)
     */
    int getLeft();

    /**
     * @return Returns the right value (not inclusive)
     */
    int getRight();

    /**
     * @return Returns the step
     */
    int getStep();

    /**
     * @param value The value to be checked for entering the range
     * @return False if no, true, if it is
     */
    boolean valueIn(int value);

    /**
     * @return Range size
     */
    int size();

    /**
     * @return The generated array containing all the values from the range
     */
    Integer[] toArray();


    /**
     * @param action The action to be performed for each value from the range
     */
    void forEach(Consumer<Integer> action);


    /**
     * @param value The processed value
     * @return The index of the value in the range, for example, the index of 5 in [0, 7) will be 5
     */
    int indexOf(int value);
}
