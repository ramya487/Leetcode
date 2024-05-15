class Solution {
    public boolean isPalindrome(int x) {
        int temp = 0;
        int dup = x;
        while (x>0){
            int ldigit = x%10;
            temp = temp*10+ldigit;
            x = x/10;
        }
        if (temp == dup){
            return true;
        }
        return false;
    }
}