class Solution {
  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }

    int[] freq = new int[128];

    for (int i = 0; i < t.length(); i++) {
      freq[t.charAt(i)]++;
    }

    int left = 0;
    int count = t.length();

    int minStart = 0;
    int minLen = Integer.MAX_VALUE;

    for (int right = 0; right < s.length(); right++) {
      char ch = s.charAt(right);

      if (freq[ch] > 0) {
        count--;
      }
      freq[ch]--;

      while (count == 0) {
        int windowLen = right - left + 1;

        if (windowLen < minLen) {
          minLen = windowLen;
          minStart = left;
        }

        char leftChar = s.charAt(left);
        freq[leftChar]++;

        if (freq[leftChar] > 0) {
          count++;
        }

        left++;
      }
    }

    return minLen == Integer.MAX_VALUE
        ? ""
        : s.substring(minStart, minStart + minLen);
  }
}
