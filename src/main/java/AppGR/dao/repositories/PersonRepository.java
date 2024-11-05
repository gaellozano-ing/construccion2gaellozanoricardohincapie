
package appGr.dao.repositories;

import appgr.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person,Long> {

    public boolean existsByDocument(Long document);

    public Person findByDocument(long document);

  
    
    
}
