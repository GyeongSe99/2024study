package Test1;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(test_case);

            for (int i = 0; i < N; i++) {
                int cal = sc.nextInt();

                if (cal == 1) {
                    pq.add(sc.nextInt());
                } else {
                    Integer result = pq.poll();
                    if (result == null) {
                        sb.append(" -1");
                    } else {
                        sb.append(" ").append(result);
                    }
                }
            }

            System.out.println(sb);
        }
    }
}
