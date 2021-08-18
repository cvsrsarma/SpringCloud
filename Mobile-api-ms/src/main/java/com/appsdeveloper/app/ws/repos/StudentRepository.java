package com.appsdeveloper.app.ws.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appsdeveloper.app.ws.entity.Address;
import com.appsdeveloper.app.ws.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	public List<Student> findByFirstNameOrLastName(String firstName, String lastName);

	public List<Student> findByFirstNameIn(List<String>firstNames );
	
	@Query(" from Student where firstName=:firstname")
	public List<Student> findByFName(@Param("firstname") String firstname);
	
	public List<Student> findByAddressCity(String city);

}
