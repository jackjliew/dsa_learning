package gmail.jackjliew.test;

/*

Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-2^31 <= x <= 2^31 - 1
 */
public class ReverseInteger {

    public int reverse(int x) {
        System.out.println("#################");
        int result = 0;

        String s = String.valueOf(x);
        StringBuffer srb = new StringBuffer();
        int count = s.length();
        int endIndex = 0;
        // Check the 1st char is a sign
        if (s.charAt(0) == "-".charAt(0) || s.charAt(0) == "+".charAt(0)){
            System.out.println("Found sign: " + s.charAt(0));
            endIndex = 1;
        }
        for (int i = count - 1; i >= endIndex; i--) {
            srb.append(s.charAt(i));
        }
        if (endIndex == 1) {
            srb.insert(0, s.charAt(0));
        }
        System.out.println("Reversed string: " + srb.toString());
        try {
            result = Integer.parseInt(srb.toString());
        } catch (NumberFormatException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt(String.valueOf(Integer.MAX_VALUE + 2)));
        //System.out.println(Integer.parseInt("2147483648"));

        ReverseInteger reverseInteger = new ReverseInteger();
        assert reverseInteger.reverse(123) == 321;
        assert reverseInteger.reverse(-123) == -321;
        assert reverseInteger.reverse(120) == 21;

        System.out.println(reverseInteger.reverse(123));
        System.out.println(reverseInteger.reverse(-123));
        System.out.println(reverseInteger.reverse(120));
        System.out.println(reverseInteger.reverse(2147483647)); // MAX
        System.out.println(reverseInteger.reverse(2147483642));

        System.out.println(reverseInteger.reverse(-2147483648)); // MIN
        System.out.println(reverseInteger.reverse(-2147483642));
    }
}
