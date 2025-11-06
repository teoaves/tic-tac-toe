import java.util.Scanner;

public class Game {
    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("=== ΠΑΙΧΝΙΔΙ ΤΡΙΛΙΖΑ ===");
        System.out.println("Παίκτης 1: X | Παίκτης 2: O");
        System.out.println();

        while (true) {
            printBoard();
            System.out.print("Παίκτης " + currentPlayer + ", διάλεξε θέση (1-9): ");
            int move = input.nextInt() - 1;

            if (move < 0 || move >= 9 || board[move] != ' ') {
                System.out.println("Μη έγκυρη κίνηση. Προσπάθησε ξανά.");
                continue;
            }

            board[move] = currentPlayer;

            if (checkWin()) {
                printBoard();
                System.out.println("🏆 Ο παίκτης " + currentPlayer + " κέρδισε!");
                break;
            }

            if (isFull()) {
                printBoard();
                System.out.println("Ισοπαλία!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        input.close();
    }

    static void printBoard() {
        System.out.println();
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    static boolean checkWin() {
        int[][] wins = {
                {0,1,2}, {3,4,5}, {6,7,8}, // rows
                {0,3,6}, {1,4,7}, {2,5,8}, // cols
                {0,4,8}, {2,4,6}           // diagonals
        };
        for (int[] w : wins) {
            if (board[w[0]] == currentPlayer &&
                    board[w[1]] == currentPlayer &&
                    board[w[2]] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    static boolean isFull() {
        for (char c : board)
            if (c == ' ') return false;
        return true;
    }
}