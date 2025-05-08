public class Main {
    public static void main(String[] args) {
        // Room testing
        Room room = new Room(2, 150.0, false, false);
        room.checkIn();     // Should mark occupied & dirty
        room.checkOut();    // Should mark unoccupied but still dirty
        room.cleanRoom();   // Should clean room

        System.out.println("Room available: " + room.isAvailable()); // Expected: true


    }
}
