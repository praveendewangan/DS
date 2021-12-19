import java.io.*;
import java.util.*;

public class _9OnlineStockSpanLC901 {

    static class StockSpanner {

        Stack<Pair> st;
        static class Pair{
            int stock;
            int index;
            Pair(int stock,int index) {
                this.stock = stock;
                this.index = index;
            }
        }
        
        public StockSpanner() {
            st = new Stack<>();
        }
        
        public int next(int price) {
            int span = 1;
            while(!st.empty() && price >= st.peek().stock) {
                span += st.peek().index;
                st.pop();
            }
            st.push(new Pair(price,span));
            return span;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        StockSpanner obj = new StockSpanner();

        while(read.ready()){
            int price = Integer.parseInt(read.readLine());
            System.out.println(obj.next(price));
        }        
    }
}
