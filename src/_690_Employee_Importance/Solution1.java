package _690_Employee_Importance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 690. Employee Importance
 *
 * @author cheng
 *         2018/11/6 11:49
 */
public class Solution1 {

    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {

        employees.forEach(employee -> employeeMap.put(employee.id, employee));
        return dfs(id);
    }

    private int dfs(int id) {

        Employee cur = employeeMap.get(id);
        int res = cur.importance;

        for (Integer i : cur.subordinates) {
            res += dfs(i);
        }

        return res;
    }

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        ArrayList<Integer> employee1 = new ArrayList<>();
        employee1.add(2);
        employee1.add(3);
        employees.add(new Employee(1, 5, employee1));

        ArrayList<Integer> employee2 = new ArrayList<>();
        employees.add(new Employee(2, 3, employee2));

        ArrayList<Integer> employee3 = new ArrayList<>();
        employees.add(new Employee(3, 3, employee3));

        int id = 1;
        System.out.println(new Solution1().getImportance(employees, id));
    }
}

