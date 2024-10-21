import java.util.*;

public class SpiralOrder {
    //模拟
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = 0;
        boolean[][] visited = new boolean[rows][columns];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        int total = columns * rows;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextrow = row + directions[directionIndex][0], nextcolumn = column + directions[directionIndex][1];
            if (nextrow < 0 || nextrow >= rows || nextcolumn < 0 || nextcolumn >= columns || visited[nextrow][nextcolumn] == true)
                directionIndex = (directionIndex + 1) % 4;
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;

    }

    //简化空间复杂度,层层遍历
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return order;
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1;
        int top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom - 1; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column >= 0; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][top]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;

    }
}
