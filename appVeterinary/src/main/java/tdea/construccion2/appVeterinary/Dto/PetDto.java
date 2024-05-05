package tdea.construccion2.appVeterinary.Dto;

import tdea.construccion2.appVeterinary.Models.Pet;

public class PetDto {

	private String fullName;
	private PersonDto ownerID;
	private int age;
	private long idPet;
	private String species;
	private String breed;
	private String characteristics;
	private double weight;

	public PetDto() {
	}

	public PetDto(long idPet, PersonDto ownerID, String fullName, int age, double weight, String breed, String species,
			String characteristics) {
		this.idPet = idPet;
		this.ownerID = ownerID;
		this.fullName = fullName;
		this.age = age;
		this.weight = weight;
		this.breed = breed;
		this.species = species;
		this.characteristics = characteristics;

	}

	public PetDto(long pet) {
		this.idPet = pet;
	}

	public PetDto(Pet pet) {
		this.idPet = pet.getId();
		this.ownerID = new PersonDto(pet.getOwnerID());
		this.fullName = pet.getName();
		this.age = pet.getAge();
		this.weight = pet.getWeight();
		this.breed = pet.getBreed();
		this.species = pet.getSpecies();
		this.characteristics = pet.getCharacteristics();
	}
	public PetDto(PetDto petDto) {
		this.idPet = petDto.getIdPet();
		this.ownerID = petDto.getOwnerID();
		this.fullName = petDto.getFullName();
		this.age = petDto.getAge();
		this.weight = petDto.getWeight();
		this.breed = petDto.getBreed();
		this.species = petDto.getSpecies();
		this.characteristics = petDto.getCharacteristics();
	}

	public PersonDto getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(PersonDto ownerID) {
		this.ownerID = ownerID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public long getIdPet() {
		return idPet;
	}

	public void setIdPet(long idPet) {
		this.idPet = idPet;
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
