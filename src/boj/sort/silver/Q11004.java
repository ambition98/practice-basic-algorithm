package boj.sort.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q11004 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        System.out.println(quickSelect(list, k));
    }

    // k 번째 작은 수를 리턴
    private static int quickSelect(List<Integer> list, int k) {
        int p;
        if(list.size() < 5) {
            p = list.get(0);
        } else {
            p = medianOfMedians(list);
        }

        int equalSize = 0;
        List<Integer> lessP = new ArrayList<>(list.size());
        List<Integer> greaterP = new ArrayList<>(list.size());

        for (Integer i : list) {
            if (i < p) {
                lessP.add(i);
            } else if (i > p) {
                greaterP.add(i);
            } else {
                equalSize++;
            }
        }

        if(lessP.size() >= k) {
            return quickSelect(lessP, k);
        } else if(lessP.size() + equalSize < k) {
            return quickSelect(greaterP, k - lessP.size() - equalSize);
        } else {
            return p;
        }
    }

    private static int medianOfMedians(List<Integer> list) {
        int[] medians;
        if(list.size() % 5 == 0)
            medians = new int[list.size() / 5];
        else
            medians = new int[list.size() / 5 + 1];

        for(int i=0 ;i<medians.length; i++) {
            int[] temp;
            if(list.size() - 5 * i < 5 )
                temp = new int[list.size() - 5 * i];
            else
                temp = new int[5];

            for(int j=0; j<temp.length; j++) {
                temp[j] = list.get(5 * i + j);
            }

            medians[i] = selectMedian(temp);
        }

        Arrays.sort(medians);

        return medians[medians.length / 2];
    }

    private static int selectMedian(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }
}