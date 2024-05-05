package tdea.construccion2.appVeterinary.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.appVeterinary.Dto.PersonDto;
import tdea.construccion2.appVeterinary.Models.Person;
import tdea.construccion2.appVeterinary.Repository.PersonRepository;

@Service
public class PersonDaoImp implements PersonDao {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public PersonDto findUserByUserName(PersonDto personDto) throws Exception {

		Person person = personRepository.findByUserName(personDto.getUserName());
		if (person == null) {
			return null;
		}
		return new PersonDto(person);
	}

	@Override
	public void createPerson(PersonDto personDto) throws Exception {
		Person person = new Person(personDto);
		personRepository.save(person);

	}

	@Override
	public boolean findUserExistById(PersonDto personDto) throws Exception {

		return  personRepository.existsById(personDto.getId());
	}

	@Override
	public boolean findExistingUserByUserName(PersonDto personDto) throws Exception {
		
		return personRepository.existsByUserName(personDto.getUserName());
	
	}

	@Override
	public PersonDto findUserById(PersonDto personId) throws Exception {

		Person person = personRepository.findById(personId.getId());
		if (person == null) {
			return null;
		}
		return new PersonDto(person);

	}

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

}
