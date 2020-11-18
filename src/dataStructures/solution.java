package dataStructures;

public class solution {
	
	public static void printArray(int[] nums) {
		for(int i : nums)
			System.out.print(i);
	}
	
	public static int removeDuplicates(int[] nums) {
        int p=0;
        for(int i=0; i<nums.length-p; i++){
            for(int j=i+1; j<nums.length-p;){
                if(nums[i]==nums[j]){
                    for(int k=j+1; k<nums.length-p; k++)
                        nums[k-1] = nums[k];
                    p++;
                }else break;
                System.out.println(p);
                printArray(nums);
                System.out.println();
            }
        }
        return nums.length-p;
    }

	public static void main(String[] args) {
		System.out.println(removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
	}

}
