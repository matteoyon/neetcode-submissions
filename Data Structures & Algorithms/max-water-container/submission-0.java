class Solution {
    public int maxArea(int[] heights) {
        var l = 0;
        var r = heights.length-1;
        var size = 0;
        
        while(l<r){
            var tmp = Math.min(heights[l],heights[r])*(r-l);
            if(tmp > size) size = tmp;

            if(heights[l]<=heights[r]) l++;
            else r--;
        }

        return size;
    }
}
