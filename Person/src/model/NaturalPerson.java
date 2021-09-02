package model;

public class NaturalPerson implements Person, Subject {

    private String name;
    private final int id;
    private String email;

    public NaturalPerson(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }
}