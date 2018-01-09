package ProjectEuler.P83;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Nirmit on 10/08/2017.
 */
public class Main
{
    class Vertex implements Comparable<Vertex>
    {
        int x;
        int y;
        long dist;

        public Vertex(int x, int y, long dist)
        {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public int compareTo(Vertex that)
        {
            int distDiff = Long.compare(this.dist, that.dist);
            if (distDiff == 0)
            {
                int xDiff = Integer.compare(this.x, that.x);
                return xDiff != 0 ? xDiff : Integer.compare(this.y, that.y);
            }
            return distDiff;
        }
    }

    public static void main(String[] a)
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve()
    {
        int N = 80;
        try (Scanner in = new Scanner(new File("./ProjectEuler/P83/sample")))
        {
            long[][] map = new long[N][N];
            for (int i = 0; i < N; i++)
            {
                String[] tokens = in.next().split(",");
                for (int j = 0; j < N; j++)
                {
                    map[i][j] = Integer.parseInt(tokens[j]);
                }
            }

            long INF = Long.MAX_VALUE;
            long[][] dist = new long[N][N];
            PriorityQueue<Vertex> q = new PriorityQueue<>();
            for (int i = 0; i < N; i++)
            {
                Arrays.fill(dist[i], INF);
            }


            for (int i = 0; i < N; i++)
            {
                Arrays.fill(dist[i], INF);
            }
            dist[0][0] = map[0][0];
            q.add(new Vertex(0, 0, map[0][0]));
            while (!q.isEmpty())
            {
                Vertex vertex = q.poll();
                int x = vertex.x;
                int y = vertex.y;
                if (vertex.dist > dist[x][y])
                {
                    continue;
                }
                if (x == N - 1 && y == N - 1)
                {
                    System.out.println(dist[x][y]);
                    return;
                }
                if (x + 1 < N)
                {
                    if (dist[x + 1][y] > dist[x][y] + map[x + 1][y])
                    {
                        dist[x + 1][y] = dist[x][y] + map[x + 1][y];
                        q.add(new Vertex(x + 1, y, dist[x + 1][y]));
                    }
                }
                if (x - 1 >= 0)
                {
                    if (dist[x - 1][y] > dist[x][y] + map[x - 1][y])
                    {
                        dist[x - 1][y] = dist[x][y] + map[x - 1][y];
                        q.add(new Vertex(x - 1, y, dist[x - 1][y]));
                    }
                }
                if (y + 1 < N)
                {
                    if (dist[x][y + 1] > dist[x][y] + map[x][y + 1])
                    {
                        dist[x][y + 1] = dist[x][y] + map[x][y + 1];
                        q.add(new Vertex(x, y + 1, dist[x][y + 1]));
                    }
                }
                if (y - 1 >= 0)
                {
                    if (dist[x][y - 1] > dist[x][y] + map[x][y - 1])
                    {
                        dist[x][y - 1] = dist[x][y] + map[x][y - 1];
                        q.add(new Vertex(x, y - 1, dist[x][y - 1]));
                    }
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
