package model;

public interface Visitable {
    @SuppressWarnings("unused")
    void accept(ContentVisitor visitor);
}
