import java.util.*;

public class FindKthSmallestPairDistance719 {
    public static void main(String[] args) {
        FindKthSmallestPairDistance719 findKthSmallestPairDistance719 = new FindKthSmallestPairDistance719();
//        System.out.println(findKthSmallestPairDistance719.smallestDistancePair(new int[]{1, 4, 5, 4, 5, 6, 5, 6, 6, 4, 3, 1}, 66));
        System.out.println(findKthSmallestPairDistance719.smallestDistancePair(new int[]{62, 100, 4}, 3));
    }

//    public int smallestDistancePair(int[] nums, int k) {
//        List<Integer> distances = new ArrayList<>();
//        Integer currDistance;
//        for (int i = 0; i < nums.length - 1; ++i) {
//            for (int j = i + 1; j < nums.length; ++j) {
//                currDistance = Math.abs(nums[j] - nums[i]);
//                distances.add(currDistance);
//            }
//        }
//
//        Collections.sort(distances);
//
//        return distances.get(k - 1);
//    }

    public int smallestDistancePair(int[] nums, int k) {
        System.out.println("Size of array = " + nums.length);
        Map<Integer, Integer> numsMap = Arrays.stream(nums).collect(TreeMap::new, (m, i) -> m.put(i, (Integer) m.get(i) != null ? (Integer) m.get(i) + 1 : 1), Map::putAll);
//        System.out.println(numsMap);

        List<Integer> numsKeysList = numsMap.keySet().stream().toList();
        List<Integer> numsValuesList = numsMap.values().stream().toList();
        int countAllRangesBetweenEqualsPoint = numsValuesList.stream().filter(x -> x >= 2).map(x -> x * (x - 1) / 2).mapToInt(Integer::intValue).sum();

        if (countAllRangesBetweenEqualsPoint >= k) {
            return 0;
        }

        Map<Integer, Integer> rangeLengthsCountMap = new TreeMap<>();
        rangeLengthsCountMap.put(0, countAllRangesBetweenEqualsPoint);
        int countI, countJ, rangeLength;
        int rangeLengthMax = numsKeysList.get(numsKeysList.size() - 1) - numsKeysList.get(0);
        int rangeCountMax = nums.length * (nums.length - 1) / 2;
        boolean findResult = false;
        int result = 0;

        for (int i = 0; i < numsKeysList.size() - 1 && !findResult; ++i) {
            countI = numsMap.get(numsKeysList.get(i));

//             оптимизация, если к - ближе к концу
            for (int j = numsKeysList.size() - 1; j > i && !findResult; --j) {
                countJ = numsMap.get(numsKeysList.get(j));
                rangeLength = Math.abs(numsKeysList.get(j) - numsKeysList.get(i));
                rangeLengthsCountMap.put(rangeLength, rangeLengthsCountMap.containsKey(rangeLength) ?
                        rangeLengthsCountMap.get(rangeLength) + countI * countJ :
                        countI * countJ);

                if (j == numsKeysList.size() - 1) {
                    while (rangeLengthMax >= rangeLength && !findResult) {
//                        System.out.println("rangeCountMax = " + rangeCountMax);
//                        System.out.println("rangeLengthMax = " + rangeLengthMax);
//                        System.out.println("Count LengthMax = " + rangeLengthsCountMap.get(rangeLengthMax));

                        rangeCountMax -= rangeLengthsCountMap.getOrDefault(rangeLengthMax, 0);

                        if (k > rangeCountMax) {
                            findResult = true;
                            result = rangeLengthMax;
                        }

                        --rangeLengthMax;
                    }
                }
            }

//            for (int j = i + 1; j < numsKeysList.size(); ++j) {
//                countJ = numsMap.get(numsKeysList.get(j));
//                rangeLength = Math.abs(numsKeysList.get(j) - numsKeysList.get(i));
//                rangeLengthsCountMap.put(rangeLength, rangeLengthsCountMap.containsKey(rangeLength) ?
//                        rangeLengthsCountMap.get(rangeLength) + countI * countJ :
//                        countI * countJ);
//            }
        }

//        for (int i : rangeLengthsCountMap.keySet()) {
//            int currCount = rangeLengthsCountMap.get(i);
//            if (k > currCount) {
//                k -= currCount;
//            } else {
//                result = i;
//                break;
//            }
//        }

        return result;
    }

}
