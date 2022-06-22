package practice.etc;

import java.util.ArrayList;
import java.util.List;

public class QuickSelect {
    public static void main(String[] args) {
        int[] arr = {-1, 9, -2, 0, 3, 5, -10}; //-10, -2, -1, 0, 3, 5, 9
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : arr)
            list.add(i);

        int k = 3; //3번째로 작은 수

        System.out.println(quickSelect(list, k));
    }

    private static int quickSelect(List<Integer> list, int k) {
        int p = list.get(0);
        int equalSize = 1;
        List<Integer> lessP = new ArrayList<>(list.size());
        List<Integer> greaterP = new ArrayList<>(list.size());

        for(int i=1; i<list.size(); i++) {
            if(list.get(i) < p) {
                lessP.add(list.get(i));
            } else if(list.get(i) > p) {
                greaterP.add(list.get(i));
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
}
