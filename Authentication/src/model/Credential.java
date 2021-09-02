package model;

public abstract class Credential {

    public abstract boolean authenticate(@SuppressWarnings("unused") Subject subject);

    public abstract String getDescription();
}
