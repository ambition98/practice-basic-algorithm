package practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class UtilSort {
    // --- 정렬 기준 ---
    // Comparator와 Comparable의 compare 메서드를 이용하여 정수를 리턴할 때의 기준은
    // 기본적으로 오름차순 정렬이다
    // 즉, Comparator의 public int compare(T o1, T o2)
    // 에서 음수를 리턴한다면, o1이 우선순위가 높다. 따라서 앞쪽으로 간다.
    // Comparable의 public int compare(T o1)
    // 의 경우 음수를 리턴한다면 this 객체가 우선순위가 높다.

    // --- compare 작성 팁 ---
    // 단순 대소비교는 뺄셈을 이용하여 간단히 할 수 있다. (int비교, ASCII 비교)
    // return o1.ban - o2.ban 이라고 정의하면 o1의 반이 작을 때 음수가 되으로 반을 기준으로 오름차순 정렬된다.

    // --- 배열 정렬 ---
    // 배열은 Arrays.sort(myArray)로 사전순 정렬 가능하다.
    // 인자로 Comparator를 전달가능하다. Arrays.sort(myArray, new Comparator<T>() {...});
    // Collections은 내림차순 Comparator를 제공해준다. Arrays.sort(myArray, Collections.reverseOrder());

    // !!주의: Comparator를 전달가능한건 Primitive 타입이 아닐 경우만이다.
    // 따라서 기본타입으로 Collections.reverseOrder()를 사용하고 싶으면 Wrapper 클래스를 이용해야 한다.

    // --- List 정렬 ---
    // List는 myList.sort(new Comparator<T>() {...}) 로 정렬 가능하다.
    // 사전순 정렬은 Collections.sort(myList) 로 정렬 가능하다.

    // --- String.compareTo ---
    // String 객체는 사전순 정렬을 도와주는 comparaTo 메서드가 존재한다.
    // 두 객체를 비교하여 int를 리턴해주기 때문에 사용자 Comparator 를 정의할 때, 섞어서 사용가능하다.
    // 사전순 정렬은 소문자가 우선순위를 가진다. a가 A보다 우선순위가 높다.
    // 대소문자를 무시하려면 String.compareToIgnoreCase(String s)를 사용하면 된다. a와 A가 동일우선순위를 가지게 된다.

    public static void main(String[] args) {
        String[] strings = {"bcd", "cde", "bce", "Abc", "abdd"};

        //Array to List
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings));

        //List to Array
        String[] strings2 = list.toArray(new String[0]);

        System.out.println("a".compareTo("A")); // a가 우선
        System.out.println("a".compareToIgnoreCase("A")); // 우선순위 동일

        for(String s : strings)
            System.out.println(s);
    }
}
