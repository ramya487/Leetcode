class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String longestStr = ""; // Variable to store the current longest valid word

        for (String d : dictionary) { // Iterate through each word in the dictionary
            // Skip if the current longest word is longer than the current dictionary word
            if (!longestStr.isEmpty() && longestStr.length() > d.length()) {
                continue;
            }

            int i = 0; // Pointer for string `s`
            int j = 0; // Pointer for the dictionary word `d`

            // Two-pointer traversal of `s` and `d`
            while (i < s.length()) {
                char sChar = s.charAt(i); // Character from `s`
                char dChar = d.charAt(j); // Character from `d`

                if (sChar == dChar) { // Match found
                    j++; // Move to the next character in `d`
                    if (j == d.length()) { // If all characters in `d` are matched
                        if (longestStr.length() < d.length()) {
                            longestStr = d; // Update `longestStr` if `d` is longer
                        }
                        if (longestStr.length() == d.length()) {
                            // Compare lexicographically if lengths are equal
                            for (int k = 0; k < longestStr.length(); k++) {
                                if (longestStr.charAt(k) > d.charAt(k)) {
                                    longestStr = d; // Update to lexicographically smaller word
                                } else if (longestStr.charAt(k) == d.charAt(k)) {
                                    continue;
                                } else {
                                    break;
                                }
                            }
                        }
                        break; // Break the loop once a valid word is found
                    }
                }
                i++; // Always move to the next character in `s`
            }
        }

        return longestStr; // Return the longest valid word
    }
}