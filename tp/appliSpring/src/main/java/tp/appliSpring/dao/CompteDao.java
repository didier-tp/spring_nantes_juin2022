package tp.appliSpring.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tp.appliSpring.entity.Compte;

//  ou bien public interface CompteDao extends JpaRepository<Compte,Long>{
public interface CompteDao extends CrudRepository<Compte,Long>{
	/*
	//Methodes héritées de CrudRepository<Compte,Long>:
	Optional<Compte> findById(Long numero);
	void deleteById(Long numero);
	Compte save(Compte compte); //au sens saveOrUpdate() et quelquesfois auto_incr
	List<Compte> findAll();
	//...
	 */
	
	List<Compte> findBySoldeLessThan(double soldeMini);
	 
}
