class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        for (int m = 0; m < commands.size(); m++) {
            if (commands.get(m).equals("RIGHT")) {
                j++;
            } else if (commands.get(m).equals("LEFT")) {
                j--;
            } else if (commands.get(m).equals("UP")) {
                i--;
            } else {
                i++;
            }
        }
        return (i * n) + j;
    }
}