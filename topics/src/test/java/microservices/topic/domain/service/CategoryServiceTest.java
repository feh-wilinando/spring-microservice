package microservices.topic.domain.service;

import microservices.topic.domain.model.category.Category;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class CategoryServiceTest {


    @Test
    public void should_retrieve_all_categories(){
        CategoryService categoryService = new CategoryService(new RestTemplate());
        List<Category> list = categoryService.findAll();


        assertNotNull(list);
        assertEquals(3, list.size());
    }

}