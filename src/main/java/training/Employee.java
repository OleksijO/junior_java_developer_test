package training;

/**
 * Created by oleksij.onysymchuk@gmail on 13.12.2016.
 */
public interface Employee {

    Position getPosition();

    void setPosition(Position position);

    PersonalData getPersonalData();

    void setPersonalData(PersonalData personalData);
}
