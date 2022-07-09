package lecture05polymorphism.E04Word;

public class Clipboard {
    private StringBuilder contents;

    public String getContents() {
        return contents.toString();
    }

    public void setContents(String contents) {
        this.contents = new StringBuilder(contents);
    }

    public void clearContents() {
        setContents("");
    }
}
