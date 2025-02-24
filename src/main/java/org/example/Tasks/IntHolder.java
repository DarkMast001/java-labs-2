package org.example.Tasks;

public class IntHolder {
    private int number;

    public IntHolder() {
        number = 0;
    }

    public IntHolder(int number) {
        this.number = number;
    }

    public IntHolder setNumber(int value) {
        number = value;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public void swap(IntHolder intHolder) {
        int tmp = intHolder.number;
        intHolder.number = this.number;
        this.number = tmp;
    }
}
