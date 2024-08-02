import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        char[][] forest = new char[count][3];
        for (int i = 0; i < count; ++i) {
            forest[i] = scanner.nextLine().toCharArray();
        }

        Point[] way = new Point[count];
        int rootLevel = 0;
        int result = 0;

        for (int i = 0; i < count && i >= 0; ) {
            if (forest[i][0] != 'W' && (way[i] == null || way[i].y < 0) && (!(i - 1 > 0) || way[i - 1].y != 2)) {
                way[i] = new Point(i, 0, forest[i][0] == 'C' ? 1 : 0);
                rootLevel = i - 1;
                ++i;
                if (i < count && way[i] != null) way[i] = null;
            } else if (forest[i][1] != 'W' && (way[i] == null || way[i].y < 1)) {
                way[i] = new Point(i, 1, forest[i][1] == 'C' ? 1 : 0);
                rootLevel = i - 1;
                ++i;
                if (i < count && way[i] != null) way[i] = null;
            } else if (forest[i][2] != 'W' && (way[i] == null || way[i].y < 2) && (!(i - 1 > 0) || way[i - 1].y != 0)) {
                way[i] = new Point(i, 2, forest[i][2] == 'C' ? 1 : 0);
                rootLevel = i - 1;
                ++i;
                if (i < count && way[i] != null) way[i] = null;
            } else {
                if (i == rootLevel + 1) {
                    rootLevel -= 1;
                } else {
                    result = Math.max(result, getSumWay(way, rootLevel + 1));
                }

                i = rootLevel + 1;
            }

            if (i == count) {
                i = rootLevel + 1;
                result = Math.max(result, getSumWay(way, rootLevel + 1));
            }
        }

        System.out.println(result);
    }

    static int getSumWay(Point[] way, int end) {
        int res = 0;
        for (int i = 0; i <= end; ++i) {
            res += way[i].weigh;
        }

        return res;
    }

    static class Point {
        int x;
        int y;
        int weigh;

        public Point() {
        }

        public Point(int x, int y, int weigh) {
            this.x = x;
            this.y = y;
            this.weigh = weigh;
        }
    }
}