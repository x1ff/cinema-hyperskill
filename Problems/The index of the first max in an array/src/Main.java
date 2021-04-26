import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] arr = new int[count];
        arr[0] = sc.nextInt();
        int indexOfMaxNumber = 0;
        int maxNumber = arr[0];
        for(int i = 1; i < count; i++) {
            arr[i] = sc.nextInt();
            if (maxNumber < arr[i]) {
                maxNumber = arr[i];
                indexOfMaxNumber = i;
            }
        }
        System.out.println(indexOfMaxNumber);
    }
}