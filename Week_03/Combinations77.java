public class Solution {
    private void findCombinations(int n, int k, int begin, Stack<Integer> pre, List<List<Integer>> ret) {
        if (pre.size() == k) {
            ret.add(new ArrayList<>(pre));
            return;
        }
        for (int i = begin; i <= n; i++) {
            pre.add(i);
            findCombinations(n, k, i + 1, pre,ret);
            pre.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        if (n <= 0 || k <= 0 || n < k) {
            return ret;
        }
        findCombinations(n, k, 1, new Stack<>(), ret);
        return ret;
    }
}