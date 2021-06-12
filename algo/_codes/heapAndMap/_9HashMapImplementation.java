import java.util.ArrayList;
import java.util.LinkedList;

public class _9HashMapImplementation {
    class Node<K,V> {
        K key;
        V value;
        Node() {}
        Node(K key,V value) {
            this.key = key;
            this.value = value;
        }
    }
    interface Map<K,V> {

    } 
    class HashMap<K,V> implements Map <K,V>{
        private int size = 0;
        private LinkedList<Node<K,V>>[] bucket;

        private void init(int cap) {
            bucket = new LinkedList[cap];
            for(int i = 0; i < cap; i++) {
                bucket[i] = new LinkedList<>();
            }
        }

        HashMap(){
            init(4);
        }

        private int hashFunction(K key) {
            int bi = Math.abs(key.hashCode()) % bucket.length;
            return bi;
        }

        private int searchInBucket(K key, int bi) {
            int di = 0;
            for(Node node : bucket[bi]) {
                if(node.key.equals(key)) {
                    return di;
                }
                di++;
            } 
            return -1;
        }

        public void put(K key,V value) {
            int bi = hashFunction(key);

            int di = searchInBucket(key, bi);
            if(di == -1) {
                this.size++;
                bucket[bi].addLast(new Node<K,V>(key, value));
            } else {
                bucket[bi].get(di).value = value;
            }
            int n = this.size;
            int N = bucket.length;
            double loadFactor = n * 1.0 / N;
            if(loadFactor <= 0.75) {
                rehash();
            }
        }

        private void rehash() {
            LinkedList<Node<K,V>>[] ob = bucket;
            init(2 * bucket.length);

            // Fill in new bucket;
            for(int i = 0; i < ob.length; i++) {
                for(Node<K,V> node : ob[i]) {
                    put(node.key, node.value);
                }
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);

            int di = searchInBucket(key, bi);
            if(di == -1) {
                return null;
            } else {
                this.size--;
                Node<K,V> node = bucket[bi].remove(di);
                return node.value;
            }
        }
        public V get(K key) {
            int bi = hashFunction(key);

            int di = searchInBucket(key, bi);
            if(di == -1) {
                return null;
            } else {
                return bucket[bi].get(di).value;
            }
        }
        public boolean containsKey(K key) {
            int bi = hashFunction(key);

            int di = searchInBucket(key, bi);
            if(di == -1) {
                return false;
            } else {
                return true;
            }
        }
        public ArrayList<K> keyset() throws Exception {
            ArrayList<K> list = new ArrayList<>();
            for(int i = 0; i < bucket.length; i++) {
                for(Node<K,V> node : bucket[i]) {
                    list.add(node.key);
                }
            }
            return list;
        }
    }
}
