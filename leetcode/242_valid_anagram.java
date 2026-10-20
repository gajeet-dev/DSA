import java.util.HashMap;
import java.util.Map;

class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> sFreq = new HashMap<>();

    for (char ch : s.toCharArray()) {
      sFreq.put(ch, sFreq.getOrDefault(ch, 0) + 1);
    }

    for (char ch : t.toCharArray()) {
      int count = sFreq.getOrDefault(ch, 0);

      if (count == 0) {
        return false;
      }

      sFreq.put(ch, count - 1);
    }

    return true;
  }
}
