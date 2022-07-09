package lecture06.L04Songs;

public class Song {
    private String type;
    private String name;

    public Song(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
