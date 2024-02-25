package com.example.esdproject82.service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements ApplicationRunner {

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional

    public void run(ApplicationArguments args) {
        try {
            String updateQuery = "UPDATE student SET total_credits = (SELECT COALESCE(SUM(c.credits), 0) FROM student_courses sc JOIN course c ON sc.course_id = c.course_id WHERE sc.student_id = student.student_id)";
            Query query = entityManager.createNativeQuery(updateQuery);
            query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
        }
    }

}
