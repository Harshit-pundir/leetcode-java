class SnapshotArray {

    ArrayList<ArrayList<Integer>> list;
    int snapId = 0;

    public SnapshotArray(int length) {
        list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            // value, snapId
            temp.add(0);
            temp.add(0);

            list.add(temp);
        }
    }

    public void set(int index, int val) {
        ArrayList<Integer> temp = list.get(index);

        temp.add(val);
        temp.add(snapId);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {

        ArrayList<Integer> temp = list.get(index);

        int ans = 0;

        for (int i = 0; i < temp.size(); i += 2) {

            int value = temp.get(i);
            int id = temp.get(i + 1);

            if (id <= snap_id) {
                ans = value;
            } else {
                break;
            }
        }

        return ans;
    }
}