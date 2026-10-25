class Pair {
    int[] arr;
    int idx; 
    Pair(int[] arr, int idx) {
        this.arr = arr;
        this.idx = idx;
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] sortedTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i; 
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.arr[1] == b.arr[1])
                return Integer.compare(a.idx, b.idx);
            return Integer.compare(a.arr[1], b.arr[1]);
        });
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
        int[] ans = new int[tasks.length];
        int time = sortedTasks[0][0];
        int i = 0, cnt = 0;

        while (cnt < sortedTasks.length) {
            while (i < sortedTasks.length && sortedTasks[i][0] <= time) {
                pq.offer(new Pair(sortedTasks[i], sortedTasks[i][2]));
                i++;
            }

            if (pq.isEmpty()) {
                time = sortedTasks[i][0];
            } else {
                Pair curr = pq.poll();
                ans[cnt++] = curr.idx;
                time += curr.arr[1]; 
            }
        }
        return ans;
    }
}
