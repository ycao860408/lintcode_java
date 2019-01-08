public class FriendshipService {
    HashMap<Integer, Set<Integer>> followers, followings;
    public FriendshipService() {
        // do intialization if necessary
        followers = new HashMap<>();
        followings = new HashMap<>();
    }

    /*
     * @param user_id: An integer
     * @return: all followers and sort by user_id
     */
    public List<Integer> getFollowers(int user_id) {
        // write your code here
        if (!followers.containsKey(user_id)) {
            return new ArrayList<Integer>();
        }
        return new ArrayList<Integer>(followers.get(user_id));
    }

    /*
     * @param user_id: An integer
     * @return: all followings and sort by user_id
     */
    public List<Integer> getFollowings(int user_id) {
        // write your code here
        if (!followings.containsKey(user_id)) {
            return new ArrayList<Integer>();
        }
        return new ArrayList<Integer>(followings.get(user_id));
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void follow(int to_user_id, int from_user_id) {
        // write your code here
        if (!followers.containsKey(to_user_id)) {
            followers.put(to_user_id, new TreeSet<Integer>());
        }
        followers.get(to_user_id).add(from_user_id);
        
        if (!followings.containsKey(from_user_id)) {
            followings.put(from_user_id, new TreeSet<Integer>());
        }
        followings.get(from_user_id).add(to_user_id);
    }

    /*
     * @param from_user_id: An integer
     * @param to_user_id: An integer
     * @return: nothing
     */
    public void unfollow(int to_user_id, int from_user_id) {
        // write your code here
        if (followers.containsKey(to_user_id)) {
            followers.get(to_user_id).remove(from_user_id);
        }
        if (followings.containsKey(from_user_id)) {
            followings.get(from_user_id).remove(to_user_id);
        }
    }
}