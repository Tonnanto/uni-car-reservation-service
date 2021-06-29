package model;

public class EyeScanStrategy extends Credential{
    @Override
    public boolean authenticate(Subject subject) {
        return true;
    }
}
