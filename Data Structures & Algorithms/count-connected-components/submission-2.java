class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);

        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
            uf.find(edge[1]);
        }

        Set<Integer> set = new HashSet<>();

        for (int p: uf.parent) {
            set.add(uf.find(p));
        }

        return set.size();
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
