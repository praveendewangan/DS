import java.util.ArrayList;
import java.util.List;

public class _10PriorityQueue {
    class PriorityQueue<T>{
        List<T> data;

        PriorityQueue() {
            data = new ArrayList<>();
        }

        public void add(T val) {
            data.add(val);

            upheapify(data.size()-1);
        }

        private void upheapify(int idx) {
            Comparable<? super T> key = (Comparable<? super T>) data.get(idx);
            if(idx == 0) return;
            int pi = (idx-1) /2;
            if(key.compareTo((T) data.get(pi)) < 0) {
                swap(pi,idx);
                upheapify(pi);
            }
        }
        public T remove() {
            if(size() == 0) {
                return null;
            }
            T val = data.get(0);
            swap(0, size()-1);
            data.remove(size() - 1);
            downheapify(0);
            return val;
        }

        private void downheapify(int pi) {
            
            Comparable<? super T> key = (Comparable<? super T>) data.get(pi);
            int minIdx = pi;
            int lidx = 2*pi + 1;
            int ridx = 2*pi + 2;
            if(lidx < data.size() && key.compareTo((T) data.get(lidx)) < 0) {
                minIdx = lidx;
            }
            if(ridx < data.size() && key.compareTo((T) data.get(ridx)) < 0) {
                minIdx = ridx;
            }
            if(minIdx != pi) {
                swap(pi,minIdx);
                downheapify(minIdx);
            }
        }
        public T peek() {
            if(size() == 0) {
                return null;
            }
            return data.get(0);
        }
        private void swap(int i,int j) {
            T temp = data.get(i);
            data.set(i, data.get(j));
            data.set(j, temp);
        }

        public int size(){
            return data.size();
        }

        
    
        public <T extends Comparable<T>> int compare(final T name1, final T name2) {
            if (name1 == null) return name2 == null ? 0 : -1;
            if (name2 == null) return 1;
            return name1.compareTo(name2);
        }
    }
}
