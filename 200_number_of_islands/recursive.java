/**
 * Concise land filler by recursion
 */
class Solution {
  private int[] dy = {-1, 0, 1, 0};
  private int[] dx = {0, -1, 0, 1};

  public int numIslands(char[][] grid) {
    int answer = 0;
    int h = grid.length;
    if (h == 0) return answer;
    int w = grid[0].length;

    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (grid[i][j] == '1') {
          answer++;
          fillLandAsSearched(grid, i, j);
        }
      }
    }

    return answer;
  }

  private void fillLandAsSearched(char[][] grid, int y, int x) {
    grid[y][x] = '0';
    int h = grid.length;
    int w = grid[0].length;
    for (int i = 0; i < dy.length; i++) {
      int ny = y + dy[i];
      int nx = x + dx[i];
      if (ny >= 0 && ny < h && nx >= 0 && nx < w && grid[ny][nx] == '1') {
        fillLandAsSearched(grid, ny, nx);
      }
    }
  }
}
