package training;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksij.onysymchuk@gmail on 13.12.2016.
 */
class EmployeeImpl implements Employee, Worker, Manager, Other {
    private PersonalData personalData;

    private Position position;

    private List<Worker> workers = new ArrayList<>();
    private int maxWorkerNumber;
    private String description;

    public EmployeeImpl(PersonalData personalData) {
        this.personalData = personalData;
    }

    @Override
    public List<Worker> getWorkers() {
        return workers;
    }

    @Override
    public boolean assignWorker(Worker worker) {
        if (maxWorkerNumber > workers.size()) {
            workers.add(worker);
            return true;
        }
        return false;
    }

    @Override
    public boolean unsignWorker(Worker worker) {
        return workers.remove(worker);
    }

    @Override
    public int getMaxWorkerNumber() {
        return maxWorkerNumber;
    }

    @Override
    public void setMaxWorkerNumber(int maxWorkerNumber) {
        this.maxWorkerNumber = maxWorkerNumber;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public PersonalData getPersonalData() {
        return personalData;
    }

    @Override
    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    @Override
    public String getDescription() {
        if (description == null) {
            return "";
        }
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeImpl employee = (EmployeeImpl) o;

        if (personalData != null ? !personalData.equals(employee.personalData) : employee.personalData != null)
            return false;
        return position == employee.position;

    }

    @Override
    public int hashCode() {
        int result = personalData != null ? personalData.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeImpl{" +
                "personalData=" + personalData +
                ", position=" + position +
                ", workers=" + workers +
                ", maxWorkerNumber=" + maxWorkerNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
