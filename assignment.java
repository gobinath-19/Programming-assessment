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

        // Parse this list into a clean structure such as a list of dictionaries:
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
        Map<String, List<Integer>> departmentSalaries = new HashMap<>();

        for (Map<String, String> emp : employees) {
            String dept = emp.get("Department");
            int salary = Integer.parseInt(emp.get("Salary"));

            departmentSalaries
                .computeIfAbsent(dept, k -> new ArrayList<>())
                .add(salary);
        }

        // Average salary for each department
        List<Map<String, Object>> stats = new ArrayList<>();

        for (String dept : departmentSalaries.keySet()) {
            List<Integer> salaries = departmentSalaries.get(dept);
            int total = 0;
            for (int sal : salaries) total += sal;
            int avg = total / salaries.size();

            Map<String, Object> deptInfo = new HashMap<>();
            deptInfo.put("Department", dept);
            deptInfo.put("Employees", salaries.size());
            deptInfo.put("Average", avg);

            stats.add(deptInfo);
        }

        // Output
        for (Map<String, Object> stat : stats) {
            System.out.println("Department: " + stat.get("Department"));
            System.out.println("Employees: " + stat.get("Employees"));
            System.out.println("Average Salary: " + stat.get("Average"));
            System.out.println();
        }
    }
}             