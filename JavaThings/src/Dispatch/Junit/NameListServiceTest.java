package Dispatch.Junit;

import Dispatch.Domain.Employee;
import Dispatch.Service.NameListService;
import Dispatch.Service.TeamException;
import org.junit.Test;

public class NameListServiceTest {
    @Test
    public void testAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getAllEmployees();
        for (int i=0; i<employees.length; i++) {
            System.out.println(employees[i].toString());
        }
    }

    @Test
    public void testGetEmployee() {
        NameListService service = new NameListService();
        int id = 1;

        try {
            Employee employee = service.getEmployee(1);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
