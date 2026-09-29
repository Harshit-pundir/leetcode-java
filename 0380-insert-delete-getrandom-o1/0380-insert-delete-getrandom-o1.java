class RandomizedSet {
    HashSet<Integer> set;
    Random random;

    public RandomizedSet() {
        set = new HashSet<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (!set.contains(val)) {
            set.add(val);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int index = random.nextInt(set.size());

        for (int val : set) {
            if (index == 0) {
                return val;
            }
            index--;
        }

        return -1;
    }
}