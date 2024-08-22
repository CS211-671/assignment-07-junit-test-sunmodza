package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {


    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        Student s1 = new Student("6610401993","sun");
        s1.addScore(30);
        assertEquals(30, s1.getScore());

        s1.addScore(15.15);
        assertEquals(45.15, s1.getScore());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ Object User")
    void testChangeName(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.changeName("TEE");
        assertEquals("TEE", s.getName());
    }


    @Test
    @DisplayName("Student.isId should be True if id is valid")
    void testIsId() {
        Student s = new Student("6610401993", "StudentTest");
        assertTrue(s.isId("6610401993"));
    }


    @Test
    @DisplayName("Student.toString should return id name and score in correct format")
    void testToString() {
        Student s = new Student("6610401993", "StudentTest");
        assertEquals("{id: '6610401993', name: 'StudentTest', score: 0.0}", s.toString());
    }
}