package structure;

public class UserNamePasswordStrategy implements Credential{

    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }
}
