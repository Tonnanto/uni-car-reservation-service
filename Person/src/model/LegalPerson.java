package model;

public class LegalPerson implements Person {

    private String name;
    private final int id;
    private String email;

    public LegalPerson(int id) {
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

