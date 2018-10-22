package microservice.course.application.dtos;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import microservice.course.domain.dtos.Category;
import microservice.course.domain.models.Course;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class CourseOutput {

    private Course course;
    private Category category;

    public CourseOutput(Course course, Category category) {
        this.course = course;
        this.category = category;
    }

    public Long getId() {
        return course.getId();
    }

    public String getName() {
        return course.getName();
    }

    public String getCategory(){
        return category.getName();
    }
}
