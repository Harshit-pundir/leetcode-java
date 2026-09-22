class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer nextVal;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;

        if (iterator.hasNext()) {
            nextVal = iterator.next();
        }
    }

    // Returns next element without advancing
    public Integer peek() {
        return nextVal;
    }

    @Override
    public Integer next() {
        Integer ans = nextVal;

        if (iterator.hasNext()) {
            nextVal = iterator.next();
        } else {
            nextVal = null;
        }

        return ans;
    }

    @Override
    public boolean hasNext() {
        return nextVal != null;
    }
}