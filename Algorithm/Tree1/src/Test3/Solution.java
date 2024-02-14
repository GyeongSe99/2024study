package Test3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int num;
    Node parent;
    Node left;
    Node right;
}

public class Solution {
    static Node[] nodes;
    static List<Integer> AParents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            nodes = new Node[V + 1];
            for (int i = 1; i < nodes.length; i++) {
                nodes[i] = new Node();
                nodes[i].num = i;
            }

            st = new StringTokenizer(br.readLine());

            setNodes(E, st);

            AParents = new ArrayList<>();

            findParents(nodes[A]);

            int answer = findSameParent(nodes[B]);
            int size = findSize(nodes[answer]);
            System.out.println("#" + test_case + " " + answer + " " + size);
        }
    }

    static int findSize(Node node) {
        if (node == null) {
            return 0;
        }

        int left = findSize(node.left);
        int right = findSize(node.right);

        return left + right + 1;
    }

    static void setNodes(int E, StringTokenizer st) {
        for (int i = 0; i < E; i++) {
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            if (nodes[parent].left == null) {
                nodes[parent].left = nodes[child];
                nodes[child].parent = nodes[parent];
            } else {
                nodes[parent].right = nodes[child];
                nodes[child].parent = nodes[parent];
            }
        }
    }

    static void findParents(Node nodeA) {
        if (nodeA.num == 1) {
            return;
        }

        AParents.add(nodeA.parent.num);
        findParents(nodeA.parent);
    }

    static int findSameParent(Node nodeB) {
        if (nodeB.num == 1) {
            return -1;
        }

        if (AParents.contains(nodeB.parent.num)) {
            return nodeB.parent.num;
        }

        return findSameParent(nodeB.parent);
    }
}
