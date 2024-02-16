import java.util.Arrays;

public class Tree_Heap {    // 최대 힙 구현
    static int[] heap = new int[100];
    static int heapSize;

    public static void main(String[] args) {
        heapPush(55);
        heapPush(56);
        heapPush(54);
        heapPush(32);
        heapPush(1);
        heapPush(11);

        System.out.println(Arrays.toString(heap));


    }

    // 삽입
    static void heapPush(int data) {
        // 마지막 위치에 노드 추가
        heap[++heapSize] = data;

        // 부모와 비교하면서 swap
        int ch = heapSize;
        int p = ch / 2;

        while (p > 0 && heap[p] < heap[ch]) {
            // swap
            swap(p, ch);

            // 인덱스 변경
            ch = p;
            p = ch / 2;
        }
    }

    // 삭제
    static int heapPop() {
        // 루트에 있는 원소 제거
        int popItem = heap[1];
        // 마지막에 있는 원소 루트로 옮기기
        heap[1] = heap[heapSize--];

        int p = 1;
        int ch = p * 2;

        // 리프노드로 가면 자식이 없을 수도 있으니까
        // ch가 heapSize 이하인지 확인
        while (heap[p] < heap[ch]) {
            // 최대힙 구현이므로 왼쪽과 오른쪽 중에서 더 큰 자식 인덱스 찾기
            if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
                ch++;
            }

            // 자식이 더 크면 swap
            swap(p, ch);

            // 인덱스 갱신
            p = ch;
            ch = p * 2;
        }

        return popItem;
    }

    static void swap(int p, int ch) {
        int tmp = heap[p];
        heap[p] = heap[ch];
        heap[ch] = tmp;
    }
}
