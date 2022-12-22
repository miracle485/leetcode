package moban;

public class Gcd {
    public static void main(String[] args) {

    }

    private static int gcd(int a, int b) {
        if (a % b != 0) {
            return gcd(b, a % b);
        }
        return b;
    }
}
