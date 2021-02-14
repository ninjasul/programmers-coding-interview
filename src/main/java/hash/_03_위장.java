package hash;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */
public class _03_위장 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }

    public static int solution(String[][] clothes) {
        return Arrays.stream(clothes)
            .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
            .values()
            .stream()
            // (y+1은 각 의상마다 안 입는 케이스를 계산하여 +1 해 줌.)
            .reduce(1L, (x, y) -> x * (y + 1))
            // 모든 경우의 수에서 모든 의상을 입지 않는 케이스 1을 빼줌.
            .intValue() - 1;
    }
}
