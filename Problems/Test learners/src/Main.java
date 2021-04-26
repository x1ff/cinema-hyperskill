import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        switch (number) {
            case 1:
                System.out.println("Yes!");
                break;
            case 2:
            case 4:
            case 3:
                System.out.println("No!");
                break;
            default:
                System.out.println("Unknown number");
                break;
        }
    }
}