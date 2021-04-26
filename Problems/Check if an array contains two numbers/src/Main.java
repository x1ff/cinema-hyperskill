import java.util.Scanner;

class Main {
    private static int[] arr;
    public static boolean isOccur(int n, int m) {
        boolean isOccur = false;
        for (int i = 1; i < arr.length; i++) {
            if((arr[i - 1] == n && arr[i] == m) ||
                    (arr[i - 1] == m && arr[i] == n)) {
                isOccur = true;
                break;
            }
        }
        return isOccur;
    }
    private static void setArr(int ln, Scanner sc) {
        arr = new int[ln];
        for (int i = 0; i < ln; i++) {
            arr[i] = sc.nextInt();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        setArr(sc.nextInt(),sc);
        System.out.println(isOccur(sc.nextInt(), sc.nextInt()));
    }
}