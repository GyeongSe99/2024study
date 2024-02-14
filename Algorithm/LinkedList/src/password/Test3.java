package password;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    int data;
    Node next;
    Node prev;

    Node(){}

    Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;
    int size;

    DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        tail.prev = head;
        head.next = tail;
    }

    void addNodes(int idx, int n, StringTokenizer st) {
        if (idx > size) {
            System.out.println("잘못된 입력값");
            return;
        }

        Node cur = head;
        // 위치 찾기
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }

        Node nextTemp = cur.next;
        // 넣어주기
        for (int i = 0; i < n; i++) {
            Node newNode = new Node(Integer.parseInt(st.nextToken()));
            newNode.prev = cur;
            cur.next = newNode;
            cur = cur.next;
            size++;
        }
        cur.next = nextTemp;

        if (cur.next == null) {
            cur.next = tail;
        }
    }

    void deleteNodes(int idx, int cnt) {
        if (idx < 0 || idx >= size) {
            System.out.println("잘못된 입력값");
            return;
        }
        Node cur = head;

        // 위치 선정
        for (int i = 0; i < idx; i++) {
            cur = cur.next;
        }

        // cur의 다음 노드부터 삭제할 것임
        int n = 0;
        // 삭제할 노드의 다음 노드 찾기
        Node nextNode = cur.next;
        while (cnt > n && nextNode != tail) {
            nextNode = nextNode.next;
            n++;
        }

        cur.next = nextNode;
        size -= n;
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

public class Test3 {
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            DoublyLinkedList linkedList = new DoublyLinkedList();
            // 첫 암호문 상태
            linkedList.addNodes(0, N, st);

            int cal = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cal; i++) {
                char command = st.nextToken().charAt(0);
                if (command == 'I') {
                    linkedList.addNodes(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), st);
                } else if (command == 'D') {
                    linkedList.deleteNodes(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                } else {
                    linkedList.addNodes(linkedList.size - 1, Integer.parseInt(st.nextToken()), st);
                }
            }

            linkedList.printAnswer(test_case);
        }



    }
}
