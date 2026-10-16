class Solution {
  public int tribonacci(int n) {
    if (n < 2) {
      return n;
    }

    int t0 = 0, t1 = 1, t2 = 1;
    int next = 0;

    for (int i = 3; i <= n; i++) {
      next = t0 + t1 + t2;
      t0 = t1;
      t1 = t2;
      t2 = next;
    }

    return t2;
  }
}
