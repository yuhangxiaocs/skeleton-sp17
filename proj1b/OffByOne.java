public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return (x - y == 1) || (x - y == -1);
    }

    public static void main(String[] args) {
        char x = 'x';
        char y = 'y';
        System.out.println(x - y);
    }
}
