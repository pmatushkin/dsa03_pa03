import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        //write your code here

        // initialize the top node
        Integer first = 0;

        // initialize the array of colors
        int[] colors = new int[adj.length];
        colors[first] = 1;

        // initialize the queue
        Queue<Integer> q = new LinkedList<>();
        q.add(first);

        boolean isBipartite = true;

        // begin traversing a graph
        while (!q.isEmpty()) {
            // get the first node in the queue
            first = q.remove();

            // get the nodes adjacent to the first node in the queue
            ArrayList<Integer> first_adj = adj[first];

            // get the color of the first node in the queue,..
            int color_first = colors[first];
            // change it to obtain the color for the adjacent nodes
            int color_adj = color_first * -1;

            // for every node adjacent to first...
            for (Integer v : first_adj) {
                // if it wasn't visited yet...
                if (colors[v] == 0) {
                    // queue it...
                    q.add(v);
                    // ... and color it
                    colors[v] = color_adj;
                } else if (colors[v] == color_first) {
                    // we can break early if the adjacent node
                    // was visited, and is marked the same color
                    // as the first node in the queue
                    isBipartite = false;
                    break;
                }
            }

            // breaking early
            if (!isBipartite) {
                break;
            }
        }

        return isBipartite ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}

