package training;

import java.util.Date;

/**
 * Created by oleksij.onysymchuk@gmail on 13.12.2016.
 */
class PersonalData {
    private Date dateOfBirth;
    private Date startWorkingDate;
    private String fullName;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getStartWorkingDate() {
        return startWorkingDate;
    }

    public void setStartWorkingDate(Date startWorkingDate) {
        this.startWorkingDate = startWorkingDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonalData that = (PersonalData) o;

        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (startWorkingDate != null ? !startWorkingDate.equals(that.startWorkingDate) : that.startWorkingDate != null)
            return false;
        return fullName != null ? fullName.equals(that.fullName) : that.fullName == null;

    }

    @Override
    public int hashCode() {
        int result = dateOfBirth != null ? dateOfBirth.hashCode() : 0;
        result = 31 * result + (startWorkingDate != null ? startWorkingDate.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
