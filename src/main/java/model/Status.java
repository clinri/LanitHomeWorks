package model;

/**  Статусы тикета, используемые в тестах */
public enum Status {
    OPEN(1),
    CLOSED(4),
    ;

    private final int code;

    Status(int code) {
        this.code=code;
    }

    public int getCode() {
        return code;
    }
}