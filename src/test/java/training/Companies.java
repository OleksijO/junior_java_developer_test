package training;

import java.util.ArrayList;
import java.util.List;

import static training.Position.MANAGER;
import static training.Position.OTHER;
import static training.Position.WORKER;

/**
 * Created by oleksij.onysymchuk@gmail on 13.12.2016.
 */
public enum Companies {
    COMPANY;


    List<Employee> employees = new ArrayList<>();

    Companies() {
        Worker worker1 = new EmployeeImpl(PersonalDatas.W1.personalData);
        worker1.setPosition(WORKER);
        employees.add(worker1);
        Worker worker2 = new EmployeeImpl(PersonalDatas.W2.personalData);
        worker2.setPosition(WORKER);
        employees.add(worker2);
        Worker worker3 = new EmployeeImpl(PersonalDatas.W3.personalData);
        worker3.setPosition(WORKER);
        employees.add(worker3);
        Worker worker4 = new EmployeeImpl(PersonalDatas.W4.personalData);
        worker4.setPosition(WORKER);
        employees.add(worker4);
        Worker worker5 = new EmployeeImpl(PersonalDatas.W5.personalData);
        worker5.setPosition(WORKER);
        employees.add(worker5);

        ((Manager) worker2).assignWorker(worker4);
        ((Manager) worker2).assignWorker(worker5);

        Manager manager1 =  new EmployeeImpl(PersonalDatas.M1.personalData);
        manager1.setPosition(MANAGER);
        manager1.setMaxWorkerNumber(2);
        manager1.assignWorker(worker1);
        manager1.assignWorker(worker2);
        employees.add(manager1);

        Manager manager2 =  new EmployeeImpl(PersonalDatas.M2.personalData);
        manager2.setPosition(MANAGER);
        manager2.setMaxWorkerNumber(2);
        manager2.assignWorker(worker3);
        manager2.assignWorker(worker4);
        employees.add(manager2);

        Manager manager3 =  new EmployeeImpl(PersonalDatas.M3.personalData);
        manager3.setPosition(MANAGER);
        manager3.setMaxWorkerNumber(2);
        manager3.assignWorker(worker5);
        employees.add(manager3);

        Manager manager4 =  new EmployeeImpl(PersonalDatas.O1.personalData);
        manager4.setMaxWorkerNumber(2);
        manager4.assignWorker(worker1);
        manager4.assignWorker(worker3);
        manager4.setPosition(OTHER);
        ((Other) manager4).setDescription("Переведен из менеджеров в Замдиректоры");
        employees.add(manager4);

        Other other2 = new EmployeeImpl(PersonalDatas.O2.personalData);
        other2.setDescription("Работает секретарем постоянно");
        other2.setPosition(OTHER);
        employees.add(other2);

        Other other3 = new EmployeeImpl(PersonalDatas.O3.personalData);
        ((Manager) other3).setMaxWorkerNumber(5);
        ((Manager) other3).assignWorker(worker2);
        other3.setPosition(OTHER);
        other3.setDescription("Работал рабочим и менеджером. Теперь Директор");
        employees.add(other3);
    }
}
