import java.util.ArrayList;
import java.util.Scanner;

class TeamMember {

    int employeeId;
    String name;

    TeamMember(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }
}

class WorkTask {

    int taskId;
    String title;
    int assignedEmployeeId = -1;

    WorkTask(int taskId, String title) {
        this.taskId = taskId;
        this.title = title;
    }
}

class AssignmentManager {

    ArrayList<TeamMember> employees = new ArrayList<>();
    ArrayList<WorkTask> tasks = new ArrayList<>();

    void addEmployee(int id, String name) {
        employees.add(new TeamMember(id, name));
        System.out.println("Employee added!");
    }

    void addTask(int id, String title) {
        tasks.add(new WorkTask(id, title));
        System.out.println("Task added!");
    }

    void assignTask(int taskId, int employeeId) {

        WorkTask task = null;
        TeamMember employee = null;

        for (WorkTask t : tasks) {
            if (t.taskId == taskId) {
                task = t;
                break;
            }
        }

        for (TeamMember e : employees) {
            if (e.employeeId == employeeId) {
                employee = e;
                break;
            }
        }

        if (task == null) {
            System.out.println("Task not found!");
            return;
        }

        if (employee == null) {
            System.out.println("Employee not found!");
            return;
        }

        task.assignedEmployeeId = employeeId;

        System.out.println("Task assigned successfully!");
        System.out.println(task.title + " assigned to " + employee.name);
    }

    void viewAssignments() {

        for (WorkTask t : tasks) {

            System.out.println("Task ID: " + t.taskId);
            System.out.println("Task: " + t.title);

            if (t.assignedEmployeeId == -1) {
                System.out.println("Not Assigned");
            } else {

                for (TeamMember e : employees) {
                    if (e.employeeId == t.assignedEmployeeId) {
                        System.out.println("Assigned To: " + e.name);
                        break;
                    }
                }
            }

            System.out.println("----------------");
        }
    }
}

public class VijayMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AssignmentManager manager = new AssignmentManager();

        while (true) {

            System.out.println("\n--- VIJAY TASK ASSIGNMENT ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Add Task");
            System.out.println("3. Assign Task");
            System.out.println("4. View Assignments");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Employee ID: ");
                    int eid = Integer.parseInt(sc.nextLine());

                    System.out.print("Employee Name: ");
                    String name = sc.nextLine();

                    manager.addEmployee(eid, name);
                    break;

                case 2:
                    System.out.print("Task ID: ");
                    int tid = Integer.parseInt(sc.nextLine());

                    System.out.print("Task Title: ");
                    String title = sc.nextLine();

                    manager.addTask(tid, title);
                    break;

                case 3:
                    System.out.print("Task ID: ");
                    tid = Integer.parseInt(sc.nextLine());

                    System.out.print("Employee ID: ");
                    eid = Integer.parseInt(sc.nextLine());

                    manager.assignTask(tid, eid);
                    break;

                case 4:
                    manager.viewAssignments();
                    break;

                case 5:
                    System.out.println("Vijay module completed!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}