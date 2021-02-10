package graph.problems;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /*
    Insights: Build the solution (arrangement of queens on the board) row by row
*/
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> result = new ArrayList<>();
            if(n <= 0) return result;
            List<Integer> cols = new ArrayList<>();

            // 3 parameter for the row-based search with backtracking:
            // result set, current status, boardsize
            searchWithBacktracking(result, cols, n);
            return result;
        }

        private void searchWithBacktracking(List<List<String>> result, List<Integer> cols, int n) {
            // all rows are settled, return result
            if(cols.size() == n) {
                result.add(drawBoard(cols));
                return;
            }
            // for the next row, try all the n col-indices
            // if valid, add to cols (partial result)
            // if not, backtrack to last step
            for(int colIndex = 0; colIndex < n; colIndex++) {
                if(!isValid(cols, colIndex)) continue;
                cols.add(colIndex);
                searchWithBacktracking(result, cols, n);

                // IMPORTANT: backtracking step
                cols.remove(cols.size()-1);
            }
        }

        private boolean isValid(List<Integer> cols, int colIndex) {
            int nrow = cols.size();
            // check for violations between each of the settled row and the current row
            for(int rowIndex = 0; rowIndex < nrow; rowIndex++){
                Integer prevColIndex = cols.get(rowIndex);
                // Violation 1 : same column
                if (prevColIndex.equals(colIndex)) {
                    return false;
                }
                // Violation 2 : dale diagonals
                if (rowIndex - prevColIndex == nrow - colIndex) {
                    return false;
                }
                // Violation 3 : hill diagonals
                if (rowIndex + prevColIndex == nrow + colIndex) {
                    return false;
                }
            }
            return true;
        }

        // helper function for drawing the resulting board
        private List<String> drawBoard(List<Integer> cols) {
            List<String> result = new ArrayList<>();
            for(int i = 0; i < cols.size(); i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < cols.size(); j++) {
                    if(j == cols.get(i)) sb.append('Q');
                    else sb.append('.');
                }
                result.add(sb.toString());
            }
            return result;
        }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        System.out.println(nq.solveNQueens(4));
    }
}
