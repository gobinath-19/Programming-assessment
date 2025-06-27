import java.util.*;

public class assignment {

    public static void main(String[] args) {
        String[] data = {
                "101 | Alice Johnson | Sales | 45000",
                "102 | Bob Smith | Finance | 52000",
                "103 | Claire Lee | Sales | 47000",
                "104 | Dave Roy | IT | 50000",
                "105 | Eva Patel | Finance | 55000"
        };

        // Parse data
        List<Map<String, String>> employees = new ArrayList<>();

        for (String record : data) {
            String[] parts = record.split("\\|");
            if (parts.length == 4) {
                Map<String, String> emp = new HashMap<>();
                emp.put("ID", parts[0].trim());
                emp.put("Name", parts[1].trim());
                emp.put("Department", parts[2].trim());
                emp.put("Salary", parts[3].trim());
                employees.add(emp);
            }
        }

        // Number of employees in each department
        Map<String, Integer> departmentCount = new HashMap<>();
        Map<String, Integer> departmentSalarySum = new HashMap<>();

        for (Map<String, String> emp : employees) {
            String dept = emp.get("Department");
            int salary = Integer.parseInt(emp.get("Salary"));

            departmentCount.put(dept, departmentCount.getOrDefault(dept, 0) + 1);
            departmentSalarySum.put(dept, departmentSalarySum.getOrDefault(dept, 0) + salary);
        }
        // Output

        for (String dept : departmentCount.keySet()) {
            int count = departmentCount.get(dept);
            int totalSalary = departmentSalarySum.get(dept);
            int averageSalary = totalSalary / count;

            System.out.println("Department: " + dept);
            System.out.println("Employees: " + count);
            System.out.println("Average Salary: " + averageSalary);
            System.out.println();
        }
    }
}
