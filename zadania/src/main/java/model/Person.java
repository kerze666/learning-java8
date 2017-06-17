package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Bartek on 17.06.2017.
 */
public class Person {
    private String name;
    private String lastname;
    private LocalDate birth;

    public Person(String name, String lastname, LocalDate birth) {
        this.name = name;
        this.lastname = lastname;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
}
