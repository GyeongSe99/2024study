package Test3;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] sudoku;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            sudoku = new int[9][9];

            for (int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (checkRow() && checkCol() && checkSmallSquare()) {
                System.out.println("#" + test_case + " " + 1);
            } else {
                System.out.println("#" + test_case + " " + 0);
            }
        }
    }

    static boolean checkRow() {
        for (int i = 0; i < sudoku.length; i++) {
            int[] count = new int[10];
            for (int j = 0; j < sudoku[i].length; j++) {
                if (count[sudoku[i][j]] != 0) return false;
                count[sudoku[i][j]]++;
            }
        }

        return true;
    }

    static boolean checkCol() {
        for (int i = 0; i < sudoku[0].length; i++) {
            int[] count = new int[10];
            for (int j = 0; j < sudoku.length; j++) {
                if (count[sudoku[j][i]] != 0) return false;
                count[sudoku[j][i]]++;
            }
        }

        return true;
    }

    static boolean checkSmallSquare() {
        for (int i = 0; i < sudoku.length; i += 3) {
            for (int j = 0; j < sudoku[0].length; j += 3) {
                int[] count = new int[10];

                for (int k = i; k < i + 3 ; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (count[sudoku[k][l]] != 0) return false;
                        count[sudoku[k][l]]++;
                    }
                }

            }
        }
        return true;
    }
}
