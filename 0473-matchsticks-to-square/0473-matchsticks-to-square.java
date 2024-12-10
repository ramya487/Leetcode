class Solution {
    
    public boolean makesquare(int[] matchsticks) {
        int perimeter = 0;
        for (int val : matchsticks)
            perimeter += val;

        if (perimeter % 4 != 0)
            return false; // perimeter of a square should be divisible by 4

        int[] sides = new int[4];
        // side length of a square is perimeter/4.
        int side_length = perimeter / 4;
        
        Arrays.sort(matchsticks);//sorting in ascending order
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - i - 1];
            matchsticks[matchsticks.length - i - 1] = temp;
        }
        //then sorthing in descending order

        // we are sorting in descending order
        // to optimize the algo.
        // if for a larger length we cannot make square then 
        // definitely we cant make a square.
        return backtrack(sides, matchsticks, 0, side_length);
    }

    private boolean backtrack(int[] sides, int[] matchsticks, int index, int side_length) {
        if (index == matchsticks.length)
            return true;

        for (int i = 0; i < 4; ++i) {
            if (sides[i] + matchsticks[index] <= side_length) {
                sides[i] += matchsticks[index];
                if (backtrack(sides, matchsticks, index + 1, side_length)) // check with next matchstick
                    return true;
                sides[i] -= matchsticks[index]; // backtrack and try for another side.
            }
        }

        return false;
    }
}

/*
In this problem, we need to understand that all the matchsticks can be placed only on four sides of the square. So the perimeter of the square is the sum of lengths of all the matchsticks. 

//If that perimeter is not divisible by 4 then we cannot make a square at all. 

Now we need to take each matchstick and check which side we can place it on.
If one combination of placing matchsticks fails we backtrack to the previous step and try another combination.
*/