import java.util.Scanner;
class Room {
    int roomNumber;
    String roomType;
    double pricePerDay;
    boolean isAvailable;
    Room(int roomNumber, String roomType, double pricePerDay) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true; 
    }
    void showDetails() {
        String status = isAvailable ? "Available" : "Occupied";
        System.out.println("Room " + roomNumber + " [" + roomType + "] - ₹" + pricePerDay + "/day - Status: " + status);
    }
}
class Hotel {
    Room[] rooms = new Room[4]; 
    Hotel() {
        rooms[0] = new Room(101, "Single", 500);
        rooms[1] = new Room(102, "Double", 1000);
        rooms[2] = new Room(103, "Deluxe", 1500);
        rooms[3] = new Room(104, "Deluxe", 1500);
    }
    void displayRooms() {
        System.out.println("\n--- HOTEL ROOMS STATUS ---");
        for (Room r : rooms) {
            r.showDetails();
        }
    }
    void bookRoom(int rNo) {
        for (Room r : rooms) {
            if (r.roomNumber == rNo) {
                if (r.isAvailable) {
                    r.isAvailable = false;
                    System.out.println("Success: Room " + rNo + " room booked!");
                } else {
                    System.out.println("Sorry: Room " + rNo + " occupide try another room.");
                }
                return;
            }
        }
        System.out.println("Error: Room number not found.");
    }
    void cancelRoom(int rNo) {
        for (Room r : rooms) {
            if (r.roomNumber == rNo) {
                r.isAvailable = true;
                System.out.println("Success: Room " + rNo + " room booking succses full.");
                return;
            }
        }
        System.out.println("Error: Room number not found.");
    }
    void calculateBill(int rNo, int days) {
        for (Room r : rooms) {
            if (r.roomNumber == rNo) {
                double total = r.pricePerDay * days;
                double tax = total * 0.10;
                double serviceCharge = 200;
                double finalBill = total + tax + serviceCharge;
                System.out.println("\n--- BILL DETAILS FOR ROOM " + rNo + " ---");
                System.out.println("Base Price (" + days + " days): ₹" + total);
                System.out.println("Tax (10%): ₹" + tax);
                System.out.println("Service Charge: ₹" + serviceCharge);
                System.out.println("Total Amount to Pay: ₹" + finalBill);
                return;
            }
        }
    }
}
public class Hotel_Room_Reservation_Application{
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.displayRooms();
        System.out.println("\nBooking Room 102...");
        hotel.bookRoom(102);
        System.out.println("\nBooking Room 102 Again...");
        hotel.bookRoom(102);
        hotel.calculateBill(102, 3);
        System.out.println("\nCancelling Room 102...");
        hotel.cancelRoom(102);
        hotel.displayRooms();
    }
}
