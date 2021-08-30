package model;

import java.text.BreakIterator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private final Resource resource;
    private final Payment payment;
    private final Person customer;

    private String header;
    private String body;
    private String footer;
    private Language language;
    private LocalDate bookingDate;

    public Booking(Resource resource, Payment payment, Person customer, LocalDate date) {
        this.resource = resource;
        this.payment = payment;
        this.customer = customer;
        this.bookingDate = date;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String buildHeader) {
        this.header = buildHeader;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public Resource getResource() {
        return resource;
    }

    public Payment getPayment() {
        return payment;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Person getCustomer() {
        return customer;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int documentWidth = 50;

        sb.append(String.format("┌────────────────────────────────────────────────────┐%n"));

        // Header
        for (String line : sentenceToLines(header, documentWidth)) {
            sb.append(String.format("│ %-50s │%n", line));
        }

        sb.append(String.format("├────────────────────────────────────────────────────┤%n"));

        // Body
        for (String line : sentenceToLines(body, documentWidth)) {
            sb.append(String.format("│ %-50s │%n", line));
        }

        sb.append(String.format("├────────────────────────────────────────────────────┤%n"));

        // Footer
        for (String line : sentenceToLines(footer, documentWidth)) {
            sb.append(String.format("│ %-50s │%n", line));
        }

        sb.append(String.format("└────────────────────────────────────────────────────┘%n"));

        return sb.toString();
    }

    private List<String> sentenceToLines(String sentence, int maxCharacters) {
        BreakIterator iterator = BreakIterator.getWordInstance();
        iterator.setText(sentence);
//        Queue<String> words = new LinkedList<>(Arrays.asList(sentence.split(" ")));
        List<String> lines = new ArrayList<>();

        StringBuilder line = new StringBuilder();

        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()
        ) {
            String word = sentence.substring(start, end);
//            if (word.contains("\n")) continue;

            if (!word.contains("\n") && line.length() + word.length() + 1 < maxCharacters) {
                line.append("").append(word);
            } else {
                lines.add(line.toString());
                line = new StringBuilder(word.contains("\n") ? "" : word);
            }
        }
        lines.add(line.toString());

        return lines;
    }
}
