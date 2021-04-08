package by.anton.xmltask.entity;

import java.time.YearMonth;

public class PreciousGem extends AbstractGem {
    private int transparency;
    private GemColor gemColor;
    private Preciousness preciousness = Preciousness.PRECIOUS;

    public PreciousGem() {
        transparency = 100;
        gemColor = GemColor.COLORLESS;
    }

    public PreciousGem(String id, String uniqueness, String name, GemOrigin gemOrigin, int value, int hardness, YearMonth timeOfExtraction, int transparency, GemColor gemColor) {
        super(id, uniqueness, name, gemOrigin, value, hardness, timeOfExtraction);
        this.transparency = transparency;
        this.gemColor = gemColor;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public GemColor getGemColor() {
        return gemColor;
    }

    public void setGemColor(GemColor gemColor) {
        this.gemColor = gemColor;
    }

    @Override
    public String toString() {
        return super.toString() + " " + preciousness + "{" +
                "transparency=" + transparency +
                ", gemColor=" + gemColor +
                "}";
    }
}
