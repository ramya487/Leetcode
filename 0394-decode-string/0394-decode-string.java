class Solution {
    int i = 0;

    public String decodeString(String s) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        String temp = "";
        
        while (i < s.length()) {
            char c = s.charAt(i);
        
            i++;
        
            if (c == '[') {
                temp = decodeString(s);
        
                int j = 0;
        
                while (j < count) {
                    sb.append(temp);
                    j++;
                }
        
                count = 0;
            } else if (c == ']')
                break;
            else if (Character.isAlphabetic(c))
                sb.append(c);
            else
                count = count * 10 + c - '0';
        }
        
        return sb.toString();
    }
}