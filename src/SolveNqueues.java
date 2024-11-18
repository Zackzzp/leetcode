import org.w3c.dom.html.HTMLUListElement;

import java.util.*;

public class SolveNqueues {
    //集合回溯
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagnoals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagnoal1 = row - i;
                if (diagonals1.contains(diagnoal1)) {
                    continue;
                }
                int diagnoal2 = row + i;
                if (diagnoals2.contains(diagnoal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagnoal1);
                diagnoals2.add(diagnoal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagnoals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagnoal1);
                diagnoals2.remove(diagnoal2);
            }
        }

    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    //位运算回溯 x&(-x) 获得x的二进制的最低位的1的位置  x&(x-1) 将x二进制的最低位的1置为0
    public List<List<String>> solveNQueens1(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        List<List<String>> solutions=new ArrayList<>();
        solve(solutions,queens,n,0,0,0,0);
        return solutions;
    }

    public void solve(List<List<String>> solutions, int[] queens, int n, int row, int columns, int diagonal1, int diagonal2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            int availablePostions = ((1 << n - 1) & (~(columns | diagonal1 | diagonal2)));
            while (availablePostions != 0) {
                int position = availablePostions & (-availablePostions);
                availablePostions = availablePostions & (availablePostions - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                solve(solutions, queens, n, row + 1, columns | position, (diagonal1 | position) << 1, (diagonal2 | position) >> 1);
                queens[row] = -1;
            }
        }
    }
}
