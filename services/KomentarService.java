public class KomentarService {

    public void addKomentar(Komentar k) {
        Database.komentarList.add(k);
    }

    public List<Komentar> getBySungai(int sungaiId) {
        List<Komentar> result = new ArrayList<>();
        for (Komentar k : Database.komentarList) {
            if (k.sungaiId == sungaiId) {
                result.add(k);
            }
        }
        return result;
    }

    public boolean delete(int id) {
        return Database.komentarList.removeIf(k -> k.id == id);
    }
}