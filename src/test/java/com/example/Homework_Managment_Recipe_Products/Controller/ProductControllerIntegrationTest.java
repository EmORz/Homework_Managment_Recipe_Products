package com.example.Homework_Managment_Recipe_Products.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnListProducts() throws Exception {
        try {
            this.mockMvc.perform(get("/product"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("<h1>Списък с продукти</h1>")));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    @Test
    void shouldReturnCreatProductForm(){
        try {
            this.mockMvc.perform(get("/product/create"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("<h1>Създаване на продукт</h1>")))
                    .andExpect(content().string(containsString("<label for=\"name\">Име:</label>")))
                    .andExpect(content().string(containsString("<label for=\"categoryProducts\">Категория:</label>")))
                    .andExpect(content().string(containsString("<button type=\"submit\">Създаване</button>")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void mustShowUpdateProductForm(){
        try {
            this.mockMvc.perform(get("/product/update/1"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("<input type=\"hidden\" id=\"id\" name=\"id\" value=\"1\" />")))
                    .andExpect(content().string(containsString("<label for=\"name\">Име:</label>")))
                    .andExpect(content().string(containsString("<label for=\"categoryProducts\">Категория:</label>")))
                    .andExpect(content().string(containsString("<button type=\"submit\">Обновяване</button>")));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



}
