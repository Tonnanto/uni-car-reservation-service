package structure;

public class EyeScanStrategy implements Credential{
    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }
}
