package tdea.construccion2.appVeterinary.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tdea.construccion2.appVeterinary.Dto.PetDto;
import tdea.construccion2.appVeterinary.Models.Pet;
import tdea.construccion2.appVeterinary.Repository.PetRepository;

@Service
public class PetDaoImp implements PetDao {

	@Autowired
	private PetRepository petRepository;

	public void createPet(PetDto petDto) throws Exception {
		Pet pet = new Pet(petDto);
		petRepository.save(pet);
	}

	@Override
	public PetDto findById(long idPet) throws Exception {
		Pet pet = new Pet();
		pet = petRepository.findById(idPet);
		if (pet == null) {
			return null;
		}
		return new PetDto(pet);
	}

	@Override
	public boolean existsById(long idPet) throws Exception {

		return petRepository.existsById(idPet);

	}

	public PetRepository getPetRepository() {
		return petRepository;
	}

	public void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

}
