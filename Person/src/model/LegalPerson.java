package model;

public class LegalPerson implements Person {

    private String name;
    private int id;

    public LegalPerson(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }
}

