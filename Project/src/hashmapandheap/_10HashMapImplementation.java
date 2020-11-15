package hashmapandheap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _10HashMapImplementation {
    public static class HashMap<K,V> {
        private class HMNode {
            K key;
            V value;
            HMNode(K key,V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int size;
        private LinkedList<HMNode>[] buckets;

        public HashMap() {
            initBuckets(4);
            size = 0;
        }

        private void initBuckets(int N) {
            buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public void put(K key,V value) {
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key,bi);
            if(di != -1) {
                HMNode node = buckets[bi].get(di);
                node.value = value;
            } else {
                HMNode node = new HMNode(key,value);
                buckets[bi].add(node);
                size++;
                double lambda = size * 1.0 / buckets.length;
                if(lambda > 2.0) {
                    rehash();
                }
            }
        }
        private int hashfn(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % buckets.length;
        }

        private int getIndexWithinBucket(K key, int bi ){
            int di = 0;
            for (HMNode node : buckets[bi]) {
                if(node.key.equals(key)) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        public boolean containsKey(K key) {
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key,bi);
            if(di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key,bi);
            if(di != -1) {
                HMNode node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashfn(key);
            int di = getIndexWithinBucket(key,bi);
            if(di != -1) {
                HMNode node = buckets[bi].remove(di);
                size--;
                return node.value;
            } else {
                return null;
            }
        }

        public int size() {
            return size;
        }

        public List<K> keySet() {
            List<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                for (HMNode node : buckets[i]) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        private void rehash() {
            LinkedList<HMNode>[] oba = buckets;
            initBuckets(buckets.length * 2);
            size = 0;
            for (int i = 0; i < oba.length; i++) {
                for (HMNode node : oba[i]) {
                    put(node.key,node.value);
                }
            }
        }
    }
}
