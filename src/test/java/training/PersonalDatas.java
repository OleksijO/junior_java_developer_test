package training;

/**
 * Created by oleksij.onysymchuk@gmail on 13.12.2016.
 */
public enum PersonalDatas {
    W1("Рабочий 1"),
    W2("Рабочий 2"),
    W3("Рабочий 3"),
    W4("Рабочий 4"),
    W5("Рабочий 5"),
    M1("Менеджер 1"),
    M2("Менеджер 2"),
    M3("Менеджер 3"),
    O1("Зам директора"),
    O2("Секретарь"),
    O3("Директор");


    PersonalData personalData;

    PersonalDatas(String name) {
        PersonalData personalData = new PersonalData();
        personalData.setFullName(name);
        this.personalData = personalData;
    }
}
