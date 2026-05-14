class Twitter {
    int time;
    HashMap<Integer, Set<Integer>> follows;
    HashMap<Integer, Node> tweets;

    public Twitter() {
        time = 0;
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        time++;
        Node newHead = new Node(tweetId, time, tweets.get(userId));
        tweets.put(userId, newHead);
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> feed =
            new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // 1️⃣ Add user's own tweets
        Node head = tweets.get(userId);
        while (head != null) {
            feed.offer(new int[]{head.time, head.tweetId});
            head = head.next;
        }

        // 2️⃣ Add followees' tweets (if any)
        Set<Integer> following = follows.getOrDefault(userId, new HashSet<>());

        for (int followee : following) {
            if (followee == userId) continue;
            Node curr = tweets.get(followee);
            while (curr != null) {
                feed.offer(new int[]{curr.time, curr.tweetId});
                curr = curr.next;
            }
        }

        // 3️⃣ Extract top 10
        List<Integer> newsFeed = new ArrayList<>();
        while (!feed.isEmpty() && newsFeed.size() < 10) {
            newsFeed.add(feed.poll()[1]);
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}

class Node {
    int tweetId;
    int time;
    Node next;

    public Node(int tweetId, int time, Node next) {
        this.tweetId = tweetId;
        this.time = time;
        this.next = next;
    }
}

