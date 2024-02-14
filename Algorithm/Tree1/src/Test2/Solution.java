package Test2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
    int num;
    String data;
    Node left;
    Node right;
}

public class Solution {
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            Node[] nodes = new Node[N + 1];
            for (int i = 1; i <= N; i++) {
                nodes[i] = new Node();
                nodes[i].num = i;
            }

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                nodes[num].data = st.nextToken();

                while (st.hasMoreTokens()) {
                    Node child = nodes[Integer.parseInt(st.nextToken())];
                    if (nodes[num].left == null) {
                        nodes[num].left = child;
                    } else {
                        nodes[num].right = child;
                    }
                }
            }

            sb = new StringBuilder();
            postorder(nodes[1]);

            Stack<Integer> st = new Stack<>();
            String[] list = sb.toString().split(" ");
            for (String data : list) {
                if (isOperator(data)) {
                    int num1 = st.pop();
                    int num2 = st.pop();
                    int result = calculate(data, num1, num2);
                    st.push(result);
                } else {
                    st.push(Integer.parseInt(data));
                }
            }

            System.out.println("#" + test_case + " " + st.pop());
        }
    }

    static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        sb.append(node.data).append(" ");
    }

    static boolean isOperator(String data) {
        return data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/");
    }

    static int calculate(String operator, int num1, int num2) {
        switch (operator) {
            case "+":
                return num2 + num1;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}