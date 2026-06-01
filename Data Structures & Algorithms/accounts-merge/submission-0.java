class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF uf = new UF(accounts);
        Map<String, String> name = new HashMap<>();

        for (List<String> account: accounts) {
            int n = account.size();
            String currentName = account.get(0);
            for (int i = 1; i < n; i++) {
                String p1 = uf.find(account.get(i));
                String p2 = uf.find(account.get(1));
                name.put(p2, currentName);

                uf.union(p2, p1);
            }
        }

        Map<String, Set<String>> setMap = new HashMap<>();

        for (List<String> account: accounts) {
            int n = account.size();
            for (int i = 1; i < n; i++) {
                String current = account.get(i);
                String parent = uf.find(current);

                if (!setMap.containsKey(parent)) {
                    Set<String> newSet = new HashSet<>();
                    setMap.put(parent, newSet);
                }
                setMap.get(parent).add(current);
            }
        }

        List<List<String>> finalList = new ArrayList<>();

        for (Map.Entry<String, Set<String>> entry: setMap.entrySet()) {
            List<String> newList = new ArrayList<>(entry.getValue());
            newList.sort(null);
            newList.add(0, name.get(entry.getKey()));
            finalList.add(newList);
        }

        return finalList;
    }
}

class UF {
    Map<String, String> parent;

    public UF(List<List<String>> accounts) {
        parent = new HashMap<>();

        for (List<String> account: accounts) {
            int n = account.size();
            for (int i = 1; i < n; i++) {
                parent.put(account.get(i), account.get(i));
            }
        }
    }

    public String find(String account) {
        if (parent.get(account).equals(account)) return account;

        parent.put(account, find(parent.get(account)));
        return parent.get(account);
    }

    public boolean union(String account1, String account2) {
        String root1 = find(account1);
        String root2 = find(account2);

        if (root1.equals(root2)) return false;

        parent.put(root2, root1);

        return true;
    }
}