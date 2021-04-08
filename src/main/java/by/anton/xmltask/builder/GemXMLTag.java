package by.anton.xmltask.builder;

public enum GemXMLTag {
    GEMS("gems"),
    PRECIOUS("Precious"),
    SEMIPRECIOUS("Semiprecious"),
    NAME("name"),
    ORIGIN("origin"),
    HARDNESS("hardness"),
    VALUE("value"),
    TIMEOFEXTRACTION("timeOfExtraction"),
    VISUALPARAMETERS("visualParameters"),
    COLOR("color"),
    TRANSPARENCY("transparency");

    private String value;

    GemXMLTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
