package by.anton.xmltask.entity;

public enum Preciousness {
    PRECIOUS("Precious"),
    SEMIPRECIOUS("Semiprecious");

    private String value;

    Preciousness(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
