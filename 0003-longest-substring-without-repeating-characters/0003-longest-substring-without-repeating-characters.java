class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set  = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int maxx = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            if (!set.contains(Character.valueOf(c)) || set.isEmpty()){
                set.add(c);
                right++;
            }else{
                maxx = Math.max(right-left,maxx);
                while (s.charAt(right) != s.charAt(left)) left++;
                right = left+1;
                left++;
                set.clear();
            }
        }
        maxx = Math.max(right-left, maxx);
        return maxx;
    }
}