package structure;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Folder extends Content {

    private final Map<String, Content> contents;

    public Folder(String name) {
        super(name);
        contents = new TreeMap<>();
    }

    public Content getContent(String name) {
        return this.contents.get(name);
    }

    public Map<String, Content> getContents() {
        return this.contents;
    }

    private boolean addContent(Content content) {
        if (getContent(content.getName()) != null) return false;
        this.contents.put(content.getName(), content);
        this.createSummaryFile();
        return true;
    }


    /**
     * Adds Content at the specified path.
     * Only fails if the specified path exists but is not a folder.
     *
     * @param content the content to be added
     * @param path the specified path as Strings
     */
    public boolean addContent(Content content, String... path) {
        if (path.length <= 0)
            return addContent(content);

        boolean success = true;
        Content subContent = this.getContent(path[0]);
        Folder subFolder;

        if (subContent == null) {
            // Specified path does not yet exist
            subFolder = new Folder(path[0]);
            success = this.addContent(subFolder);

        } else if (subContent instanceof Folder) {
            // Specified path exists
            subFolder = (Folder) subContent;

        } else {
            // Specified path exists but is not a Folder
            return false;
        }

        if (path.length > 1)
            success = subFolder.addContent(content, Arrays.copyOfRange(path, 1, path.length)) && success;
        else
            success = subFolder.addContent(content) && success;

        return success;
    }


    /**
     * Creates a File that contains a summary of all BookingFiles within this Folder.
     * Adds this File to it's own contents
     */
    private void createSummaryFile() {
        SummaryFile file = new SummaryFile(this.getName() + "_Summary");
        //TODO: Add contents to summary file

        // Adds or overrides summary file to folder
        this.contents.put(file.getName(), file);
    }


    /**
     * @return a visual string-representation of the content hierarchy within this Folder
     */
    @Override
    public String toString() {
        return "-------------------------------------------------------\n" +
                toString(0) +
                "\n-------------------------------------------------------";
    }

    private String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName());

        for (Map.Entry<String, Content> entry: this.contents.entrySet()) {
            sb.append("\n").append(new String(new char[indent]).replace("\0", "."));
            sb.append(". ");
            if (entry.getValue() instanceof Folder) {
                Folder folder = (Folder) entry.getValue();
                sb.append(folder.toString(indent + 1));

            } else {
                sb.append(entry.getValue().getName()).append(".file");
            }
        }

        return sb.toString();
    }
}
