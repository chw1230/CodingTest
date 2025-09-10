import java.util.Arrays;
import java.util.TreeSet;

class Solution {
    public int[] solution(int[] numbers) {
       TreeSet<Integer> set = new TreeSet<>();
        for ( int i = 0 ; i < numbers.length-1 ; i++ ) {
            for ( int j = i + 1 ; j < numbers.length ; j++ ) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        // set.stream() => TreeSet<Integer>을 스트림으로 바꾸기
        // .mapToInt(Integer::intValue) => Stream<Integer>(스트림)을 IntStream으로 바꾸기 (Integer → int)
        // .toArray() => IntStream을 int[] 배열로 바꾸기
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}