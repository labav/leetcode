package leetcode.e4_median_of_two_sorted_arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Определение. Медианой ряда чисел называется число, стоящее посередине упорядоченного по возрастанию ряда чисел
 * (в случае, если количество чисел нечётное). Если же количество чисел в ряду чётно, то медианой ряда является
 * полусумма двух стоящих посередине чисел упорядоченного по возрастанию ряда.
 */

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 3};
        int[] nums2 = new int[] {2, 4, 5};
//        int[] nums1 = new int[] {1};
//        int[] nums2 = new int[] {2};

        System.out.println("result = " + findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        /** два случая: четный/нечетный
         по сути все можно свети к одному массиву и просто взять средний элемент
         если нечетный размер конечного массива, либо два средних элемента и взять среднее от них
         */
        int resultArraySize = nums1.length + nums2.length;
        int[] resultArray = new int[resultArraySize];
        // индексы массивов
        int i = 0, j = 0, k = 0;

        while ( i < nums1.length || j < nums2.length) {
            System.out.println("i = " + i + " | j = " + j + " | k = " + k);
            //TODO: optimize it, and use math lol
            if (i == nums1.length) {
                resultArray[k] = nums2[j];
                k++;
                j++;
            } else if (j == nums2.length) {
                resultArray[k] = nums1[i];
                k++;
                i++;
            } else {
                if (nums1[i] == nums2[j]) {
                    resultArray[k] = nums1[i];
                    k++;
                    i++;
                    resultArray[k] = nums2[j];
                    k++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    resultArray[k] = nums1[i];
                    k++;
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    resultArray[k] = nums2[j];
                    k++;
                    j++;
                }
            }
        }

        boolean isEven = resultArraySize % 2 == 0;
        // проверка на четность
        if (isEven) {
            int medianRight = resultArraySize/2;
            int medianLeft = medianRight - 1;
            result = (resultArray[medianLeft] + resultArray[medianRight]) / 2.0;
        } else {
            result = resultArray[resultArraySize/2];
        }

        return result;
    }
}
