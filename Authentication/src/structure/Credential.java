package structure;

public interface Credential {
    boolean authenticate(Subject subject);
}
