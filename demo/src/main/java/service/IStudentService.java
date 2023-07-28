package service;

import java.util.List;

import model.Student;

public interface IStudentService {
	
	Student addStudent(Student student);
	
	List<Student> getStudents();
	
	Student updateStudent(Student student, Long id);
	
	Student getStudentId(Long id);
	
	void deleteStudent(Long id);
	
	

}
