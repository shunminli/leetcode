class Solution {

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length < 1) {
      return "";
    }

    int len = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      len = Math.min(len, strs[i].length());
    }

    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < len; i++) {
      char target = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (target != strs[j].charAt(i)) {
          return ans.toString();
        }
      }

      ans.append(target);
    }

    return ans.toString();
  }
}
