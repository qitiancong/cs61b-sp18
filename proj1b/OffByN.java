public class OffByN implements CharacterComparator {
    private int num;

    public OffByN(int n) {
        this.num = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y == this.num || y - x == this.num;
    }
}
