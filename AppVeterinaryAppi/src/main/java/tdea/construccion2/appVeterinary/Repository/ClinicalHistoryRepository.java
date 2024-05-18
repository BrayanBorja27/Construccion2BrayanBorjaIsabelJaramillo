package tdea.construccion2.appVeterinary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tdea.construccion2.appVeterinary.Models.ClinicalHistory;

public interface ClinicalHistoryRepository extends JpaRepository<ClinicalHistory, Long> {

	public ClinicalHistory findById(long clinicalHistory) throws Exception;
	
	//Metodo findByOrder no es nativo de Jpa por lo que se indica la Query
	@Query(value="select * from historia where orden = :orderId", nativeQuery= true)
	public ClinicalHistory findByOrder(long orderId) throws Exception;

}
