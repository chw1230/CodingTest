package thisisCodingTest.sort.insertion;

import java.util.Arrays;

public class insertionSort {

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 1; i < array.length; i++) { // 2번째 인덱스인 1부터 시작
            for (int j = i; j > 0; j--) { // 앞에서 선택한 인덱스의 좌측으로 하나씩 이동하는 이미지 생각!!!
                if(array[j-1] <= array[j]){
                    break;
                }
                // tmp를 통한 swap
                int tmp = array[j-1];
                array[j-1] = array[j];
                array[j] = tmp;
            }

        }
        System.out.println(Arrays.toString(array));
    }

}
