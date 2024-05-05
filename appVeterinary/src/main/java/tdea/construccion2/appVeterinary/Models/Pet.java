package tdea.construccion2.appVeterinary.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tdea.construccion2.appVeterinary.Dto.PetDto;

@Entity
@Table(name = "mascota")
public class Pet {

	@Column(name = "nombre")
	private String name;
	@ManyToOne
	@JoinColumn(name = "id_propietario")
	private Person ownerID;
	@Column(name = "edad")
	private int age;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "especie")
	private String species;
	@Column(name = "raza")
	private String breed;
	@Column(name = "caracteristicas")
	private String characteristics;
	@Column(name = "peso")
	private double weight;

	public Pet(PetDto petId) {
		this.name = petId.getFullName();
		this.ownerID = new Person(petId.getOwnerID());
		this.age = petId.getAge();
		this.id = petId.getIdPet();
		this.species = petId.getSpecies();
		this.breed = petId.getBreed();
		this.characteristics = petId.getCharacteristics();
		this.weight = petId.getWeight();
	}

	public Pet() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Person ownerID) {
		this.ownerID = ownerID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
