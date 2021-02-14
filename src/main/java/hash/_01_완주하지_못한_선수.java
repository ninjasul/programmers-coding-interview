package hash;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */
public class _01_완주하지_못한_선수 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        System.out.println(solution(new String[] {"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[] {"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
    }

    private static String solution(String [] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();

        for (String curParticipant : participant) {
            participantMap.merge(curParticipant, 1, Integer::sum);
        }

        for (String curCompletion : completion) {
            participantMap.computeIfPresent(curCompletion, (k, v) -> v - 1);

            if (participantMap.containsKey(curCompletion) && participantMap.get(curCompletion) <= 0) {
                participantMap.remove(curCompletion);
            }

            if (participantMap.size() <= 1) {
                break;
            }
        }

        return participantMap.keySet().stream().findFirst().orElse("");
    }

}
