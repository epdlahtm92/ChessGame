package ChessGame;

import java.util.Scanner;

public class Main {
    public static String[][] board = new String[8][8];
    public static final String[] PLAYER_B = {
            "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8",
            "R1", "N1", "B1", "Ki", "Qu", "B2", "N2", "R2"};
    public static final String[] PLAYER_W = {
            "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8",
            "r1", "n1", "b1", "ki", "qu", "b2", "n2", "r2"};

    public static final int[] MOVEMENT_X = {-1, 1, 0, 0, -1, -1, +1, 1}; // up, down, left, right, leftup, rightup, leftdown, rightdown
    public static final int[] MOVEMENT_Y = {0, 0, -1, 1, -1, +1, -1, 1};

    public static void main(String[] args) {
        ChessBoard();
        BoardRefresh();
        InitialSetting();
        BoardRefresh();
        String[] playerInput = InputDatas();
        MoveSet(playerInput[0],Integer.parseInt(playerInput[1]), Integer.parseInt(playerInput[2]),0,0);
        BoardRefresh();
    }

    public static void ChessBoard() {
        for (int row = 0; row < 8; row++) {
            if (row % 2 == 0) { // odd row
                for (int col = 0; col < 8; col++) {
                    if (col % 2 == 0) { // odd row - odd col
                        board[row][col] = "##";
                    } else { // odd row - even col
                        board[row][col] = "[]";
                    }
                }
            } else { // even row
                for (int col = 0; col < 8; col++) {
                    if (col % 2 == 0) { // even row - odd col
                        board[row][col] = "[]";
                    } else { // even row - even col
                        board[row][col] = "##";
                    }
                }
            }
        }
    }

    public static void InitialSetting() {
        for (int index = 0; index < 16; index++) {
            if (index < 8) {
                board[1][index] = PLAYER_B[index];
                board[6][index] = PLAYER_W[index];
            } else {
                board[0][index - 8] = PLAYER_B[index];
                board[7][index - 8] = PLAYER_W[index];
            }
        }
    }

    public static void BoardRefresh() {
        System.out.println("================");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("================");
        System.out.println();
    }

    public static void MoveSet(String name, int direction, int moveTime, int x, int y) {
        int nx = x, ny = y;
        if (name.contains("r") || name.contains("R") == true) { // rook moveset
            for (int index = 0; index < moveTime; index++) {
                if (direction >= 0 && direction < 4) {
                    nx = x + MOVEMENT_X[direction];
                    ny = y + MOVEMENT_Y[direction];
                } else {
                    nx = x;
                    ny = y;
                }
            }
        } else if (name.contains("n") || name.contains("N") == true) {

        } else if (name.contains("b") || name.contains("B") == true) {

        } else if (name.contains("k") || name.contains("K") == true) {

        } else if (name.contains("q") || name.contains("Q") == true) {

        } else if (name.contains("p") || name.contains("P") == true) {

        }
        String temp;
        temp = board[x][y];
        board[x][y] = board[nx][ny];
        board[nx][ny] = temp;
    }
    public static String[] InputDatas (){
        Scanner scanner = new Scanner(System.in);
        String piece = scanner.next();
        String direction = scanner.next();
        String moveTime = scanner.next();
        String res[] = {piece, direction, moveTime};
        return res;
    }
}
