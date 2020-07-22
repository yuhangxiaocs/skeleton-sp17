public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == N;
    }

    public static void main(String[] args) {
        System.out.println(new OffByN(5).equalChars('a', 'f'));
        System.out.println(new OffByN(5).equalChars('h', 'f'));
    }
}
