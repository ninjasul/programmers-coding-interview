package hash;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class _02_전화번호_목록 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[] {"123", "456", "789"}));
        System.out.println(solution(new String[] {"123", "456", "5378", "53789", "789"}));
        System.out.println(solution(new String[] {"12", "123", "1235", "567", "88"}));
    }

    private static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
