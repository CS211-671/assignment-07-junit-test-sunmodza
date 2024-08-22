package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList studentList;
    @BeforeEach // add three student
    void setUp() {
        studentList = new StudentList();
        studentList.addNewStudent("6610401993","sun");
        studentList.addNewStudent("6610401992","keam");
        studentList.addNewStudent("6610401991","tee");
    }


    @Test
    @DisplayName("Should be able to add new student")
    void testAddNewStudent() {
        studentList.addNewStudent("6610401888","susan");
        // we should be able to find susan
        Student target = studentList.findStudentById("6610401888");
        assertNotNull(target);
    }

    @Test
    @DisplayName("Be able to find student by id")
    void testFindStudentById() {
        Student target = studentList.findStudentById("6610401993");
        // his name should be sun
        assertEquals("sun", target.getName());
    }

    @Test
    @DisplayName("Should be able to add score in student in list")
    void testGiveScoreToId() {
        // try give score to sun by 70
        studentList.giveScoreToId("6610401993",70);
        // retrieve sun Object
        Student target = studentList.findStudentById("6610401993");
        // his score should be 70
        assertEquals(70,target.getScore());
    }

    @Test
    @DisplayName("Grade calculated correctly in studentList")
    void testViewGradeOfId() {
        // give sun score 85.13 then his grade should be A
        studentList.giveScoreToId("6610401993",85.13);
        assertEquals("A",studentList.findStudentById("6610401993").grade());

        studentList.giveScoreToId("6610401991",40.23);
        assertEquals("F",studentList.findStudentById("6610401991").grade());

        studentList.giveScoreToId("6610401992",70);
        assertEquals("B",studentList.findStudentById("6610401992").grade());
    }
}