package stack_queue;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class _01_주식가격 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{4, 3, 1, 3, 100, 2, 50, 30, 1, 8, 45})));
    }

    public static int[] solution(int[] prices) {
        Deque<Integer> stockPrices = new ArrayDeque<>(prices.length);

        for (int price : prices) {
            if (stockPrices.isEmpty()) {
                stockPrices.push(price);
                continue;
            }

            int top = stockPrices.peek().intValue();

            while (top < price) {

            }
        }
    }
}
