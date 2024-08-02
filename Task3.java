import java.util.Scanner;
import java.util.TreeSet;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        TreeSet<String> directories = new TreeSet<>();
        for (int i = 0; i < count; ++i) {
            directories.add(scanner.nextLine());
        }

        directories.forEach(str -> {
            int level = 0;
            int lastindex = 0;
            for (int i = 0; i < str.length() && i != -1;) {
                if ((i = str.indexOf("/", lastindex)) != -1) {
                    ++level;
                    lastindex = ++i;
                }
            }

            while (level-- > 0) {
                System.out.print("  ");
            }

            System.out.println(str.substring(lastindex));
        });
    }
}