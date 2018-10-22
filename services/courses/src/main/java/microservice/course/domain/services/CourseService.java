package microservice.course.domain.services;

import microservice.course.application.dtos.CourseOutput;
import microservice.course.domain.dtos.Category;
import microservice.course.domain.models.Course;
import microservice.course.domain.repositories.Courses;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final Courses courses;
    private final CategoryService categoryService;



    public CourseService(Courses courses, CategoryService categoryService) {
        this.courses = courses;
        this.categoryService = categoryService;
    }

    public List<CourseOutput> listAll() {
        return courses.findAll()
                .stream()
                    .map(this::toCourseOutput)
                        .collect(Collectors.toList());
    }

    public Optional<CourseOutput> loadBy(Long id) {
        return courses
                .findById(id)
                    .map(this::toCourseOutput);
    }

    private CourseOutput toCourseOutput(Course course) {

        Category category = categoryService.loadBy(course);

        return new CourseOutput(course, category);
    }
}
