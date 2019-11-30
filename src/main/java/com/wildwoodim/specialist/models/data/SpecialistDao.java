package com.wildwoodim.specialist.models.data;

import com.wildwoodim.specialist.models.Specialist;
import org.jvnet.staxex.BinaryText;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SpecialistDao extends CrudRepository<Specialist, Integer>, JpaSpecificationExecutor {

    public Specialist findBySpecialistName(String specialistName);

    public List<Specialist> findAllByTypeIdAndInsuranceId(Integer typeId, Integer insuranceId);

    public Specialist findByTypeId(int typeId);

    public Specialist findByInsuranceId(int insuranceId);
/*
    @Query(countByTypeIdAndInsuranceId)
    Integer countByTypeIdAndInsuranceId(int typeId, int insuranceId);
    final String countByTypeIdAndInsuranceId = "SELECT COUNT(typeId"*/

}