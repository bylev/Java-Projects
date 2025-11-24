public class ejercicio1{
    public static void main(String[] args) {

        
        int[] a = {1,1,2,2,3,3,3,4};
        int[] nums = a;

        System.out.println(Duplicate(nums));
        System.out.println(Duplicates(nums));


    }
    // Función que dice si existe al menos uno repetido
    public static boolean Duplicate(int[] nums){ 
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j< nums.length; j++ ){
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }

    public static int Duplicates(int[] nums){
        if(nums.length == 0){
            return 0;
    }
        int j = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[j-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j; // 4 valores diferentes
    }




}