package by.anton.xmltask.builder;

public enum GemXMLAttribute {
    ID("Id"),
    UNIQUENESS("Uniqueness");

    private String value;

    GemXMLAttribute(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
