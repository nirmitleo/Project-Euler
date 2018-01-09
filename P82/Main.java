package ProjectEuler.P82;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Nirmit on 10/08/2017.
 */
public class Main
{
    private int N = 80;
    private int[][] map;
    private long[][] dp;
    private ArrayList<Edge>[] g;
    private final static long INF = Long.MAX_VALUE;

    public class Vertex implements Comparable<Vertex>
    {
        int V;
        long dist;

        public Vertex(int V, long dist)
        {
            this.V = V;
            this.dist = dist;
        }

        public int compareTo(Vertex that)
        {
            int distDiff = Long.compare(this.dist, that.dist);
            return distDiff != 0 ? distDiff : Integer.compare(this.V, that.V);
        }
    }


    public class Edge
    {
        int from;
        int to;
        int value;

        public Edge(int from, int to, int value)
        {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    public ArrayList<Edge>[] createGraph(int V)
    {
        ArrayList<Edge> g[] = new ArrayList[V];
        for (int i = 0; i < V; i++)
        {
            g[i] = new ArrayList<Edge>();
        }
        return g;
    }

    public void addEdge(int from, int to, int value)
    {
        Edge e = new Edge(from, to, value);
        g[from].add(e);
    }


    public static void main(String[] args)
    {
        Main demo = new Main();
//        demo.test();
        demo.dijkstra();
    }

    public void dijkstra()
    {
        try (Scanner in = new Scanner(new File("./ProjectEuler/P82/sample")))
        {
            map = new int[N][N];
            for (int i = 0; i < N; i++)
            {
                String[] tokens = in.next().split(",");
                for (int j = 0; j < N; j++)
                {
                    map[i][j] = Integer.parseInt(tokens[j]);
                }
            }
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            int V = N * N;
            g = createGraph(V);
            int now = 0;
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++, now++)
                {
                    int from = now;
                    if (j + 1 < N)
                    {
                        addEdge(from, from + 1, map[i][j + 1]);
                    }
                    if (i + 1 < N)
                    {
                        addEdge(from, from + N, map[i + 1][j]);
                    }
                    if (i - 1 >= 0)
                    {
                        addEdge(from, from - N, map[i - 1][j]);
                    }
                }
            }


            long min = Long.MAX_VALUE;
            long[] dist = new long[V];
            boolean[] was = new boolean[V];
            for (int i = 0; i < V; i += N)
            {
                Arrays.fill(dist, INF);
                Arrays.fill(was, false);
                PriorityQueue<Vertex> queue = new PriorityQueue<>();

                dist[i] = map[i / N][0];
                queue.add(new Vertex(i, dist[i]));
                while (!queue.isEmpty())
                {
                    Vertex U = queue.poll();
                    int u = U.V;
                    if (!was[u])
                    {
                        was[u] = true;
                        for (Edge e : g[u])
                        {
                            int v = e.to;
                            if (dist[u] + e.value < dist[v])
                            {
                                dist[v] = dist[u] + e.value;
                                queue.add(new Vertex(v, dist[v]));
                            }
                        }
                    }
                }
                for (int j = N - 1; j < V; j += N)
                {
//                    System.out.println(getDist[j]);
                    min = Math.min(min, dist[j]);
                }
            }
            System.out.println(min);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void solve()
    {
        map = new int[N][N];
        dp = new long[N][N];
        long min = Long.MAX_VALUE;
        try (Scanner in = new Scanner(new File("./ProjectEuler/P82/sample")))
        {
            for (int i = 0; in.hasNext(); i++)
            {
                String[] tokens = in.next().split(",");
                for (int j = 0; j < tokens.length; j++)
                {
                    map[i][j] = Integer.parseInt(tokens[j]);
                }
            }
//            for (int i = 0; i < N; i++)
//            {
//                for (int j = 0; j < N; j++)
//                {
//                    System.out.print(internalMap[i][j] + " ");
//                }
//                System.out.println();
//            }
            resetDP();
            for (int i = 0; i < N; i++)
            {
//                resetDP();
                go(i, 0, map[i][0]);
                for (int j = 0; j < N; j++)
                {
                    min = Math.min(min, dp[j][N - 1]);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(min);
    }

    public void resetDP()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public boolean isValid(int x)
    {
        return x >= 0 && x < N;
    }

    public void go(int x, int y, long value)
    {
//        System.out.println("go(" + x + ", " + y + ", " + value + ")");
        dp[x][y] = value;
        if (y == N - 1)
        {
            return;
        }
        if (isValid(x + 1) && isValid(y) && dp[x + 1][y] > dp[x][y] + map[x + 1][y])
        {
            go(x + 1, y, dp[x][y] + map[x + 1][y]);
        }
        if (isValid(x - 1) && isValid(y) && dp[x - 1][y] > dp[x][y] + map[x - 1][y])
        {
            go(x - 1, y, dp[x][y] + map[x - 1][y]);
        }
        if (isValid(x) && isValid(y + 1) && dp[x][y + 1] > dp[x][y] + map[x][y + 1])
        {
            go(x, y + 1, dp[x][y] + map[x][y + 1]);
        }
    }
}
