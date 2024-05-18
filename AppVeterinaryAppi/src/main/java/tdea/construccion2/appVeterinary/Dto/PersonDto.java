package tdea.construccion2.appVeterinary.Dto;

import tdea.construccion2.appVeterinary.Models.Person;

public class PersonDto {

    private long id;
    private String Name;
    private int age;
    private String role;
    private String userName;
    private String password;

    public PersonDto(long id, String Name, int age, String role, String userName, String password) {
        this.id = id;
        this.Name = Name;
        this.age = age;
        this.role = role;
        this.userName = userName;
        this.password = password;
    }

    public PersonDto(Person person) {
        this.id = person.getId();
        this.Name = person.getName();
        this.age = person.getAge();
        this.role = person.getRole();
        this.userName = person.getUserName();
        this.password = person.getPassword();
    }

    public PersonDto(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public PersonDto(long id, String Name) {
        this.id = id;
        this.Name = Name;
    }
    
    public PersonDto() {
	}

    public PersonDto(String userName) {
        this.userName = userName;
    }
    
    
    public PersonDto(long idOwner){
		this.id = idOwner;
	}

    public PersonDto(long id, String Name, String role, String userName, String password) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
