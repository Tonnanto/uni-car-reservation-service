package model;

public interface Person {
    String getName();

    void setName(String name);

    @SuppressWarnings("unused")
    int getId();

    String getEmail();

    void setEmail(String email);

}
