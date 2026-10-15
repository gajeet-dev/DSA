import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  private int n;
  private List<List<String>> result = new ArrayList<>();

  private int[] queens; // queens[row] = column
  private boolean[] cols;
  private boolean[] diag; // r + c
  private boolean[] anti; // r - c + n - 1

  private void backtrack(int row) {
    if (row == n) {
      saveBoard();
      return;
    }

    for (int col = 0; col < n; col++) {
      int d = row + col;
      int a = row - col + n - 1;

      if (cols[col] || diag[d] || anti[a]) {
        continue;
      }

      cols[col] = diag[d] = anti[a] = true;
      queens[row] = col;

      backtrack(row + 1);

      cols[col] = diag[d] = anti[a] = false;
    }
  }

  private void saveBoard() {
    List<String> sol = new ArrayList<>();

    for (int r = 0; r < n; r++) {
      char[] row = new char[n];

      Arrays.fill(row, '.');
      row[queens[r]] = 'Q';

      sol.add(new String(row));
    }
    result.add(sol);
  }

  public List<List<String>> solveNQueens(int n) {
    this.n = n;
    queens = new int[n];
    cols = new boolean[n];
    diag = new boolean[2 * n - 1];
    anti = new boolean[2 * n - 1];

    backtrack(0);

    return result;
  }
}
