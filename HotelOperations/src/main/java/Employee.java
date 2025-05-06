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

    public void punchTimeCard(double time) {
        if (!isPunchedIn) {
            startTime = time;
            isPunchedIn = true;
            System.out.println(name + " punched in at " + time);
        } else {
            double endTime = time;
            double workedHours = endTime - startTime;
            hoursWorked += workedHours;
            isPunchedIn = false;
            System.out.println(name + " punched out at " + endTime + ". Worked " + workedHours + " hours.");
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
