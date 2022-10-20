package gmail.jackjliew.test;

public class IntToRoman {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String res = "";
        for (int i = 0; i < values.length; i++) {
            System.out.println(">>>> i=" + i + ", num=" + num + ", value=" + values[i]);
            while (num >= values[i]) {
                System.out.println(">>>>>>>> i=" + i + ", num=" + num + ", value=" + values[i]);
                int z = num / values[i];
                System.out.println("z=" + z);
                while (z > 0) {
                    res += strs[i];
                    z--;
                }
                num %= values[i];
            }
        }
        return res;
    }

    public String intToRomanOnlySubstraction(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < symbols.length; i++) {

            if (num > 0) {

                while (num >= numbers[i]) {
                    num = num - numbers[i];
                    sb.append(symbols[i]);
                }

            }
        }

        return sb.toString();
    }

    public static class RomanDictionary {
        String symbol;
        int value;

        public RomanDictionary(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }

    }

    static final RomanDictionary[] ROMANS = {
            new RomanDictionary("M", 1000),
            new RomanDictionary("CM", 900),
            new RomanDictionary("D", 500),
            new RomanDictionary("CD", 400),
            new RomanDictionary("C", 100),
            new RomanDictionary("XC", 90),
            new RomanDictionary("L", 50),
            new RomanDictionary("XL", 40),
            new RomanDictionary("X", 10),
            new RomanDictionary("IX", 9),
            new RomanDictionary("V", 5),
            new RomanDictionary("IV", 4),
            new RomanDictionary("I", 1)
    };

    public String intToRomanObject(int num) {
        StringBuilder result = new StringBuilder();

        for (RomanDictionary roman : ROMANS) {
            while (num - roman.value >= 0) {
                result.append(roman.symbol);
                num -= roman.value;
            }
        }

        return result.toString();
    }

    public int romanToInt(String roman) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int result = 0;
        for (int i = 0; i < symbols.length; i++) {
            System.out.println("i="+i+",roman=" + roman);
            while(roman.startsWith(symbols[i])){
                System.out.println("roman=" + roman+", start with " + symbols[i]);
                result += numbers[i];
                System.out.println("sub="+roman.substring(symbols[i].length()));
                roman = roman.substring(symbols[i].length()) ;
                System.out.println("roman=" + roman);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(2994));
        System.out.println(intToRoman.intToRomanOnlySubstraction(2994));
        System.out.println(intToRoman.intToRomanObject(2994));

        System.out.println(intToRoman.romanToInt("MMCMXCIV"));
    }
}
