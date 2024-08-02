import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();
        String[] temp = scanner.nextLine().split(" ");

        List<Integer> balls = Arrays.stream(temp).map(Integer::parseInt).toList();
        long result = -1;
        
        if (count < 7) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < count - 6; ++i) {
                List<Integer> curr = balls.stream().skip(i).limit(7).toList();
                if (curr.stream().allMatch(x -> x > 3)) {
                    long currResult = curr.stream().filter(x -> x == 5).count();
                    if (currResult > result) {
                        result = currResult;
                    }
                }
            }

            System.out.println(result);
        }
    }
}
