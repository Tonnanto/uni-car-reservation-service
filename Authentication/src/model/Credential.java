package model;

public abstract class Credential {

    public abstract boolean authenticate(Subject subject);
}
