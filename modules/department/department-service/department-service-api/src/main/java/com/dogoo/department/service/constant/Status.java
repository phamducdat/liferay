package com.dogoo.department.service.constant;

import java.util.Objects;

public enum Status {
    ACTIVED("actived"), INACTIVED("inactived"), TRASHED("trashed");

    public static Status create(String value) {
        if ((value == null) || value.equals("")) {
            return null;
        }

        for (Status status : values()) {
            if (Objects.equals(status.getValue(), value)) {
                return status;
            }
        }

        throw new IllegalArgumentException("Invalid enum value: " + value);
    }

    public String getValue() {
        return _value;
    }

    @Override
    public String toString() {
        return _value;
    }

    private Status(String value) {
        _value = value;
    }

    private final String _value;

}
