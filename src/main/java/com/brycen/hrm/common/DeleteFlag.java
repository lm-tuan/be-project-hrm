package com.brycen.hrm.common;


public enum DeleteFlag {
    NO(0), YES(1);

    private int numVal;

    DeleteFlag(int numVal) {
        this.numVal = numVal;
    }

    public int getNumVal() {
        return numVal;
    }
}