import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeSet;

/**
 * Created by rotoosoft-d04 on 2016/9/22.
 */
public class InsertDeleteGetRandomDuplicatesAllowed {
    private HashMap<Integer, TreeSet<Integer>> dataMap;
    private ArrayList<Integer> dataList;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDuplicatesAllowed() {
        dataMap = new HashMap<>();
        dataList = new ArrayList<>();

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        TreeSet<Integer> ts = dataMap.get(val);
        if (ts == null) {
            ts = new TreeSet<>();
            dataMap.put(val, ts);
        }
        ts.add(dataList.size());
        dataList.add(val);
        return ts.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        TreeSet<Integer> idxSet = dataMap.get(val);
        if (idxSet == null || idxSet.isEmpty()) return false;

        int idx = idxSet.pollLast();

        int tail = dataList.get(dataList.size() - 1);
        TreeSet<Integer> tailIdxSet = dataMap.get(tail);
        if (tail != val) {
            tailIdxSet.pollLast();
            tailIdxSet.add(idx);
            dataList.set(idx, tail);
        }
        dataList.remove(dataList.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return dataList.get(new Random().nextInt(dataList.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
