package by.anton.xmltask.builder;

import by.anton.xmltask.entity.AbstractGem;
import by.anton.xmltask.exception.GemEntityException;

import java.util.ArrayList;

public abstract class AbstractGemsBuilder {
    protected ArrayList<AbstractGem> abstractGems;

    public AbstractGemsBuilder() {

        abstractGems = new ArrayList<>();
    }

    public AbstractGemsBuilder(ArrayList<AbstractGem> abstractGems) {

        this.abstractGems = abstractGems;
    }

    public ArrayList<AbstractGem> getAbstractGems() {
        return abstractGems;
    }

    public abstract void buildGems(String pathXML) throws GemEntityException;
}
