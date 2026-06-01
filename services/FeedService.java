public class FeedService {

    public void create(Feed f) {
        Database.feeds.add(f);
    }

    public List<Feed> getAll() {
        return Database.feeds;
    }

    public boolean update(int id, Feed dataBaru) {
        for (int i = 0; i < Database.feeds.size(); i++) {
            if (Database.feeds.get(i).id == id) {
                Database.feeds.set(i, dataBaru);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return Database.feeds.removeIf(f -> f.id == id);
    }
}