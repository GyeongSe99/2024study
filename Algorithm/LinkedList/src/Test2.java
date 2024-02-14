import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int data;
    Node next;

    Node(){}

    Node(int data) {
        this.data = data;
    }
}

class SinglyLinkedList{
    Node head;
    Node tail;
    int size;

    SinglyLinkedList() {
        this.head = new Node();
        this.tail = head;
    }

    void addNodes(int idx, int N, StringTokenizer st) {
        Node cur = head;
        // 들어갈 곳 위치 찾기
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }

        // 끊기면 안되니깐 다음에 올 노드를 저장
        Node nextTemp = cur.next;

        for (int i = 0; i < N; i++) {
            Node newNode = new Node(Integer.parseInt(st.nextToken()));
            cur.next = newNode;
            cur = cur.next;
            size++;
        }

        // 마지막에 연결시켜주기
        cur.next = nextTemp;
    }

    void printList() {
        Node cur = head.next;
        while (cur.next != null) {
            System.out.print(cur.data + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    void printAnswer(int testNum) {
        Node cur = head.next;
        System.out.print("#" + testNum);
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + cur.data);
            cur = cur.next;
        }
        System.out.println();
    }


}
public class Test2 {
    public static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            SinglyLinkedList linkedList = new SinglyLinkedList();
            linkedList.addNodes(0, N, st);

            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            // 연산의 횟수
            for (int i = 0; i < k; i++) {
                if (st.nextToken().equals("I")) {
                    int idx = Integer.parseInt(st.nextToken());
                    int n = Integer.parseInt(st.nextToken());
                    linkedList.addNodes(idx, n, st);
                }
            }

            linkedList.printAnswer(test_case);

        }
    }
}
