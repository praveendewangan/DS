public class _3KthRowOfPascalTriangle189 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int i = rowIndex;
        long val = 1;
        for(int j = 0; j <= i; j++){
            list.add((int)val);
            val = val * (i - j) / (j + 1);
        }
        return list;
    }
}
