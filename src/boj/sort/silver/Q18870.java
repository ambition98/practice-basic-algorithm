package boj.sort.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] arr2 = new int[n];
        List<Integer> distinctList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arr2[i] = arr[i];
//            distinctList.add(arr[i]);
        }

//        distinctList = distinctList.stream().distinct().collect(Collectors.toList());
//        distinctList.sort(Integer::compareTo);
        Arrays.sort(arr);
        distinctList.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                distinctList.add(arr[i]);
            }
        }

        int[] arr3 = new int[distinctList.size()];
        for(int i=0; i<distinctList.size(); i++) {
            arr3[i] = distinctList.get(i);
        }

        for(int i : arr2) {
            sb.append(binarySearch(arr3, i)).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] < target) {
                left = ++mid;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
