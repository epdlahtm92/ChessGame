public class Main {
    public static String[][] board = new String[8][8];
    public static final String[] PLAYER_B = {
            "P1","P2","P3","P4","P5","P6","P7","P8",
            "R1","N1","B1","Ki","Qn","B2","N2","R2"};
    public static final String[] PLAYER_W = {
            "p1","p2","p3","p4","p5","p6","p7","p8",
            "r1","n1","b1","ki","qn","b2","n2","r2"};

    public static void main(String[] args) {
        ChessBoard();
        BoardRefresh();
        InitialSetting();
        BoardRefresh();
    }
    public static void ChessBoard (){
        for (int row = 0; row < 8; row++) {
            if(row % 2 == 0){ // odd row
                for (int col = 0; col < 8; col++) {
                    if (col % 2 == 0){ // odd row - odd col
                        board[row][col] = "##";
                    } else { // odd row - even col
                        board[row][col] = "[]";
                    }
                }
            } else { // even row
                for (int col = 0; col < 8; col++) {
                    if (col % 2 == 0){ // even row - odd col
                        board[row][col] = "[]";
                    } else { // even row - even col
                        board[row][col] = "##";
                    }
                }
            }
        }
    }
    public static void InitialSetting (){
        for (int index = 0; index < 16; index++) {
            if (index < 8) {
                board[1][index] = PLAYER_B[index];
                board[6][index] = PLAYER_W[index];
            } else {
                board[0][index-8] = PLAYER_B[index];
                board[7][index-8] = PLAYER_W[index];
            }
        }
    }
    public static void BoardRefresh(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println("================");
        System.out.println();
    }
}
