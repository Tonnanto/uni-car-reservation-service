package structure;

import model.PaymentType;
import model.Resource;

public class Booking {
    private String header;
    private String body;
    private String footer;
    private Resource resource;
    private PaymentType paymentType;

    public Booking(Resource resource, PaymentType paymentType) {
        this.resource = resource;
        this.paymentType = paymentType;
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

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}
