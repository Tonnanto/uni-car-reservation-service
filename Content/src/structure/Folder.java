package structure;

import java.util.LinkedList;
import java.util.List;

public class Folder extends Content {

    private final List<Content> contents;

    public Folder(String name) {
        super(name);
        contents = new LinkedList<>();
    }

    public void addContent(Content content) {
        this.contents.add(content);
    }

    public List<Content> getContents() {
        return new LinkedList<>(this.contents);
    }

    /**
     * Creates a File that contains a summary of all BookingFiles within this Folder.
     * Adds this File to it's own contents
     *
     * @return the created SummaryFile
     */
    public SummaryFile createSummaryFile() {
        SummaryFile file = new SummaryFile(this.getName() + "_Summary");
        //TODO: Add contents to summary file
        //TODO: Add file to this.contents  OR  override if already existing
        return file;
    }

}
