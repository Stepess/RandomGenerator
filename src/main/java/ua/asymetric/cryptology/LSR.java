package ua.asymetric.cryptology;

import java.util.Arrays;

public class LSR {
    private final int period;
    private final int[] condition;
    private final int[] recurrence;

    public LSR(int period, int[] recurrence) {
        this.period = period;
        condition = new int[period];
        this.recurrence = Arrays.copyOf(recurrence, recurrence.length);
    }

    public void setCondition(int[] arr) {
        if (period >= 0) System.arraycopy(arr, 0, condition, 0, period);
    }

    public void setCondition(long newCondition) {
        for (int i = 0; i < period; i++) {
            condition[i] = (int) (newCondition & 1);
            newCondition >>>= 1;
        }
    }

    public void setRecurrence(int[] arr) {
        if (period >= 0) System.arraycopy(arr, 0, recurrence, 0, period);
    }

    public int getPeriod() {
        return period;
    }

    public int[] getCondition() {
        return condition;
    }

    public int[] getRecurrence() {
        return recurrence;
    }

    public int tact() {
        int res = condition[0];
        int el = 0;
        for (int i = 0; i < period; i++)
            el += condition[i] & recurrence[i];
        el = el % 2;
        for (int i = 0; i < period - 1; i++)
            condition[i] = condition[i + 1];
        condition[period - 1] = el;
        return res;
    }
}
