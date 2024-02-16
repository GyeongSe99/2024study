package Test2;

// 백만 장자 프로젝트

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static PriorityQueue<Long> pq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            pq = new PriorityQueue<>(Comparator.reverseOrder());
            int N = sc.nextInt();

            long[] arr = new long[N];

            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            long result = 0;

            for (int i = arr.length - 1; i >= 0; i--) {
                if (pq.isEmpty()) {
                    pq.add(arr[i]);
                    continue;
                }

                long now = arr[i];
                if (pq.peek() <= now) {
                    result += calculate();
                    pq.add(now);
                } else {
                    pq.add(now);
                }
            }

            if (!pq.isEmpty()) {
                result += calculate();
            }

            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static long calculate() {
        long price = pq.poll();
        long sum = 0;
        long cnt = 0;
        while (!pq.isEmpty()) {
            sum -= pq.poll();
            cnt++;
        }
         return sum + (cnt * price);
    }
}
