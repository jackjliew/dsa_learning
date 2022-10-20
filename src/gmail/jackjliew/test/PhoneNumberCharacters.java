package gmail.jackjliew.test;

import java.util.ArrayList;
import java.util.List;

public class PhoneNumberCharacters {
    public List<String> letterCombinationsDFS(String digits) {
        String[] dmap = new String[]{" ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};
        char[] cur = new char[digits.length()];
        List<String> ans = new ArrayList<>();
        dfs(digits, dmap, 0, cur, ans);
        return ans;
    }

    private void dfs(String digits, String[] d, int l, char[] cur, List<String> ans) {
        if (l == digits.length()) {
            System.out.println(l + " == " + digits.length() + ", add: " + new String(cur));
            if (l > 0) ans.add(new String(cur));
            return;
        }
        System.out.println("l="+l+",digits.charAt(l)=" + digits.charAt(l) + ", Character.getNumericValue(digits.charAt(l))=" +Character.getNumericValue(digits.charAt(l)));
        String s = d[Character.getNumericValue(digits.charAt(l))];

        System.out.println("l: " + l + ", s: " + s);
        for (int i = 0; i < s.length(); ++i) {
            cur[l] = s.charAt(i);
            System.out.println(">> cur["+l+"]=" + cur[l] + ", ans= " + ans);
            dfs(digits, d, l + 1, cur, ans);
        }
    }

    public List<String> letterCombinationsBFS(String digits) {
        if (digits.length() == 0) return new ArrayList<String>();

        String[] d = new String[]{" ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"};
        List<String> ans = new ArrayList<>();
        ans.add("");
        for (char digit : digits.toCharArray()) {
            List<String> tmp = new ArrayList<>();
            for (String t : ans) {
                String s = d[Character.getNumericValue(digit)];
                for (int i = 0; i < s.length(); ++i)
                    tmp.add(t + s.charAt(i));
            }
            ans = tmp;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println( new PhoneNumberCharacters().letterCombinationsBFS("234"));
    }
}
