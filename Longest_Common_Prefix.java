
//14. Longest Common Prefix
//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".

public class Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(strings));

    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        if (strs.length > 1) {
            boolean isBreak = false;
            for (int i = 0; i < strs[0].length() && !isBreak; ++i) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; ++j) {
                    if (strs[j].length() == i || c != strs[j].charAt(i)) {
                        isBreak = true;
                        break;
                    }
                }

                if (!isBreak) {
                    result.append(c);
                }
            }


        } else if (strs.length == 1) {
            return strs[0];
        }

        return result.toString();
    }
}
