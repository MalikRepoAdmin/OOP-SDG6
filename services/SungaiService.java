public class SungaiService {

    public void create(Sungai s) {
        Database.sungaiList.add(s);
    }

    public List<Sungai> getAll() {
        return Database.sungaiList;
    }

    public Sungai getById(int id) {
        for (Sungai s : Database.sungaiList) {
            if (s.id == id) return s;
        }
        return null;
    }

    public boolean update(int id, Sungai dataBaru) {
        for (int i = 0; i < Database.sungaiList.size(); i++) {
            if (Database.sungaiList.get(i).id == id) {
                Database.sungaiList.set(i, dataBaru);
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        return Database.sungaiList.removeIf(s -> s.id == id);
    }
}