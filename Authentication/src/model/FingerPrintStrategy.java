package model;

public class FingerPrintStrategy extends Credential{
    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }
}
