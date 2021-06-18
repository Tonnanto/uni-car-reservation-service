package structure;

public abstract class Content {
    private final String name;

    public Content(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
