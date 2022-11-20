package nullpractice.nullsafe;

public class NullSafePractice {

    public static void main(String[] args) {
        NullSafePractice practice = new NullSafePractice();

        boolean result = practice.isBadWord("I am BAD Boy");
        System.out.println("result = " + result);
    }

    public boolean isBadWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException("null 은 문자열이 아니에요");
        }

        return word.contains("BAD");
    }

    public Boolean isGoodWord(String word) {
        if (word == null) {
            return null;
        }

        return word.contains("GOOD");
    }

    public boolean isNiceWord(String word) {
        if (word == null) {
            return false;
        }

        return word.contains("NICE");
    }
}
