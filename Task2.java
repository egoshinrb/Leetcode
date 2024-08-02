import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        scanner.nextLine();

        long[][] transposedMatrix = new long[columns][rows];

        for (int i = 0, k = rows - 1; i < rows; ++i, --k) {
            for (int j = 0, l = 0; j < columns; ++j, ++l) {
                transposedMatrix[l][k] = scanner.nextLong();
            }

            scanner.nextLine();
        }

        for (var i : transposedMatrix) {
            for (var j : i) {
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
