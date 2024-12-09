class Solution {
public:
    string getHint(string secret, string guess) {
        int secret_size = secret.size();
        int bulls = 0;
        string hint = "";
        for(int i = 0; i < secret_size; i++)
            if(secret[i] == guess[i]) {
                secret[i] = guess[i] = 'o';
                bulls++;
            }
        hint += to_string(bulls);
        hint.push_back('A');

        unordered_map<char,pair<int,int>> char_count;
        for(int i = 0; i < secret_size; i++) {
            char_count[secret[i]].first++;
            char_count[guess[i]].second++;
        }
        char_count.erase('o');

        int cows = 0;
        for(auto [theChar, theCount]: char_count)
            cows += min(theCount.first, theCount.second);
        hint += to_string(cows);
        hint.push_back('B');

        return hint;
        
    }
};