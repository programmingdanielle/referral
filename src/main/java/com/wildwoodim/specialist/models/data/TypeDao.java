package com.wildwoodim.specialist.models.data;

import com.wildwoodim.specialist.models.forms.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface TypeDao extends CrudRepository<Type, Integer> {

}
