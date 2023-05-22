package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "Personnel")

//todo : mistake2 -> learn nameQuery in jpa

@NamedQueries({
        @NamedQuery(name = "findAllPersonnel", query = "select personnel from Personnel personnel"),
        @NamedQuery(name = "findPersonnelByID", query = "select personnel from Personnel  personnel where personnel.personalID=:personalID")
})


public class Personnel {
    @Id
    private int personalID;
    private String firstName;
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Personal")
    @Column(name = "personalID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
    public int getPersonalID() {
        return personalID;
    }

    public void setPersonalID(int personalNumber) {
        this.personalID = personalNumber;
    }

    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Personnel{" +
                "personalID=" + personalID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}' +
                '\n';
    }
}

