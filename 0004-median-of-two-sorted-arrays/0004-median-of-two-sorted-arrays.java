class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int m = nums1.length;
        int n = nums2.length;
        int[] merged =  new int[m+n];
        System.arraycopy(nums1, 0, merged, 0, m);
        System.arraycopy(nums2, 0, merged, m, n);
        Arrays.sort(merged);
        if((m+n)%2==0){
            int mid = (m+n)/2;
            median = (merged[mid-1]+merged[mid])/2.0; 
        }else{
            median = merged[(m+n)/2];
        }
        return median;
    }    
}
