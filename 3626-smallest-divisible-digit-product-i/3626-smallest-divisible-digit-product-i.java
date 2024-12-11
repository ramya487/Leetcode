class Solution {
    public int smallestNumber(int n, int t) {
        int number = n;

        while (true) {
            if (isDivisibleByT(number, t)) {
                return number;
            }
            number++;
        }
    }

    private boolean isDivisibleByT(int number, int t) {
        int product = 1;
        while (number > 0) {
            int digit = number % 10;
            product *= digit;
            number /= 10;
        }
        return product % t == 0;
    }
}