class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // put everything in the minHeap
        // automatically sorts everything
        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}
