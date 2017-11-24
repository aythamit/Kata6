
package Modelo;


public class Person {
    int Id;
    String name;
    Character gender;
    String birthdate;
    Float weight;
    String mail;

    public Person(int Id, String name, Character gender, String birthdate, Float weight, String mail) {
        this.Id = Id;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.weight = weight;
        this.mail = mail;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public Float getWeight() {
        return weight;
    }

    public String getMail() {
        return mail;
    }
    
}
