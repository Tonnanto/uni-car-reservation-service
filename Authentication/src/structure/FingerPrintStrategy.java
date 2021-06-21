package structure;

public class FingerPrintStrategy implements Credential{
    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }
}
