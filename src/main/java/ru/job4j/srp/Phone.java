package ru.job4j.srp;

import java.util.Objects;

public class Phone {
    private String model;
    private int partNumber;

    public Phone(String model, int partNumber) {
        this.model = model;
        this.partNumber = partNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.partNumber = partNumber;
    }

    public Phone buyPhone() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Phone phone = (Phone) o;
        return partNumber == phone.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partNumber);
    }
}
