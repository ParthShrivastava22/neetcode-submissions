class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        
        if (visited.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int turns = 0;

        while(!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                String current = queue.poll();
                if (current.equals(target)) return turns;

                for (int j = 0; j < 4; j++) {
                    char c = current.charAt(j);

                    StringBuilder upNode = new StringBuilder(current);
                    char upChar = (c == '9') ? '0' : (char) (c + 1);
                    upNode.setCharAt(j, upChar);
                    String up = upNode.toString();
                    
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }

                    StringBuilder downNode = new StringBuilder(current);
                    char downChar = (c == '0') ? '9' : (char) (c - 1);
                    downNode.setCharAt(j, downChar);
                    String down = downNode.toString();
                    
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            turns++;
        }

        return -1;
    }

    private String turnDial(String s, int index, int direction) {
        char[] chars = s.toCharArray();
        int num = chars[index] - '0';
        
        int newNum = (num + direction + 10) % 10; 
        
        chars[index] = (char) (newNum + '0');
        return new String(chars);
    }
}