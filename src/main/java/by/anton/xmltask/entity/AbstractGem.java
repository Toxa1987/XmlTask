package by.anton.xmltask.entity;

import java.time.YearMonth;
import java.util.Objects;

public abstract class AbstractGem {
    private static final String DEFAULT_UNIQUENESS = "rare";
    private static final String DEFAULT_VALUE = " ";

    private String id;
    private String uniqueness;
    private String name;
    private GemOrigin gemOrigin;
    private int value;
    private int hardness;
    private YearMonth timeOfExtraction;

    public AbstractGem() {
        uniqueness = DEFAULT_UNIQUENESS;
        id = name = DEFAULT_VALUE;
        gemOrigin = GemOrigin.USA;
        timeOfExtraction = YearMonth.now();
    }

    public AbstractGem(String id, String uniqueness, String name, GemOrigin gemOrigin, int value,
                       int hardness, YearMonth timeOfExtraction) {
        this.id = id;
        this.uniqueness = uniqueness;
        this.name = name;
        this.gemOrigin = gemOrigin;
        this.value = value;
        this.hardness = hardness;
        this.timeOfExtraction = timeOfExtraction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUniqueness() {
        return uniqueness;
    }

    public void setUniqueness(String uniqueness) {
        this.uniqueness = uniqueness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GemOrigin getGemOrigin() {
        return gemOrigin;
    }

    public void setGemOrigin(GemOrigin gemOrigin) {
        this.gemOrigin = gemOrigin;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHardness() {
        return hardness;
    }

    public void setHardness(int hardness) {
        this.hardness = hardness;
    }

    public YearMonth getTimeOfExtraction() {
        return timeOfExtraction;
    }

    public void setTimeOfExtraction(YearMonth timeOfExtraction) {
        this.timeOfExtraction = timeOfExtraction;
    }

    @Override
    public String toString() {
        return "AbstractGem{" +
                "id=" + id +
                ", uniqueness='" + uniqueness + '\'' +
                ", name='" + name + '\'' +
                ", gemOrigin=" + gemOrigin +
                ", value=" + value +
                ", hardness=" + hardness +
                ", timeOfExtraction=" + timeOfExtraction +
                '}';
    }
}
