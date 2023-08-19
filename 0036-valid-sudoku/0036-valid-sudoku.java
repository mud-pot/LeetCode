import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create maps to keep track of numbers in rows, columns, and sub-boxes
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> subBoxes = new HashMap<>();

        // Initialize the maps with empty sets
        for (int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            columns.put(i, new HashSet<>());
            subBoxes.put(i, new HashSet<>());
        }

        // Iterate through each cell in the 9x9 Sudoku board
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char num = board[row][col];

                // Skip empty cells represented by '.'
                if (num == '.') {
                    continue;
                }

                // Check if the current number violates Sudoku rules
                if (rows.get(row).contains(num) || 
                    columns.get(col).contains(num) || 
                    subBoxes.get((row / 3) * 3 + col / 3).contains(num)) {
                    return false;
                }

                // Update sets to keep track of encountered numbers
                rows.get(row).add(num);
                columns.get(col).add(num);
                subBoxes.get((row / 3) * 3 + col / 3).add(num);
            }
        }

        // If all cells satisfy Sudoku rules, the board is valid
        return true;
    }
}
