import java.util.*;

public class Task6 {
    private static char[][] board;
    private static int boardSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boardSize = scanner.nextInt();
        scanner.nextLine();

        board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; ++i) {
            board[i] = scanner.nextLine().toCharArray();
        }

        int result = -1;

        if (boardSize > 2) {
            Stack<Point> way = new Stack<>();
            Point start = getStartPoint(board);
            way.add(start);
            Point next;
            while (true) {
                next = getNextPoint(way.peek());
            }
        }

        System.out.println(result);
    }

    static class Point {
        int x; // координата по оси x
        int y; // координата по оси y
        int kind; // вид движения: конь 0 или король 1
        int direction; // направление следующего хода - от 1 до 8
        int reverseDir; // направление первоначального предыдущего хода - от 1 до 8
        int moveCount; // количество ходов

        public Point() {
        }

        private Point(int x, int y, int kind, int direction, int reverseDir, int moveCount) {
            this.x = x;
            this.y = y;
            this.kind = kind;
            this.reverseDir = reverseDir;
            this.direction = direction;
            this.moveCount = moveCount;
        }
    }

    private static Point getStartPoint(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++i) {
                if (board[i][j] == 'S') {
                    return new Point(i + 1, j + 1, 0, 0, 0, 0);
                }
            }
        }

        return new Point(0, 0, 0, 0, 0, 0);
    }

    private static Point getNextPoint(Point curr) {
        Point result = null;
        if (curr != null && curr.direction < 8) {
            switch (curr.direction) {
                case 0 -> {
                    if (curr.kind == 0) {
                        if (curr.x + 2 <= boardSize && curr.y + 1 <= boardSize) {
                            curr.direction = 1;
                            result = new Point(curr.x + 2, curr.y + 1, 0, 0, 0, 0);
                            result.kind = board[curr.x + 1][curr.y] == 'G' ? 1 : 0;
                            result.reverseDir = curr.kind == result.kind ? (curr.direction + 3) % 8 + 1 : 0;
                            result.moveCount = curr.moveCount + 1;
                        }
                    } else {
                        if (curr.x + 1 <= boardSize && curr.y + 1 <= boardSize) {
                            curr.direction = 1;
                            result = new Point(curr.x + 1, curr.y + 1, 0, 0, 0, 0);
                            result.kind = board[curr.x][curr.y] == 'G' ? 1 : 0;
                            result.reverseDir = curr.kind == result.kind ? (curr.direction + 3) % 8 + 1 : 0;
                            result.moveCount = curr.moveCount + 1;
                        }
                    }
                }
                case 1 -> {
                    if (curr.kind == 0) {
                        if (curr.x + 1 <= boardSize && curr.y + 2 <= boardSize) {
                            curr.direction = 2;
                            result = new Point(curr.x + 1, curr.y + 2, 0, 0, 0, 0);
                            result.kind = board[curr.x][curr.y + 1] == 'G' ? 1 : 0;
                            result.reverseDir = curr.kind == result.kind ? (curr.direction + 3) % 8 + 1 : 0;
                            result.moveCount = curr.moveCount + 1;
                        }
                    } else {
                        if (curr.y + 1 <= boardSize) {
                            curr.direction = 2;
                            result = new Point(curr.x, curr.y + 1, 0, 0, 0, 0);
                            result.kind = board[curr.x - 1][curr.y] == 'G' ? 1 : 0;
                            result.reverseDir = curr.kind == result.kind ? (curr.direction + 3) % 8 + 1 : 0;
                            result.moveCount = curr.moveCount + 1;
                        }
                    }
                }
            }
        }

        return result;
    }
}