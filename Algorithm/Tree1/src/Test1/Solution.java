package Test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    int num;
    char data;
    Node left;
    Node right;
}

public class Solution {
    static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            // 노드들을 담을 틀 셋팅
            nodes = new Node[N + 1];
            for (int i = 1; i < nodes.length; i++) {
                nodes[i] = new Node();
                nodes[i].num = i;
            }

            // 간선 연결 해주기
            for (int i = 1; i < N + 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                nodes[num].data = st.nextToken().charAt(0);
                while (st.hasMoreTokens()) {
                    if (nodes[num].left == null) {
                        nodes[num].left = nodes[Integer.parseInt(st.nextToken())];
                    } else {
                        nodes[num].right = nodes[Integer.parseInt(st.nextToken())];
                    }
                }
            }

            System.out.print("#" + test_case + " ");
            inorder(nodes[1]);
            System.out.println();

        }
    }

    // LVR
    static void inorder(Node node) {
        if (node == null) {
            return;

        }

        inorder(node.left);
        System.out.print(node.data);
        inorder(node.right);
    }
}
