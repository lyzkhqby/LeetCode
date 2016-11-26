import java.util.Iterator;

/**
 * Created by zk on 2016/11/27.
 */
public class PeekingIteratorII implements Iterator<Integer>{
    private Iterator<Integer> iterator;
    private boolean hasPeeked = false;
    private int peek;

    public PeekingIteratorII(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (hasPeeked) {
            return peek;
        }else {
            if (hasNext()) {
                peek = iterator.next();
                hasPeeked = true;
                return peek;
            }
        }
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasPeeked) {
            hasPeeked = false;
            return peek;
        } else {
            if (hasNext()) {
                return iterator.next();
            }
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();//hasPeeked是为了最后next（）最后此时还没有peek（）最后
    }
}
