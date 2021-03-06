package com.appsdeveloper.app.ws.uicontroller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloper.app.ws.entity.Student;
import com.appsdeveloper.app.ws.entity.Subject;
import com.appsdeveloper.app.ws.model.reqeust.CreateStudent;
import com.appsdeveloper.app.ws.model.reqeust.UpdateStudent;
import com.appsdeveloper.app.ws.model.response.StudentRespose;
import com.appsdeveloper.app.ws.model.response.SubjectResponse;
import com.appsdeveloper.app.ws.services.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	public static String i="abc";
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<StudentRespose>> getAllStudents(){
		List<Student> allStudentDetails= studentService.getFindAll(); 
		
		List<StudentRespose> stdRspns= new ArrayList<StudentRespose>();
		
		allStudentDetails.stream().forEach(student->{
			List<SubjectResponse> sublist = new ArrayList<SubjectResponse>();
			StudentRespose k = new StudentRespose(student);
			List<Subject> sList = student.getLearningSubjects();
			sList.stream().forEach(s->{
				sublist.add(new SubjectResponse(s));
			});
			
			k.setSubList(sublist);
			
			stdRspns.add(k);
			
		});
		
		return new ResponseEntity<List<StudentRespose>>(stdRspns, HttpStatus.OK);
	}
	
	@PostMapping(consumes =  {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_PROBLEM_JSON_VALUE})
	public ResponseEntity<StudentRespose> create(@Valid @RequestBody CreateStudent student){
		StudentRespose std= studentService.createStudent(student);
		
		return new ResponseEntity<StudentRespose>(std, HttpStatus.OK);
	}
	
	@PutMapping("update")
	public StudentRespose updateStudent(@Valid @RequestBody UpdateStudent student) {
		StudentRespose resp= studentService.updateStudent(student);
		return resp;
		
	}
	
	@DeleteMapping("deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("User id "+id+" deleted", HttpStatus.OK);
	}
	
	@DeleteMapping("deleteusr/{id}")
	public ResponseEntity<String> deleteUserbyId(@PathVariable long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("User id "+id+" deleted", HttpStatus.OK);
	}
	
	@RequestMapping("findbyName")
	public ResponseEntity<List<StudentRespose>> getStudentByName(@RequestHeader String firstName){
		return new ResponseEntity<List<StudentRespose>>(studentService.getStudentByName(firstName), HttpStatus.OK);
	}
	@RequestMapping("findbyNames")
	public ResponseEntity<List<StudentRespose>> getStudentByNames(@RequestHeader String firstName,@RequestParam String lastName){
		System.out.println("First Name "+firstName+" last name"+lastName);
		return new ResponseEntity<List<StudentRespose>>(studentService.getStudentByNames(firstName, lastName), HttpStatus.OK);
	}
	@RequestMapping("findbyNamesOr/{lastName}")
	public ResponseEntity<List<StudentRespose>> getStudentByNameOr(@RequestHeader String firstName,@PathVariable String lastName){
		System.out.println("First Name "+firstName+" last name"+lastName);
		return new ResponseEntity<List<StudentRespose>>(studentService.getStudentByNameIn(firstName, lastName), HttpStatus.OK);
	}
	
	@RequestMapping("getAllWithPagination")
	public ResponseEntity<List<StudentRespose>> getAllWithPagination(@RequestParam int pageNumber, @RequestParam int pageSize){
		System.out.println("Page Number "+pageNumber+" Page Size "+pageSize);
		return new ResponseEntity<List<StudentRespose>>(studentService.getAllWithPagination(pageNumber, pageSize), HttpStatus.OK);
	}
	
	@GetMapping("/getFName")
	public ResponseEntity<List<StudentRespose>> getFName(@RequestParam String fName){
		List<StudentRespose> allStudentDetails= studentService.getStudentByFName(fName);
		
		return new ResponseEntity<List<StudentRespose>>(allStudentDetails, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<List<StudentRespose>> createStudent(@Valid @RequestBody List<CreateStudent> studentList ) {
		List<StudentRespose> std= studentService.createStudent(studentList);
		
		return new ResponseEntity<List<StudentRespose>>(std, HttpStatus.OK);
	}
	
	@GetMapping("/getStudentByCity")
	public ResponseEntity<List<StudentRespose>> getStudentByCity(@RequestParam String city){
		List<StudentRespose> allStudentDetails= studentService.getStudentByCity(city);
		
		return new ResponseEntity<List<StudentRespose>>(allStudentDetails, HttpStatus.OK);
	}
	
	
}
