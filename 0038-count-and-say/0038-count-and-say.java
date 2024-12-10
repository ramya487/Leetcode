class Solution {
    public String countAndSay(int n) {
        int i = 1;
        StringBuilder sb = new StringBuilder("1");
        while(i<n){
            sb = convert(sb);
            i++;
            // sb = s;
        }
        return sb.toString();
    }
    public StringBuilder convert(StringBuilder sb){
        StringBuilder s = new StringBuilder();
        int count = 1;
        int left = 0;
        int right = 1;
        while(left <sb.length()){
            while(right<sb.length() && sb.charAt(left)==sb.charAt(right)){
                right++;
            
                count++;
            }
            s.append(count+""+sb.charAt(left));
            left = right;
            right++;
            count = 1;
        }
        return s;
    }
}