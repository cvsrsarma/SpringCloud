package com.appsdeveloper.app.ws.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.appsdeveloper.app.ws.entity.Address;
import com.appsdeveloper.app.ws.entity.Student;
import com.appsdeveloper.app.ws.entity.Subject;
import com.appsdeveloper.app.ws.model.reqeust.CreateStudent;
import com.appsdeveloper.app.ws.model.reqeust.SubjectRequest;
import com.appsdeveloper.app.ws.model.reqeust.UpdateStudent;
import com.appsdeveloper.app.ws.model.response.StudentRespose;
import com.appsdeveloper.app.ws.model.response.SubjectResponse;
import com.appsdeveloper.app.ws.repos.AddressRepository;
import com.appsdeveloper.app.ws.repos.StudentRepository;
import com.appsdeveloper.app.ws.repos.SubjectRepository;

@Service
public class StudentService {
	
	public static Logger log= LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	@Autowired
	SubjectRepository subRepo;
	
	
	public List<Student> getFindAll() {
		return studentRepo.findAll();
	}
	
	public StudentRespose createStudent(CreateStudent student) {
		Student newStudent = new Student(student);
		
		Address address = new Address(student);
		addressRepo.save(address);
		newStudent.setAddress(address);
		studentRepo.save(newStudent);
		List<Subject> subList = new ArrayList<Subject>();
		List<SubjectRequest> subjectLearing = student.getSubjectLearning();
		if(null!=subjectLearing && subjectLearing.size()>0) {
			subjectLearing.stream().forEach(subject->{
				Subject subjectObj = new Subject(subject, newStudent);
				log.debug(subjectObj.toString());
				subList.add(subjectObj);
			});
		}
		
		
		subRepo.saveAll(subList);
		
		StudentRespose response=  new StudentRespose(newStudent);
		
		List<SubjectResponse> list = new ArrayList<SubjectResponse>();
		subList.stream().forEach(sub->{
			SubjectResponse subresp = new SubjectResponse(sub);
			
			list.add(subresp);
		});
		
		response.setSubList(list);
		
		return response;
	}
	
	public StudentRespose updateStudent(UpdateStudent student) {
		
		Optional<Student> studentInfo= studentRepo.findById(student.getId());
		StudentRespose resp = null;
		if(studentInfo.isPresent()) {
			Student stdent = studentInfo.get();
			if(null!=student.getFirstName() && student.getFirstName().length()>0)
				stdent.setFirstName(student.getFirstName());
			if(null!=student.getLastName() && student.getLastName().length()>0)
				stdent.setLastName(student.getLastName());
			if(null!=student.getEmail() && student.getEmail().length()>0)
				stdent.setEmail(student.getEmail());
			studentRepo.save(stdent);
			resp = new StudentRespose(stdent);
		}
		return resp;
	}

	public void deleteStudent(long id) {
		studentRepo.deleteById(id);
	}

	public List<StudentRespose> getStudentByName(String firstName) {
		List<StudentRespose> resp=new ArrayList<StudentRespose>();		StudentRespose std1 = null;
		List<Student> studentList= studentRepo.findByFirstName(firstName);
		for(Student std: studentList) {
			std1 = new StudentRespose(std);
			resp.add(std1);
		}
		return resp;
	}

	public List<StudentRespose> getStudentByNames(String firstName, String lastName) {
		List<StudentRespose> resp=new ArrayList<StudentRespose>();
		StudentRespose std1 = null;
		List<Student> studentList= studentRepo.findByFirstNameAndLastName(firstName, lastName);
		for(Student std: studentList) {
			std1 = new StudentRespose(std);
			resp.add(std1);
		}
		List<StudentRespose> stdList = getStudentByNameIn(firstName, lastName);
		resp.addAll(stdList);
		return resp;
	}
	public List<StudentRespose> getStudentByNameIn(String firstName1, String firstName2) {
		List<StudentRespose> resp=new ArrayList<StudentRespose>();
		StudentRespose std1 = null;
		List<String> alist = new ArrayList<String>();
		alist.add(firstName2);
		alist.add(firstName1);
		List<Student> studentList1= studentRepo.findByFirstNameIn(alist);
		for(Student std: studentList1) {
			std1 = new StudentRespose(std);
			resp.add(std1);
		}
		return resp;
	}

	public List<StudentRespose> getAllWithPagination(int pageNumber, int pageSize) {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize, sort);
		List<Student> allStudentDetails= studentRepo.findAll(pageable).getContent();
		List<StudentRespose> stdRspns= new ArrayList<StudentRespose>();
		
		allStudentDetails.stream().forEach(student->{
			stdRspns.add(new StudentRespose(student));
		});
		return stdRspns;
	}

	public List<StudentRespose> getStudentByFName(String fName) {
		List<Student> list= studentRepo.findByFName(fName);
		List<StudentRespose> stdList = new ArrayList<StudentRespose>();
		list.stream().forEach(student->{
			stdList.add(new StudentRespose(student));
		});
		
		return stdList;
	}

	public List<StudentRespose> getStudentByCity(String city) {
		List<Student> std = studentRepo.findByAddressCity(city);
		List<StudentRespose> stdResp= new ArrayList<StudentRespose>();
		std.stream().forEach(student->{
			stdResp.add(new StudentRespose(student));
		});
		
		return stdResp;
	}

	public List<StudentRespose> createStudent(@Valid List<CreateStudent> studentList) {
		List<StudentRespose> std = new ArrayList<StudentRespose> ();
		
		studentList.stream().forEach(std1->{
			std.add(createStudent(std1));
		});
		
		return std;
	}

}
