import java.util.*;

class Solution {
    int mod = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        if (edges.length == 0) return 1;

        HashMap<Integer, List<Integer>> hmap = new HashMap<>();

        for (int[] e : edges) {
            int s = e[0];
            int d = e[1];

            hmap.putIfAbsent(s, new ArrayList<>());
            hmap.putIfAbsent(d, new ArrayList<>());

            hmap.get(s).add(d);
            hmap.get(d).add(s);
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(1);
        visited.add(1);

        int depth = -1;

        while (!q.isEmpty()) {
            depth++;

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int curr = q.remove();

                for (int next : hmap.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.add(next);
                    }
                }
            }
        }

        return power(2, depth - 1);
    }

    int power(int base, int exp) {
        long res = 1;
        long b = base;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = (res * b) % mod;
            }

            b = (b * b) % mod;
            exp >>= 1;
        }

        return (int) res;
    }
}
