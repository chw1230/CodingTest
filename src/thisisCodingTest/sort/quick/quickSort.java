package thisisCodingTest.sort.quick;

import java.util.Arrays;

public class quickSort {


    public static int[] array = {5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void quickSort(int begin, int end) {
        if (begin >= end) {
            return;
        }

        int pivot = array[begin]; // 호어 분할 법을 사용해서 리스트에서 첫 번째 데이터를 피벗( 교환하기 위한 기준 )으로 정하기
        int left = begin + 1; // 피벗을 제외한 가장 좌측 인덱스 구하기
        int right = end; // 가장 우측 인덱스 구하기

        while (left <= right) { // 우측의 값이 좌측의 값보다 큰 동안 진행
            while (left <= right && array[left] <= pivot) {  // 우측의 값이 좌측의 값보다 크고, 피벗의 값이 좌측 인덱스의 데이터 보다 큰 동안 진행
                ++left; // 좌측 인덱스 값을 키워줌 ( 점점 우측으로 이동하는 과정임 )
            }

            while (right > begin && array[right] >= pivot) { // 우측 값이 시작 값 보다 크고, 우측 인덱스의 데이터 보다 피벗이 작거나 같은 동안 진행
                --right; // 우측 인덱스 값을 줄여줌 ( 점점 좌측으로 이동하는 과정임 )
            }

            if (left > right) { // 만약 좌측인덱스 값이 우측 인덱스 값 보다 크면 -> 엇갈린 경우
                // 작은 데이터(array[right])와 피벗의 swap
                int temp = array[right];
                array[right] = array[begin];
                array[begin] = temp;
            } else {
                // 작은 데이터(array[right])와 큰 데이터(array[left])의 swap
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }

        // 재정의 된 피벗과 함께 재귀함수로 배열 정렬하기!!
        quickSort(begin, right - 1);
        quickSort(right + 1, end);
    }

    public static void main(String[] args) {
        quickSort(0, array.length - 1);

        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
