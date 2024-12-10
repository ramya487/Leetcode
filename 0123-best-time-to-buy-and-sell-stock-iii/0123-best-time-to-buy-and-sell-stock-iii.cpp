//Recursive -Memoization approach.
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // as two transactions are allowed.
        // also we have 2 options for 2 transactions 

        // option - 0/1 -> sell/buy , transactions - 1st/2nd.

        
        int holdOne = INT_MIN;// The maximum profit achievable after buying the stock for the first transaction.
        int sellOne = 0;// The maximum profit achievable after completing one transaction.
        int holdTwo = INT_MIN;// The maximum profit achievable after buying the stock for the second transaction.
        int sellTwo = 0;// The maximum profit achievable after completing two transactions.

        for(int price:prices){
            holdOne = max(holdOne,-price);// pay today's price .
            sellOne = max(sellOne,price + holdOne);// get today's price with the value of stock on which you purchased it(cost price + profit(because of value change per day)).
            holdTwo = max(holdTwo,-price + sellOne);//pay today's price and you also have to give your stock's cost price.
            sellTwo = max(sellTwo,price + holdTwo);//get today's price with the value of stock on which you purchased it(cost price + profit(because of value change per day)).
        }
        // sellTwo is the cumulative profit as it's using all the 3 variables before it.
        // for all the day's price.
        return sellTwo;// final price after two transactions.
    }
};