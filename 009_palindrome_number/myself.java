class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int l = s.length();
        if (l < 2) {
            return true;
        }
        for (int i = 0; i < l / 2; i++) {
            if (s.charAt(i) != s.charAt(l - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
