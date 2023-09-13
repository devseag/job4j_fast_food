package ru.domain.model;

public enum Status {
    ACCEPTED("prinjat"), CANCELED("otmenjon"), WAIT_PAY("ozhidaet oplatu"),
    PAYED("oplachen"), COOKING("gotovitsja"),
    READY_FOR_DELIVERY("gotov k vydache"), DELIVERING("dostavljaetsja"),
    DELIVERED("dostavlen"), NOT_FOUND("ne najden");

    private final String str;

    Status(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}