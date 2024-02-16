import java.util.Comparator;
import java.util.PriorityQueue;

public class Tree_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(12);
        pq.add(23);
        pq.add(32);
        pq.add(8);
        pq.add(73);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

        // 내림차순 정렬 방법1
        PriorityQueue<Integer> reversePQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1.equals(o2)) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        // 내림차순 정렬 방법2
        PriorityQueue<Integer> reversePQ2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b - a);

    }
}
