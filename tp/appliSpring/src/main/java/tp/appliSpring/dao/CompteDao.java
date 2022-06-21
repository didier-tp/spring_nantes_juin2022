package tp.appliSpring.dao;

import java.util.List;
import java.util.Optional;

import tp.appliSpring.entity.Compte;

public interface CompteDao /* extends CrudRepository<Compte,Long> */{
	
	Optional<Compte> findById(Long numero);
	void deleteById(Long numero);
	Compte save(Compte compte); //au sens saveOrUpdate() et quelquesfois auto_incr
	List<Compte> findAll();
	//...
	 
}
