package tdea.construccion2.appVeterinary.Dao;

import tdea.construccion2.appVeterinary.Dto.PetDto;

public interface PetDao {

	public PetDto findById(long idPet) throws Exception;

	public void createPet(PetDto petDto) throws Exception;

	boolean existsById(long idPet) throws Exception;

}
