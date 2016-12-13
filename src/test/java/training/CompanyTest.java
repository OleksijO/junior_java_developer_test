package training;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by oleksij.onysymchuk@gmail on 13.12.2016.
 */
public class CompanyTest {
    Company company = new Company();

    {
        company.setEmployees(Companies.COMPANY.employees);
    }

    // 0-4 Worker, 5-7 Manager, 8 Deputy (former workers 1,3), 9 Secretary, 10 Chief
    // Manager 1 controls Worker 1,2    | MAX=2
    // Manager 2 controls Worker 3,4    | MAX=2
    // Manager 2 controls Worker 5      | MAX=2


    @Test
    public void changePositionFromManagerToOtherWithWorkers() throws Exception {
        List<Employee> employees = company.getEmployees();
        Worker worker1 = (Worker) employees.get(0);
        Worker worker2 = (Worker) employees.get(1);
        Manager manager = (Manager) employees.get(5);
        manager.unsignWorker(worker2);  // so there is a possibility to reassign worker 1 of manager 1 to manager 3
        company.changePosition(manager, Position.OTHER);
        Assert.assertEquals("Worker 1 should be under control of manager 3 now ", worker1, ((Manager) employees.get(7)).getWorkers().get(1));
        company.changePosition(manager, Position.MANAGER);
        Assert.assertEquals("Worker 1 should be under control of manager 1 again ", worker1, ((Manager) employees.get(5)).getWorkers().get(0));
        Assert.assertEquals("Quantity of workers under manager 3 contorl should be again 1 ", 1, ((Manager) employees.get(7)).getWorkers().size());
    }

    @Test
    public void changePositionFromManagerToOtherWithWorkersAndThereIsNoPlaceForWorkers() throws Exception {
        List<Employee> employees = company.getEmployees();
        Manager manager = (Manager) employees.get(5);
        try {
            company.changePosition(manager, Position.OTHER);
            Assert.fail("An Exception should be thrown, cause operation is impossible");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Quantity of workers under manager 1 contol should be same",
                2, ((Manager) employees.get(5)).getWorkers().size());
        Assert.assertEquals("Quantity of workers under manager 2 contol should be same",
                2, ((Manager) employees.get(6)).getWorkers().size());
        Assert.assertEquals("Quantity of workers under manager 3 contol should be same",
                1, ((Manager) employees.get(7)).getWorkers().size());
    }

    @Test
    public void changePositionToManagerFromOtherWithFormerWorkersThatShoudReturn() throws Exception {
        List<Employee> employees = company.getEmployees();
        Other deputy = (Other) employees.get(8);

        company.changePosition(deputy, Position.MANAGER);
        Manager managerAgain = (Manager) deputy;
        Assert.assertEquals("Quantity of workers under manager 1 contol should change",
                1, ((Manager) employees.get(5)).getWorkers().size());
        Assert.assertEquals("Quantity of workers under manager 2 contol should change",
                1, ((Manager) employees.get(6)).getWorkers().size());
        Assert.assertEquals("Quantity of workers under manager 3 contol should be same",
                1, ((Manager) employees.get(7)).getWorkers().size());
        Assert.assertEquals("Quantity of workers under managerAgain contol should be same",
                2, managerAgain.getWorkers().size());
    }

}