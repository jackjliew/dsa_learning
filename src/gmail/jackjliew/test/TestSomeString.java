package gmail.jackjliew.test;

public class TestSomeString {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int currentMax = 0;
        int begineIndex = 0;
        int endIndex = 1;

        System.out.println(s.substring(begineIndex, endIndex));
        System.out.println(s.charAt(endIndex));

        while (begineIndex < s.length()) {
            while (endIndex <= s.length()) {
                String currentSubString = s.substring(begineIndex, endIndex);
                System.out.println("begineIndex: " + begineIndex + ", currentSubString: " + currentSubString);


                if (endIndex != s.length() && currentSubString.indexOf(s.charAt(endIndex)) == -1) {
                    System.out.println("add nextChar:" + s.charAt(endIndex));
                    endIndex++;
                    System.out.println("update endIndex:" + endIndex);
                } else {

                    currentMax = currentSubString.length();
                    System.out.println("FOUND, begineIndex: " + begineIndex + ", currentSubString: " + currentSubString + ", currentMax: " + currentMax);
                    break;
                }
            }
            if (currentMax > max) {
                System.out.println("====UPDATE MAX to " + currentMax);
                max = currentMax;
            }

            begineIndex++;
            endIndex = begineIndex + 1;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        TestSomeString test = new TestSomeString();
        test.lengthOfLongestSubstring("abcabcbb");
        test.lengthOfLongestSubstring("pwwkew");
        test.lengthOfLongestSubstring("bbbbb");
    }
}

