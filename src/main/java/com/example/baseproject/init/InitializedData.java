package com.example.baseproject.init;

import com.example.baseproject.entity.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializedData implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        Course mathCourse = new Course();
        mathCourse.setCourseName("Mathematics");
        mathCourse.setCourseCode("MATH2401");

        Course eeeCourse = new Course();
        eeeCourse.setCourseName("Electronics");
        eeeCourse.setCourseCode("EEE3301");

        Course cseCourse = new Course();
        mathCourse.setCourseName("Software");
        mathCourse.setCourseCode("CSE4401");
    }
}
