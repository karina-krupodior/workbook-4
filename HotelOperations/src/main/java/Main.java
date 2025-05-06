public class Main {
    public static void main(String[] args) {
        // Testing Room Class
        Room room = new Room(2, 150.0, false, false);
        System.out.println("Room available: " + room.isAvailable());  // Expected: true

        // Testing Reservation Class
        Reservation reservation = new Reservation("king", 3, true);
        System.out.println("Reservation total: $" + reservation.getReservationTotal());  // Expected: 457.8

        // Testing Employee Class
        Employee emp = new Employee("E001", "Karina", "Housekeeping", 20.0, 45);
        System.out.println("Total pay: $" + emp.getTotalPay());  // Expected: 950.0
        System.out.println("Overtime hours: " + emp.getOvertimeHours());  // Expected: 5.0
    }
}
