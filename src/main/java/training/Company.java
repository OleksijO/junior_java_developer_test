package training;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static training.Position.MANAGER;
import static training.Position.WORKER;

/**
 * Created by oleksij.onysymchuk@gmail on 13.12.2016.
 */
public class Company {
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public void changePosition(Employee employee, Position toPosition) {
        checkArgs(employee, toPosition);
        if (employee.getPosition() == toPosition) {
            System.out.println("Position of employee can not be changed to the same");
            return;
        }
        if (employee.getPosition() == MANAGER) {
            assignManagerToPosition(employee, toPosition);
            return;
        }
        if (employee.getPosition() == WORKER) {
            unassignFromAnyEvenFormerManager((Worker) employee);
            return;
        }
        if (toPosition == MANAGER) {
            unassignFormerWorkersFromOtherManagers((Manager) employee);
            employee.setPosition(toPosition);
        }
    }

    private void unassignFromAnyEvenFormerManager(Worker worker) {
        employees.forEach(employee -> {
            Manager manager = (Manager) employee;
            manager.unsignWorker(worker);
        });
    }

    private boolean assignManagerToPosition(Employee employee, Position toPosition) {
        Manager manager = (Manager) employee;
        List<Worker> workers = manager.getWorkers();
        int workerQuantityToReassign = workers.size();
        if (workerQuantityToReassign != 0) {
            int totalNumberOfFreePlacesForWorkers =
                    countFreePlacesForWorkers() - (manager.getMaxWorkerNumber()-workers.size());
            if ((totalNumberOfFreePlacesForWorkers - workers.size()) < 0) {
                throw new RuntimeException("Can not move workers for another managers. Position did not changed.");
            } else {
                employee.setPosition(toPosition);
                reassignWorkersToOtherManagers(workers);
                return true;
            }
        }
        employee.setPosition(toPosition);
        return false;
    }

    private void unassignFormerWorkersFromOtherManagers(Manager employee) {
        List<Worker> workers = employee.getWorkers();
        unassignWorkersFromOtherManagers(workers);
    }

    private void reassignWorkersToOtherManagers(List<Worker> workers) {
        int index[] = new int[1];
        employees.forEach(employee -> {
            if (employee.getPosition() == MANAGER) {
                Manager manager = (Manager) employee;
                boolean added;
                do {
                    added = manager.assignWorker(workers.get(index[0]));
                    if (added) {
                        index[0]++;
                    }
                } while ((added) && (index[0] < workers.size()));
            }
        });

    }

    private void unassignWorkersFromOtherManagers(List<Worker> workers) {
        employees.forEach(employee -> {
            if (employee.getPosition() == MANAGER) {
                Manager manager = (Manager) employee;
                manager.getWorkers().removeAll(workers);
            }
        });
    }

    private int countFreePlacesForWorkers() {
        int[] totalFreePlaceCount = new int[1];
        employees.forEach(employee -> {
            if (employee.getPosition() == MANAGER) {
                Manager manager = (Manager) employee;
                totalFreePlaceCount[0] += manager.getMaxWorkerNumber() - manager.getWorkers().size();
            }
        });
        return totalFreePlaceCount[0];

    }

    private void checkArgs(Employee employee, Position toPosition) {
        Objects.requireNonNull(employee);
        Objects.requireNonNull(toPosition);
    }

}
