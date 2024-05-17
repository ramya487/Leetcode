class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = numBottles;
        int emp = 0;
        int ex = numExchange;
        int d = 0;
        while (!(full == 0 && emp < ex)){
            if (emp<ex){
                emp+= full;
                d+=full;
                full = 0;
            }else {
                emp-=ex;
                full++;
                ex++;
            }
        }
        return d;
    }
}