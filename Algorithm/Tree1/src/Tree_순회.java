public class Tree_순회 {

    // 트리 배열로 표현
    static char[] tree = new char[]{'\0', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 0, 0, 'H', 'I'};

    public static void main(String[] args) {

    }

    // 전위 순회
    // VLR
    static void preorder(int i) {
        if (tree.length <= i || tree[i] == 0) {
            return;
        }
        // 부모노드 방문 (출력)
        System.out.print(tree[i] + " ");
        // 왼쪽 자식
        preorder(i * 2);
        // 오른쪽 자식
        preorder(i * 2 + 1);
    }

    // 중위 순회
    // LVR
    static void inorder(int i) {
        if (tree.length <= i || tree[i] == 0) {
            return;
        }

        inorder(i * 2);
        System.out.print(tree[i] + " ");
        inorder(i * 2 + 1);
    }

    // 후위 순회
    // LRV
    static void postorder(int i) {
        if (tree.length <= i || tree[i] == 0) {
            return;
        }

        postorder(i * 2);
        postorder(i * 2 + 1);
        System.out.print(tree[i] + " ");
    }
}
