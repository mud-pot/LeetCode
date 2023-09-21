class Solution {
    public List<Integer> generateRow(int r){
        int element = 1;
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int c=1; c<r; c++){
            element*=r-c;
            element=element/c;
            row.add(element);
        }
        return row;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
            for(int i=1; i<=numRows; i++){
                pascal.add(generateRow(i));
            }
            return pascal;
    }
}