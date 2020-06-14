class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int L = beginWord.length();
        HashMap<String,List<String>> wordListMap = new HashMap<>();
        for (String word: wordList) {
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, L);
                List<String> wl = wordListMap.getOrDefault(newWord,new ArrayList<>());
                wl.add(word);
                wordListMap.put(newWord, wl);
            }
        }

        Queue<Pair<String,Integer>> dfsq = new LinkedList<>();
        dfsq.add(new Pair(beginWord, 1));

        Map<String,Boolean> visited = new HashMap();
        visited.put(beginWord,true);

        while (!dfsq.isEmpty()) {
            Pair<String,Integer> q = dfsq.remove();
            String word = q.getKey();
            int level = q.getValue();
            for (int i = 0; i < L; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, L);
                List<String> wl = wordListMap.getOrDefault(newWord, new ArrayList<>());
                for (String w : wl) {
                    if (w.equals(endWord))
                        return level + 1;
                    if (!visited.containsKey(w)) {
                        visited.put(w, true);
                        dfsq.add(new Pair(w,level+1));
                    }
                }
            }
        }
        return 0;



    }
}