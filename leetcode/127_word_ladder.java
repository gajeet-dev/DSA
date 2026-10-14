import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  private String endWord;
  private Set<String> wordList;

  private int bfs(Deque<String> queue) {
    int steps = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        String word = queue.poll();

        if (word.equals(endWord)) {
          return steps;
        }

        char[] arr = word.toCharArray();

        for (int j = 0; j < arr.length; j++) {
          char original = arr[j];

          for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch == original) {
              continue;
            }

            arr[j] = ch;

            String newWord = new String(arr);
            if (wordList.remove(newWord)) {
              queue.offer(newWord);
            }
          }

          arr[j] = original;
        }
      }
      steps++;
    }

    return 0;
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    this.endWord = endWord;
    this.wordList = new HashSet<>(wordList);

    if (!this.wordList.contains(endWord)) {
      return 0;
    }

    Deque<String> queue = new ArrayDeque<>();

    queue.offer(beginWord);
    this.wordList.remove(beginWord);

    return bfs(queue);
  }
}
