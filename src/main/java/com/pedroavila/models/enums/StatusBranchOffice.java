package com.pedroavila.models.enums;

public enum StatusBranchOffice {
    ENABLED(1),
    DISABLED(0);

    private final int value;

    StatusBranchOffice(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
