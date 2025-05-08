import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RoomTest {

    private Room room;

    @Before
    public void setUp() {
        room = new Room(2, 100.0, false, false); // Default: available and clean
    }

    // Test checkIn()
    @Test
    public void testCheckIn_Success() {
        // Arrange
        // Room is available and clean by default

        // Act
        room.checkIn();

        // Assert
        assertTrue("Room should be occupied", room.isOccupied());
        assertTrue("Room should be dirty", room.isDirty());
    }


    @Test
    public void testCheckIn_RoomIsDirty() {
        // Arrange
        room = new Room(2, 100.0, false, true); // Room is dirty

        // Act
        room.checkIn();

        // Assert
        assertFalse("Room should not be checked in", room.isOccupied());
    }

    // Test checkOut()
    @Test
    public void testCheckOut_Success() {
        // Arrange
        room.checkIn(); // Room is occupied

        // Act
        room.checkOut();

        // Assert
        assertFalse("Room should be available after checkout", room.isOccupied());
    }

    @Test
    public void testCheckOut_RoomNotOccupied() {
        // Arrange
        // Room is not occupied initially

        // Act
        room.checkOut();

        // Assert
        assertFalse("Room should not be occupied", room.isOccupied());
    }

    // Test cleanRoom()
    @Test
    public void testCleanRoom_Success() {
        // Arrange
        room = new Room(2, 100.0, false, true); // Room is dirty and available

        // Act
        room.cleanRoom();

        // Assert
        assertFalse("Room should be clean", room.isDirty());
    }

    @Test
    public void testCleanRoom_RoomOccupied() {
        // Arrange
        room.checkIn(); // Room is occupied

        // Act
        room.cleanRoom();

        // Assert
        assertTrue("Room should remain dirty when occupied", room.isDirty());
    }

    @Test
    public void testCleanRoom_RoomNotDirty() {
        // Arrange
        // Room is clean by default

        // Act
        room.cleanRoom();

        // Assert
        assertFalse("Room should not be dirty", room.isDirty());
    }
}
