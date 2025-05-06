public class Main {
    public static void main(String[] args) {
        // Room testing
        Room room = new Room(2, 150.0, false, false);
        room.checkIn();     // Should mark occupied & dirty
        room.checkOut();    // Should mark unoccupied but still dirty
        room.cleanRoom();   // Should clean room

        System.out.println("Room available: " + room.isAvailable()); // Expected: true

        // Employee testing
        Employee emp = new Employee("E001", "Karina", "Housekeeping", 20.0, 0.0);
        emp.punchTimeCard(9.0);   // Punch in at 9:00 AM
        emp.punchTimeCard(17.5);  // Punch out at 5:30 PM => 8.5 hours

        System.out.println("Total pay: $" + emp.getTotalPay());
        System.out.println("Regular hours: " + emp.getRegularHours());
        System.out.println("Overtime hours: " + emp.getOvertimeHours());
    }
}
