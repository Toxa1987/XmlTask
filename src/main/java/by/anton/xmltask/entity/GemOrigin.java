package by.anton.xmltask.entity;

public enum GemOrigin {
    MYANMAR("Myanmar"),
    USA("USA"),
    BRAZIL("Brazil"),
    CZECH("Czech"),
    MADAGASCAR("Madagascar"),
    TANZANIA("Tanzania"),
    SOUTH_AFRICA("South Africa"),
    COLUMBIA("Columbia"),
    RUSSIA("Russia");


    private String value;

    GemOrigin(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
