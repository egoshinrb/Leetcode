import com.sun.source.doctree.SeeTree;

import java.util.*;
import java.util.stream.Collectors;

public class FindKthSmallestPairDistance719 {
    public static void main(String[] args) {
        FindKthSmallestPairDistance719 findKthSmallestPairDistance719 = new FindKthSmallestPairDistance719();
        findKthSmallestPairDistance719.smallestDistancePair(new int[] {1, 4, 5, 4, 5, 6, 5, 6, 6, 4, 3, 1}, 1);

    }

    public int smallestDistancePair(int[] nums, int k) {
        Map<Integer, Integer> numsMap = Arrays.stream(nums).collect(HashMap::new, (m, i) -> m.put(i, (Integer)m.get(i) != null ? (Integer)m.get(i) + 1 : 1), Map::putAll);
        System.out.println(numsMap);

        Set<Integer> numsSetKeys = numsMap.keySet();
        List<Integer> numsListValues = numsMap.values().stream().toList();
        int countAllRangesBetweenEqualsPoint = numsListValues.stream().filter(x -> x >= 2).map(x -> x * (x - 1) / 2).mapToInt(Integer::intValue).sum();

        if (countAllRangesBetweenEqualsPoint >= k) {
            return 0;
        }



        return k;
    }

}
