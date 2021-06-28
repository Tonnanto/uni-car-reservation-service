package model;

public interface Credential {
    boolean authenticate(Subject subject);
}
