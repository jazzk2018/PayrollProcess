import java.text.DecimalFormat; 

public class Employee {
    private Profile profile;
    private double payment;

    public Employee(Profile profile){
        this.profile = profile;
        this.payment = 0;
    }

    public void calculatePayment(){ }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("$#,##0.00");
        return this.profile.toString() + "::Payment " + df.format(this.payment);
    }

    @Override
    public boolean equals(Object obj) {
        Employee number1 = this;
        Employee number2 = (Employee) obj;

        boolean isEqual = number1.profile.equals(number2.profile);
        return isEqual;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getFormattedPayment() {
        DecimalFormat df = new DecimalFormat("##0.00");
        return df.format(payment);
    }

    public void setPayment(double payment){
        this.payment = payment;
    }

    public boolean compareDates(Employee employee) {
        Date date1 = this.getProfile().getDateHired();
        Date date2 = employee.getProfile().getDateHired();

        if (date1.getYear() < date2.getYear()) {
            return true;
        } else {
            if (date1.getYear() == date2.getYear()) {
                if (date1.getMonth() < date2.getMonth()) {
                    return true;
                } else {
                    if (date1.getMonth() == date2.getMonth()) {
                        return date1.getDay() < date2.getDay();
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
    }


}
