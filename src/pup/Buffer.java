package pup;

import java.util.Arrays;
import java.util.List;

public class Buffer {
    public final int MAX_SIZE = 10;
    private volatile int[] nums = new int[MAX_SIZE];

    public int getIndex() {
        return index;
    }

    private int index = 0;

    public void clearIndex(){
        index = 0;
    }

    public void append(int value) {
        nums[this.index] = value;
        this.index++;
    }

    @Override
    public String toString() {
        return Arrays.toString(nums);
    }

    public void clear() {
        Arrays.fill(nums, 0);
        this.index = 0;
    }

    public synchronized int[] getArray()
    {
        return nums;
    }
}
