import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.algs4.Graph;

public class HarmonyConflict {
    private boolean[] marked;
    private int[] id;
    private int count;
    private boolean[] color;
    private boolean isRight = true;

    public HarmonyConflict(Graph graph) {
        marked = new boolean[graph.V()];
        color = new boolean[graph.V()];
        id = new int[graph.V()];
        count = 0;
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s])
                dfs(graph, s);
            count++;
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        id[v] = count;

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();
            for (int neighbor : graph.adj(currentVertex)) {
                if (!marked[neighbor]) {
                    color[neighbor] = !color[currentVertex];
                    marked[neighbor] = true;
                    stack.push(neighbor);
                    id[neighbor] = count;
                } else if (color[neighbor] == color[currentVertex]) {
                    isRight = false;
                    return; // Stop the DFS once an inconsistency is found
                }
            }
        }
    }

    public void isHormony(int u, int v) {
        if (id[u] == id[v] && color[u] != color[v])
            isRight = false;
    }

    public boolean isRight() {
        return isRight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();
        List<int[]> harmonyEdges = new ArrayList<>();
        Graph graph = new Graph(vertices);
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            if (c == 1) {
                graph.addEdge(u, v);
            } else {
                harmonyEdges.add(new int[] { u, v });
            }
        }
        HarmonyConflict check = new HarmonyConflict(graph);

        for (int[] hEdge : harmonyEdges) {
            check.isHormony(hEdge[0], hEdge[1]);
        }

        if (check.isRight()) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        sc.close();
    }
}
