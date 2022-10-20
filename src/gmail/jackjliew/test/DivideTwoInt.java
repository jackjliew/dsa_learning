package gmail.jackjliew.test;

public class DivideTwoInt {
    public int divide(int dividend, int divisor) {
        int quotient = 0;
        int abs_divisor = java.lang.Math.abs(divisor);
        long abs_dividend = 0;
        if (dividend == Integer.MIN_VALUE) {
            abs_dividend = java.lang.Math.abs((long)dividend);
        } else {
            abs_dividend = java.lang.Math.abs(dividend);
        }

        System.out.println("abs_dividend=" + abs_dividend + ", abs_divisor=" + abs_divisor);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        if (abs_dividend < abs_divisor)
            return quotient;


        long remain = abs_dividend;

        while (remain >= abs_divisor) {
            //System.out.println("quotient="+quotient);
            remain = remain - abs_divisor;
            if (quotient <= Integer.MAX_VALUE - 1){
                quotient++;
            }
        }
        System.out.println("dividend=" + dividend + ", divisor=" + divisor);
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {

            return -quotient;
        }
        {
            System.out.println("positive");
            return quotient;
        }
    }

    public static void main(String[] args) {
        DivideTwoInt sut = new DivideTwoInt();
        System.out.println("result: " +sut.divide(-2147483648, -1));




    }
}
