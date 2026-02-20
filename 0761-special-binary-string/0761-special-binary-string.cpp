class Solution {
public:
    string makeLargestSpecial(string s) {
        vector<string> parts;

        int count = 0;
        int start = 0;

        // split into primitive special strings
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '1') count++;
            else count--;

            // found one special substring
            if (count == 0) {
                // recursive solve for inside part
                string inner = makeLargestSpecial(
                    s.substr(start + 1, i - start - 1)
                );

                parts.push_back("1" + inner + "0");
                start = i + 1;
            }
        }

        // sort descending for lexicographically largest
        sort(parts.rbegin(), parts.rend());

        // join all
        string result;
        for (auto &p : parts)
            result += p;

        return result;
    }
};