class Solution {
  private boolean matches(int[] a, int[] b) {
    for (int i = 0; i < 26; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }

    return true;
  }

  public boolean checkInclusion(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();

    if (m > n) {
      return false;
    }

    int[] target = new int[26];
    int[] window = new int[26];

    for (int i = 0; i < m; i++) {
      target[s1.charAt(i) - 'a']++;
      window[s2.charAt(i) - 'a']++;
    }

    int left = 0;

    for (int right = m; right < n; right++) {
      if (matches(target, window)) {
        return true;
      }

      // Remove the character leaving the window.
      window[s2.charAt(left) - 'a']--;

      // Add the character entering the window.
      window[s2.charAt(right) - 'a']++;

      left++;
    }

    return matches(target, window);
  }
}
