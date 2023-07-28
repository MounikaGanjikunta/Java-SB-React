package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.StudentNotFoundException;
import exception.studentAlreadyExistsException;
import model.Student;
import repository.StudentRepository;

@Service
public class StudentService implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		
		if(studentAlreadyExists(student.getEmail())) {
			throw new studentAlreadyExistsException(student.getEmail() + " already exists!");
		}
		
		return studentRepository.save(student);
	}


	@Override
	public Student updateStudent(Student student, Long id) {
		
		return studentRepository.findById(id).map(st -> {
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setDepartment(student.getDepartment());
			return studentRepository.save(st);
		}).orElseThrow(() -> new StudentNotFoundException("Sorry, this user is not found"));
	}

	@Override
	public Student getStudentId(Long id) {
	
		return studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Sorry,Student not found with this ID" + id));
	}

	@Override
	public void deleteStudent(Long id) {
		
		if(!studentRepository.existsById(id)) {
			throw new StudentNotFoundException("Sorry, this student doesn't exist to be deleted");
		}
		else {
			studentRepository.deleteById(id);
		}
		
		
	}
	
	private boolean studentAlreadyExists(String email) {
		// TODO Auto-generated method stub
		
		return studentRepository.findByEmail(email).isPresent();
	}

}
