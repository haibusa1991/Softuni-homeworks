package lecture01WorkingWithAbstraction.E05JediGalaxy;

public abstract class Actor {
    protected int row;
    protected int col;

    public void setLocation(int[] coordinates) {
        this.row = coordinates[0];
        this.col = coordinates[1];
    }
}
