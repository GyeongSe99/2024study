// Queue 진기의 붕어빵
// 얘는 LinkedList 아님..

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Test1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 사람 수
            int M = Integer.parseInt(st.nextToken());   // K개의 붕어빵을 만드는데 드는 시간
            int K = Integer.parseInt(st.nextToken());   // 한번에 만들 수 있는 붕어빵의 개수

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int time = 0;
            int fish = 0;

            boolean isPossible = true;

            while (true) {
                if (queue.isEmpty()) {
                    break;
                }

                if (queue.peek() > time) {
                    time++;
                    if (time % M == 0) {
                        fish += K;
                    }
                    continue;
                }

                // 손님 줄 시간이 되었을때,
                // 붕어빵이 없으면
                if (fish == 0) {
                    isPossible = false;
                    break;
                } else {    // 있으면 하나 주기
                    queue.poll();
                    fish--;
                }

                time++;
                if (time % M == 0) {
                    fish += K;
                }
            }

            if (isPossible) {
                System.out.println("#" + test_case + " Possible");
            } else {
                System.out.println("#" + test_case + " Impossible");
            }

        }
    }
}
