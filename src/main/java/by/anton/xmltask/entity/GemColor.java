package by.anton.xmltask.entity;

public enum GemColor {
    BLUE("Blue"),
    YELLOW("Yellow"),
    GREEN("Green"),
    RED("Red"),
    COLORLESS("Colorless"),
    PURPLE("Purple"),
    PINK("Pink");

    private String value;

    GemColor(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
