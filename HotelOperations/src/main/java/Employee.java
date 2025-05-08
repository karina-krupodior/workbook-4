public class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private boolean isPunchedIn;
    private double startTime;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.isPunchedIn = false;
    }

    public void punchIn(double time) {
        if (!isPunchedIn) {
            startTime = time;
            isPunchedIn = true;
            System.out.println(name + " punched in at " + time);
        } else {
            System.out.println(name + " is already punched in.");
        }
    }

    public void punchOut(double time) {
        if (isPunchedIn) {
            double workedHours = time - startTime;
            hoursWorked += workedHours;
            isPunchedIn = false;
            System.out.println(name + " punched out at " + time + ". Worked " + workedHours + " hours.");
        } else {
            System.out.println(name + " has not punched in.");
        }
    }

    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay() {
        return getRegularHours() * payRate + getOvertimeHours() * payRate * 1.5;
    }
}
