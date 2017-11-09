#include <iostream>
#include <cstdio>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> numMap;
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            const int targetNum = target - nums[i];
            if (numMap.find(targetNum) != numMap.end()) {
                res.push_back(numMap[targetNum]);
                res.push_back(i);
                return res;
            }

            numMap[nums[i]] = i;
        }

        return res;
    }
};

int main() {
    Solution solution;
    int a[] = {2, 7, 11, 15} ;
    vector<int> inp(a, a + 4);
    const vector<int> res = solution.twoSum(inp, 9);
    cout << res[0] << " " << res[1] << endl;
    return 0;
}
