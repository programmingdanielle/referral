package com.wildwoodim.specialist.models.data;

import com.wildwoodim.specialist.models.Insurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface InsuranceDao extends CrudRepository<Insurance, Integer> {

}
