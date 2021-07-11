package model;

public class Booking {
    private String header;
    private String body;
    private String footer;
    private Resource resource;
    private Payment payment;
    private Language language;

    public Booking(Resource resource, Payment payment) {
        this.resource = resource;
        this.payment = payment;
    }

    public void setHeader(String buildHeader) {
        this.header = buildHeader;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getHeader() {
        return header;
    }

    public String getBody() {
        return body;
    }

    public String getFooter() {
        return footer;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
