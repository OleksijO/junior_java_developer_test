package training;

import java.util.List;

/**
 * Created by oleksij.onysymchuk@gmail on 13.12.2016.
 */
public interface Manager extends Employee{
    List<Worker> getWorkers();

    boolean assignWorker(Worker worker);

    boolean unsignWorker(Worker worker);

    int getMaxWorkerNumber();

    void setMaxWorkerNumber(int maxWorkerNumber);

}
