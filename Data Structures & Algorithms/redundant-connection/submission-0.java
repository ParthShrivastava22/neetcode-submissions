class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UF uf = new UF(n + 1);

        for (int[] edge: edges) {
            if (!uf.union(edge[0], edge[1])) return edge;
        }

        return edges[0];
    }
}

class UF {
    int[] parent;

    public UF(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }

        return parent[i] = find(parent[i]);
    }

    public boolean union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI == rootJ) return false;

        parent[rootJ] = rootI;
        return true;
    }
}
