package model;

public interface Visitable {
    void accept(StatisticsVisitor visitor);
}
