package Algorithm;

public class SearchAlgorithm {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,6,8};
        int target = 6;

        int index = GetIndex(arr1,target);
        if (index != - 1){
            System.out.println("Phan tu " + target + "duoc tim thay o vi tri " + index);
        }else {
            System.out.println("Khong tim thay phan tu:" + target);
        }
    }
    public static int GetIndex(int[] arr, int target){
        for (int i = 0; i< arr.length;i++){
            if (arr[i] == target){
                return i-1;
            }
        }
        return -1;
    }
}
