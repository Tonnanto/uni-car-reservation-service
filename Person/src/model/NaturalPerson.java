package model;

public class NaturalPerson implements Person {

    private String name;
    private int id;

    public NaturalPerson(String name, int id) {
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