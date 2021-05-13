public class _26GenerateBinaryNumberQueue {
    static ArrayList<String> generate(int N)
    {
        Queue<String> q = new ArrayDeque<>();
        q.add("1");
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            String rm = q.remove();
            list.add(rm);
            q.add(rm + "0");
            q.add(rm + "1");
        }
        return list;
    }
}
