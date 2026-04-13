interface Service {
    double calculateBill(int days, double rate);
}
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
    void showRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Day: " + pricePerDay);
        if (isAvailable) {
            System.out.println("Status: Available");
        } else {
            System.out.println("Status: Occupied");
        }
        System.out.println("--------------------------");
    }
}
class Hotel implements Service {
    Room[][] rooms; 
    Hotel(int totalFloors, int roomsPerFloor) {
        rooms = new Room[totalFloors][roomsPerFloor];
        int roomNumber = 101;
        for (int i = 0; i < totalFloors; i++) {
            for (int j = 0; j < roomsPerFloor; j++) {
                String type;
                double price;
                if (j == 0) {
                    type = "Single";
                    price = 499;
                } else if (j == 1) {
                    type = "Double";
                    price = 1000;
                } else {
                    type = "Deluxe";
                    price = 1500;
                }

                rooms[i][j] = new Room(roomNumber, type, price);
                roomNumber++;
            }
        }
    }
    void bookRoom(int floor, int roomIndex) {
        if (rooms[floor][roomIndex].isAvailable == true) {
            rooms[floor][roomIndex].isAvailable = false;
            System.out.println("Room booked successfully!");
        } else {
            System.out.println("Room is already occupied!");
        }
    }
    void cancelRoom(int floor, int roomIndex) {
        rooms[floor][roomIndex].isAvailable = true;
        System.out.println("Booking cancelled!");
    }
    public double calculateBill(int days, double rate) {
        double total = days * rate;
        double tax = total * 0.10;
        double serviceCharge = 200;
        double finalAmount = total + tax + serviceCharge;
        return finalAmount;
    }
    void displayAllRooms() {
        System.out.println("\n----- ROOM STATUS -----");
        for (int i = 0; i < rooms.length; i++) {
            System.out.println("Floor " + (i + 1) + ":");
            for (int j = 0; j < rooms[i].length; j++) {
                rooms[i][j].showRoomDetails();
            }
        }
    }
    double getPrice(int floor, int roomIndex) {
        return rooms[floor][roomIndex].pricePerDay;
    }
}
public class hotel_room {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(2, 3);
        hotel.displayAllRooms();
        System.out.println("\nBooking Room...");
        hotel.bookRoom(0, 1);
        System.out.println("\nBooking Same Room Again...");
        hotel.bookRoom(0, 1);
        System.out.println("\nCancelling Booking...");
        hotel.cancelRoom(0, 1);
        System.out.println("\nBooking Again...");
        hotel.bookRoom(0, 1);
        int days = 3;
        double rate = hotel.getPrice(0, 1);
        double bill = hotel.calculateBill(days, rate);
        System.out.println("\nTotal Bill for " + days + " days = " + bill);
        hotel.displayAllRooms();
    }
}
