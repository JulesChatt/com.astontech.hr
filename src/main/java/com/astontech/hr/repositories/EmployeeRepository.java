package com.astontech.hr.repositories;

import com.astontech.hr.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Julian.Chatterton on 4/18/2017.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
