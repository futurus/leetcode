public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int c = m+n, i = m - 1, j = n - 1;
        
        while (c > 0 && (i >= 0 || j >= 0)) {
            if (i >= 0 && j >= 0) {
                nums1[--c] = nums1[i] <= nums2[j] ? nums2[j--] : nums1[i--];
            } else if (i >= 0 && j < 0) {
                nums1[--c] = nums1[i--];
            } else if (i <= 0 && j >= 0) {
                nums1[--c] = nums2[j--];
            }
        }
        
        return;
    }
}

// even more succinct
// 1st loop: either i runs out first or j runs out first
// - if i runs out first, finish with elems from j
// - if j runs out first, 2nd loop won't be executed, won't need to 
//   move the remaining elements from first (also resulting) array either
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int c = m + n, i = m - 1, j = n - 1;
        
        while (i >= 0 && j >= 0) 
            nums1[--c] = nums1[i] <= nums2[j] ? nums2[j--] : nums1[i--];
        
        while (j >= 0)
            nums1[--c] = nums2[j--];
       
        return;
    }
}
