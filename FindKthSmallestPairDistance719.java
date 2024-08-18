import java.util.*;

public class FindKthSmallestPairDistance719 {
    public static void main(String[] args) {
        FindKthSmallestPairDistance719 findKthSmallestPairDistance719 = new FindKthSmallestPairDistance719();
        System.out.println(findKthSmallestPairDistance719.smallestDistancePair(new int[]{1, 4, 5, 4, 5, 6, 5, 6, 6, 4, 3, 1}, 15));


    }

    public int smallestDistancePair(int[] nums, int k) {
        Map<Integer, Integer> numsMap = Arrays.stream(nums).collect(HashMap::new, (m, i) -> m.put(i, (Integer) m.get(i) != null ? (Integer) m.get(i) + 1 : 1), Map::putAll);

        List<Integer> numsKeysList = numsMap.keySet().stream().toList();
        List<Integer> numsValuesList = numsMap.values().stream().toList();
        int countAllRangesBetweenEqualsPoint = numsValuesList.stream().filter(x -> x >= 2).map(x -> x * (x - 1) / 2).mapToInt(Integer::intValue).sum();

        if (countAllRangesBetweenEqualsPoint >= k) {
            return 0;
        }

        Map<Integer, Integer> rangeLengthCountsMap = new TreeMap<>();
        rangeLengthCountsMap.put(0, countAllRangesBetweenEqualsPoint);
        int countI, countJ, rangeLength;

        for (int i = 0; i < numsKeysList.size() - 1; ++i) {
            countI = numsMap.get(numsKeysList.get(i));
            for (int j = i + 1; j < numsKeysList.size(); ++j) {
                countJ = numsMap.get(numsKeysList.get(j));
                rangeLength = Math.abs(numsKeysList.get(j) - numsKeysList.get(i));
                rangeLengthCountsMap.put(rangeLength, rangeLengthCountsMap.containsKey(rangeLength) ?
                        rangeLengthCountsMap.get(rangeLength) + countI * countJ :
                        countI * countJ);
            }
        }

        int result = 0;
        for (int i : rangeLengthCountsMap.keySet()) {
            int currCount = rangeLengthCountsMap.get(i);
            if (k > currCount) {
                k -= currCount;
            } else {
                result = i;
                break;
            }
        }

        return result;
    }

}
