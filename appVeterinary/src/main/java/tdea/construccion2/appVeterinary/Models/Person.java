package tdea.construccion2.appVeterinary.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import tdea.construccion2.appVeterinary.Dto.PersonDto;
@Entity
@Table(name="persona")
 public class Person{
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cedula") 
    private long id;
	@Column(name="nombre") 
    private String name;
	@Column(name="edad") 
    private int age;
    @Column(name="role") 
    private String role;
    @Column(name="username") 
    private String userName;
    @Column(name="password") 
    private String password;
    
  
    public Person(long id, String name, int age, String role, String userName, String password) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.role = role;
		this.userName = userName;
		this.password = password;
	}

	public Person(PersonDto personDto) {
		this.id = personDto.getId();
		this.name = personDto.getName();
		this.age = personDto.getAge();
		this.role = personDto.getRole();
		this.userName = personDto.getUserName();
		this.password = personDto.getPassword();
	}
    
    public Person() {
    	
    }
 

	public Person(long id) {
		this.id = id;	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
