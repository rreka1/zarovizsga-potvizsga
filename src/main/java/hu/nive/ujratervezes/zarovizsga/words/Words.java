package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count > (s.length() - count);
    }
}
