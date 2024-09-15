// stack - StringBuilder
// T- O(N)
// S- O(N)
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder stack = new StringBuilder();
        int c = 0;
        for (char item: num.toCharArray()){
            while (stack.length() > 0 && c < k && stack.charAt(stack.length()-1) > item){
                stack.deleteCharAt(stack.length()-1);
                c++;
            }
            stack.append(item);
        }

        while (c < k && stack.length() > 0){
            stack.deleteCharAt(stack.length()-1);
            c++;
        }
        while (stack.length() > 0 && stack.charAt(0) == '0'){
            stack.deleteCharAt(0);
        }
        return stack.length() == 0 ? "0" : stack.toString();
    }
}