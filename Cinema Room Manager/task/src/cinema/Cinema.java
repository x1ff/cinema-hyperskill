package cinema;

import java.util.Scanner;

public class Cinema {
    private static int rowCount;
    private static int seatsCount;
    private static int purchasedTickets;
    private static int currentIncome;
    public static char[][] cinema;

    private static void visualizeCinema() {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for(int i = 0; i < seatsCount; i++) {
            System.out.printf("%d ", i + 1);
        }
        for(int i = 0; i < rowCount; i++) {
            System.out.printf("\n%d ", i + 1);
            for(int j = 0; j < seatsCount; j++) {
                System.out.print(cinema[i][j] + " ");
            }
        }
        System.out.print("\n\n");
    }
    private static void initNewCinema(Scanner sc) {
        purchasedTickets = 0;
        currentIncome = 0;

        System.out.println("Enter the number of rows:");
        setRowCount(sc.nextInt());
        System.out.println("Enter the number of seats in each row:");
        setSeatsCount(sc.nextInt());
        cinema = new char[rowCount][seatsCount];
        for(int i = 0; i < rowCount; i++) {
            for(int j = 0; j < seatsCount; j++) {
                cinema[i][j] = 'S';
            }
        }
    }
    private static boolean isBig() {
        return rowCount * seatsCount > 60;
    }
    private static int getPrice(int xRow) {
        if(isBig() && (rowCount / 2 < xRow)) {
            return 8;
        } else return 10;
    }
    private static boolean isPurchased (int xRow, int ySeats){
        if (xRow > rowCount || xRow <= 0 ||
                ySeats > seatsCount || ySeats <= 0) {
            return false;
        }
        return cinema[xRow - 1][ySeats - 1] == 'B';
    }
    private static boolean isValidCoordinates (int xRow, int ySeats){
        return xRow <= rowCount && xRow > 0 &&
                ySeats <= seatsCount && ySeats > 0;
    }
    private static void bayTicket(Scanner sc) {
        int xRow, ySeats;
        boolean isPurchased;
        do {
            System.out.println("\nEnter a row number:");
            xRow = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            ySeats = sc.nextInt();
            isPurchased = isPurchased(xRow,ySeats);
            if (!isValidCoordinates(xRow, ySeats)){
                System.out.println("\nWrong input!");
                continue;
            }
            if (isPurchased){
                System.out.println("\nThat ticket has already been purchased!");
            }
        } while (!isValidCoordinates(xRow, ySeats) || isPurchased);

        System.out.printf("\nTicket price: $%d \n", getPrice(xRow));
        cinema[xRow - 1][ySeats - 1] = 'B';
        purchasedTickets++;
        currentIncome += getPrice(xRow);
    }
    private static int getProfit() {
        if (!isBig()) {
            return rowCount * seatsCount * 10;
        } else return seatsCount * (
                10 * (rowCount / 2) + 8 * (rowCount - rowCount / 2));
    }
    private static int chooseMenuAction(Scanner sc) {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        return sc.nextInt();
    }
    private static void showStat(Scanner sc) {
        System.out.printf("\nNumber of purchased tickets: %d",
                purchasedTickets);
        System.out.printf("\nPercentage: %.2f%%", getPercentage());
        System.out.printf("\nCurrent income: $%d", currentIncome);
        System.out.printf("\nTotal income: $%d\n", getProfit());
    }
    private static double getPercentage() {
        return (double)(100 * purchasedTickets) / (rowCount * seatsCount);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initNewCinema(sc);

        boolean isExitPicked = false;
        while (!isExitPicked) {
            int action = chooseMenuAction(sc);
            switch (action) {
                case 1:
                    visualizeCinema();
                    break;
                case 2:
                    bayTicket(sc);
                    break;
                case 3:
                    showStat(sc);
                    break;
                case 0:
                    isExitPicked = true;
                    break;
                default:
                    break;
            }
        }
    }

    public static void setRowCount(int rowCount) {
        Cinema.rowCount = rowCount;
    }

    public static void setSeatsCount(int seatsCount) {
        Cinema.seatsCount = seatsCount;
    }
}