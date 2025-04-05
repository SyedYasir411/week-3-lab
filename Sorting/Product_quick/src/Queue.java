public class Queue {

    public static void swap(int[] arr,int n1,int n2){
        int temp=arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=temp;
    }
    public static int fun(int[] arr,int low,int high){
        int pivot = arr[low];
        int i=low;
        int j=high;
        while(i<j) {
            while (arr[i] <= pivot && i < high) {
                i++;
            }
            while (arr[j] > pivot && j > low) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr,low,j);

        return j;
    }
    public static void QuickSort(int[] arr,int low,int high){
        if(low<high){
             int p=fun(arr,low,high);
             QuickSort(arr,low,p-1);
             QuickSort(arr,p+1,high);
        }
    }
    public static void main(String[] args){
      int[] arr= {23,12,4,5,11,36,4};
      int x=0;
      int y=(arr.length)-1;
      QuickSort(arr,x,y);
      for(int i=0;i<arr.length;i++){
          System.out.println(arr[i]);
      }

    }
}
