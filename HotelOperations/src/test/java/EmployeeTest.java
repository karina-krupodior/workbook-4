import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() {
        employee = new Employee("E001", "Alice", "IT", 25.0, 0.0);
    }

    @Test
    public void testPunchInAndOut_CorrectHoursCalculated() {
        // Arrange
        double startTime = 9.0;
        double endTime = 17.0;

        // Act
        employee.punchIn(startTime);
        employee.punchOut(endTime);

        // Assert
        assertEquals(8.0, employee.getRegularHours(), 0.001);
        assertEquals(0.0, employee.getOvertimeHours(), 0.001);
    }

    @Test
    public void testPunchOut_AddsOvertime() {
        // Arrange
        employee = new Employee("E002", "Bob", "Sales", 15.0, 39.0);

        // Act
        employee.punchIn(8.0);
        employee.punchOut(11.0); // Adds 3 hours, total = 42

        // Assert
        assertEquals(40.0, employee.getRegularHours(), 0.001);
        assertEquals(2.0, employee.getOvertimeHours(), 0.001);
    }

    @Test
    public void testPunchOut_WithoutPunchIn() {
        // Act
        employee.punchOut(17.0); // Should not crash or add hours

        // Assert
        assertEquals(0.0, employee.getRegularHours(), 0.001);
    }

    @Test
    public void testMultipleShifts() {
        // Act
        employee.punchIn(8.0);
        employee.punchOut(12.0); // 4 hours
        employee.punchIn(13.0);
        employee.punchOut(17.0); // 4 hours

        // Assert
        assertEquals(8.0, employee.getRegularHours(), 0.001);
    }
}
