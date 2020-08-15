/**
Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions

the composition is not null and is not guaranteed to be sorted
K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
Return

a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
**/
import java.util.*;

public class Solution{
    public String[] topKFrequent(String[] combo, int k) {
        // Write your solution here
        if (combo == null || combo.length == 0) {
            return new String[0];
        }
        Map<String, Integer> freqMap = getFreq(combo);
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
                new Comparator<Map.Entry<String, Integer>>(){
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                });

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else if (entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        return getResult(minHeap);
    }
    private Map<String, Integer> getFreq(String[] combo) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : combo) {
            Integer count = freqMap.get(s);
            if (count == null) {
                freqMap.put(s, 1);
            } else {
                freqMap.put(s, ++count);
            }
        }
        return freqMap;
    }
    private String[] getResult(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
        String[] res = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0; i--) { // sort it from the most freq; note: minHeap.size() is changing
            res[i] = minHeap.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] s = {"a", "b", "b"};

        System.out.println(Arrays.toString(sol.topKFrequent(s, 1)));
    }

}




