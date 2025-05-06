public class Room {
    private int numberOfBeds;
    private double price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numberOfBeds, double price, boolean isOccupied, boolean isDirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    public void checkIn() {
        if (isAvailable()) {
            isOccupied = true;
            isDirty = true;
            System.out.println("Checked into room successfully.");
        } else {
            System.out.println("Room not available for check-in.");
        }
    }

    public void checkOut() {
        if (isOccupied) {
            isOccupied = false;
            System.out.println("Checked out of room. Room needs cleaning.");
        } else {
            System.out.println("Room is not currently occupied.");
        }
    }

    public void cleanRoom() {
        if (!isOccupied && isDirty) {
            isDirty = false;
            System.out.println("Room cleaned successfully.");
        } else {
            System.out.println("Room cannot be cleaned right now.");
        }
    }
}
