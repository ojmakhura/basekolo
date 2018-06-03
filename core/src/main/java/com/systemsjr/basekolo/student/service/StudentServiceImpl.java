// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: AndroMDAModel::basekolo::com.systemsjr.basekolo::student::service::StudentService
 * STEREOTYPE:  Service
 */
package com.systemsjr.basekolo.student.service;

import java.util.Calendar;
import java.util.Collection;

import org.apache.commons.text.WordUtils;

import com.systemsjr.basekolo.student.Student;
import com.systemsjr.basekolo.student.vo.StudentSearchCriteria;
import com.systemsjr.basekolo.student.vo.StudentVO;

//import org.primefaces.component.calendar.Calendar;

/**
 * @see com.systemsjr.basekolo.student.service.StudentService
 */
public class StudentServiceImpl
    extends StudentServiceBase
{

    /**
     * @see com.systemsjr.basekolo.student.service.StudentService#findById(Long)
     */
    protected  StudentVO handleFindById(Long id)
        throws Exception
    {
    	if(id != null){
    		Student student = getStudentDao().load(id);
    		return getStudentDao().toStudentVO(student);
    	} else{
    		return null;
    	}
    }

    /**
     * @see com.systemsjr.basekolo.student.service.StudentService#saveStudent(StudentVO)
     */
    protected  StudentVO handleSaveStudent(StudentVO studentVO)
        throws Exception
    {
    	studentVO.setFirstName(WordUtils.capitalize(WordUtils.uncapitalize(studentVO.getFirstName())));
    	studentVO.setMiddleNames(WordUtils.capitalize(WordUtils.uncapitalize(studentVO.getMiddleNames())));
    	studentVO.setSurname(WordUtils.capitalize(WordUtils.uncapitalize(studentVO.getSurname())));
    	Student student = getStudentDao().studentVOToEntity(studentVO);
    	if(studentVO.getId() == null){
    		Long studentId = getCounterDao().getNextCount(Student.class.getName(), 9, student.getStudentClass().getYear());
    		student.setStudentId(studentId.toString());
    		student = getStudentDao().create(student);
    	} else{
    		getStudentDao().update(student);
    	}
    	
    	return getStudentDao().toStudentVO(student);
    	
    }

    /**
     * @see com.systemsjr.basekolo.student.service.StudentService#removeStudent(StudentVO)
     */
    protected  void handleRemoveStudent(StudentVO studentVO)
        throws Exception
    {
    	if(studentVO.getId() != null){
    		getStudentDao().remove(studentVO.getId());
    	}
    }

    /**
     * @see com.systemsjr.basekolo.student.service.StudentService#getAllStudents()
     */
    protected  Collection<StudentVO> handleGetAllStudents()
        throws Exception
    {
    	Collection<Student> students = getStudentDao().loadAll();
    	return getStudentDao().toStudentVOCollection(students);
    }

    /**
     * @see com.systemsjr.basekolo.student.service.StudentService#getAllStudentsArray()
     */
    protected  StudentVO[] handleGetAllStudentsArray()
        throws Exception
    {
    	Collection<Student> students = getStudentDao().loadAll();
    	return getStudentDao().toStudentVOArray(students);
    }

    /**
     * @see com.systemsjr.basekolo.student.service.StudentService#studentSearch(StudentSearchCriteria)
     */
    protected  Collection<StudentVO> handleStudentSearch(StudentSearchCriteria searchCriteria)
        throws Exception
    {
    	Collection students = getStudentDao().findByCriteria(searchCriteria);
    	return getStudentDao().toStudentVOCollection(students);
    }

    /**
     * @see com.systemsjr.basekolo.student.service.StudentService#studentSearchArray(StudentSearchCriteria)
     */
    protected  StudentVO[] handleStudentSearchArray(StudentSearchCriteria searchCriteria)
        throws Exception
    {
    	Collection students = getStudentDao().findByCriteria(searchCriteria);
    	return getStudentDao().toStudentVOArray(students);
    }

	@Override
	protected Collection handleFindClassStudents(Long classId) throws Exception {
		Collection students = getStudentDao().findByClass(classId);
    	return getStudentDao().toStudentVOCollection(students);
	}

}