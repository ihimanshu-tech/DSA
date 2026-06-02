class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length -1);
        return nums;

    }
    public void mergeSort(int[] nums,int s, int e){
        if(s>=e)
            return;
        int mid =  s+ (e - s)/2;
        mergeSort(nums,s,mid); //left partition
        mergeSort(nums,mid+1,e); //right partition
        merge(nums,s,mid,e);

    }
    public void merge(int[] nums,int s, int m,int e){
        int[] mix = new int[e - s +1];
        int i = s;
        int j = m +1;
        int k = 0;
        while(i<=m && j<=e){
            if(nums[i]<nums[j]){
                mix[k] =nums[i];
                i++;
            }
            else{
                mix[k] = nums[j];
                j++;
            }
            k++;

        }
        while (i <= m) {
            mix[k] = nums[i];
            i++;
            k++;
        }

        while (j <= e) {
            mix[k] = nums[j];
            j++;
            k++;
        }
        for (int l = 0; l < mix.length; l++) {
            nums[s+l] = mix[l];
        }
    }

}