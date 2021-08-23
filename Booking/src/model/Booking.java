package model;

import view.Language;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

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
