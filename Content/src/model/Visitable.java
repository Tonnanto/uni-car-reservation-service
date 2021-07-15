package model;

public interface Visitable {
    void accept(ContentVisitor visitor);
}
