package com.wildwoodim.specialist.models.data;

import com.wildwoodim.specialist.models.forms.Insurance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface InsuranceDao extends CrudRepository<Insurance, Integer> {

}
