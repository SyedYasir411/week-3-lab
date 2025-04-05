public class linearSearch {
    public static void main(String[] args) {
        int[] arr = {5, 3, -1, 7, 8, -5, 9};

        int index = NegativeNumber(arr);

        if (index != -1) {
            System.out.println("The first negative number is at index: " + index);
        } else {
            System.out.println("No negative number found.");
        }
    }

    public static int NegativeNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
