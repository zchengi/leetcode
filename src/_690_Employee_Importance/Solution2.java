package _690_Employee_Importance;

import java.util.*;

/**
 * LeetCode 690. Employee Importance
 *
 * @author cheng
 *         2018/11/6 11:49
 */
public class Solution2 {

    public int getImportance(List<Employee> employees, int id) {

        if (employees == null || employees.size() == 0) {
            return 0;
        }

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        return dfs(map, id, new HashSet<>());
    }

    private int dfs(Map<Integer, Employee> map, int id, Set<Integer> visited) {

        if (!visited.add(id)) {
            return 0;
        }

        int res = map.get(id).importance;
        for (Integer subId : map.get(id).subordinates) {
            res += dfs(map, subId, visited);
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
        System.out.println(new Solution2().getImportance(employees, id));
    }
}

