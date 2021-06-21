package structure;

public class Booking {
    private String header;
    private String body;
    private String footer;
//    private Resource resource;    TODO implement Recourse & Payment
//    private PaymentType paymentType;

    public void setHeader(String buildHeader) {
        this.header = buildHeader;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }
}
