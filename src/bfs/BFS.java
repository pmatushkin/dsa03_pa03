import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here

        // initialize the array of distances
        int[] dist = new int[adj.length];
        dist[s] = 1;

        // initialize the queue
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        boolean isDistanceFound = false;

        // begin traversing a graph
        while (!q.isEmpty()) {
            // get the first node in the queue
            Integer u = q.remove();

            // get the nodes adjacent to the first node in the queue
            ArrayList<Integer> u_adj = adj[u];

            // get the distance of the first node in the queue,
            // increase it by 1 to get the distance for the adjacent nodes
            int v_dist = dist[u] + 1;

            // for every node adjacent to u...
            for (Integer v : u_adj) {
                // if it wasn't visited yet...
                if (dist[v] == 0) {
                    // queue it...
                    q.add(v);
                    // ... and mark it as visited
                    dist[v] = v_dist;

                    // we can break early if the node is found
                    if (v == t) {
                        isDistanceFound = true;
                        break;
                    }
                }
            }

            // we can break early if the node is found
            if (isDistanceFound) {
                break;
            }
        }

        return dist[t] - 1;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

