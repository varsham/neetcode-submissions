class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create a hashmap to store the number : frequency pairs
        Map<Integer, Integer> freq = new HashMap<>();

        // populate the hashmap
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // create a priority queue with int[frequency, number] pairs
        // sort it in ascending order
        // the first element is the root
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));

        // populate the priority queue
        // key: frequency
        // value: number
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(new int[] {entry.getValue(), entry.getKey()});

            if (heap.size() > k) {
                heap.poll();
            }
        }
        // if the size of the queue gets to be higher than k, remove the root

        // create a result list
        int[] result = new int[k];

        // pop everything from the priority queue and add it to the result list
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll()[1]; // removes and returns the root
            // returns frequency in ascending order!
        }

        // return the result list
        return result;
    }
}
