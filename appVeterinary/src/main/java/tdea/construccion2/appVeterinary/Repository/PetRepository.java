package tdea.construccion2.appVeterinary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdea.construccion2.appVeterinary.Dto.PetDto;
import tdea.construccion2.appVeterinary.Models.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
	
	public Pet findById(long idpet) throws Exception;

	public boolean existsById(long idPet) throws Exception;

}
