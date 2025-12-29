class Solution {
    public int leastInterval(char[] tasks, int n) {
        int totalTask = tasks.length, maxFreq = 0, countMaxFreq = 0;
        int[] freq = new int[26];

        for(char task: tasks){
            freq[task - 'A']++;
        }

        for(int fr: freq){
            maxFreq = Math.max(maxFreq, fr);
        }

        //Either the task length is more or the idle times have to included to the existing tasks so that the cycle length is maintained

        for(int fr: freq){
            if(fr == maxFreq)
                countMaxFreq++;
        }

        return Math.max((n+1) * (maxFreq - 1) + countMaxFreq, totalTask);
    }
}
