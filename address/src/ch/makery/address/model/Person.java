package ch.makery.address.model;

import javafx.beans.property.*;
import java.time.LocalDate;

/**
 * Created by Gabirel on 8/6/16.
 * Model Class for People
 */
public class Person {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;

    //Default constructor
    public Person() {
        this(null, null);
    }


    //Constructor with some initial data
    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        //Some initial dummy data, just for testing
        this.street = new SimpleStringProperty("Some street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("Some city");
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1992, 2, 21));
    }


    //First Name
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    //Last Name
    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName){
       this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty(){
        return lastName;
    }

    //Street
    public String getStreet(){
        return street.get();
    }

    public void setStreet(String street){
        this.street.set(street);
    }

    public StringProperty stringProperty(){
        return street;
    }

    //Postal Code
    public int getPostalCode(){
        return postalCode.get();
    }

    public void setPostalCode(int postalCode){
        this.postalCode.set(postalCode);
    }

    public IntegerProperty postalCodeProperty(){
        return postalCode;
    }

    //City
    public String getCity(){
        return city.get();
    }

    public void setCity(String city){
        this.city.set(city);
    }

    public StringProperty cityProperty(){
        return city;
    }


    //Birthday
    public LocalDate getBirthday(){
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday){
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty(){
        return birthday;
    }

}
