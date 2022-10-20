package gmail.jackjliew.test;

public class MyAtoi {
    public int myAtoi(String s) {

        if (s == null || s.trim().equals("")) {
            return 0;
        }
        s = s.trim();
        System.out.println("Trimmed string: " + s);
        if ((s.charAt(0) != "+".charAt(0) && s.charAt(0) != "-".charAt(0)) &&
                (s.charAt(0) < 48 || s.charAt(0) > 57)
        ) {
            System.out.println("not digits or sign");
            return 0;
        }

        boolean negetive = false;
        boolean isSigned = false;
        if (s.charAt(0) == "-".charAt(0) || s.charAt(0) == "+".charAt(0)) {
            isSigned = true;
        }
        if (s.charAt(0) == "-".charAt(0)) {
            negetive = true;
        }
        // find first non-digit
        int startIndex = isSigned ? 1 : 0;
        int firstNonDigit = s.length();
        for (int i = startIndex; i < s.length(); i++) {
            if (s.charAt(i) < 48 || s.charAt(i) > 57) {
                firstNonDigit = i;
                break;
            }
        }
        System.out.println("start index: " + startIndex + ", end index: " + firstNonDigit);

        if (startIndex == firstNonDigit) {
            return 0;
        }
        String digitString = s.substring(startIndex, firstNonDigit);
        System.out.println("digit string: " + digitString);

        try {
            return negetive ? -Integer.valueOf(digitString) : Integer.valueOf(digitString);
        } catch (NumberFormatException e) {
            return negetive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }

    public static void main(String[] args) {
        System.out.println((int) "0".charAt(0));
        System.out.println((int) "1".charAt(0));
        System.out.println((int) "9".charAt(0));
        System.out.println((int) "a".charAt(0));
        System.out.println((int) "b".charAt(0));
        System.out.println((int) "z".charAt(0));
        System.out.println((int) "A".charAt(0));
        System.out.println((int) "B".charAt(0));
        System.out.println((int) "Z".charAt(0));
        System.out.println((char) 91);
        System.out.println((char) 92);
        System.out.println((char) 93);
        System.out.println((char) 94);
        System.out.println((char) 95);
        System.out.println((char) 96);
        System.out.println((char) 97);
        System.out.println((int) "+".charAt(0));
        System.out.println((char) 44);
        System.out.println((int) "-".charAt(0));

        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi("-1355"));
        System.out.println(myAtoi.myAtoi("4193 with words"));
        System.out.println(myAtoi.myAtoi("words and 987"));
        System.out.println(myAtoi.myAtoi("    -42"));

        System.out.println(myAtoi.myAtoi("+-12"));

        System.out.println(myAtoi.myAtoi("  -0012a42"));
    }

}
