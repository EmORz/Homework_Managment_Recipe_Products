package com.example.Homework_Managment_Recipe_Products.Controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldReturnCreateRecipeForm(){
        try{
            this.mockMvc.perform(get("/recipe/create"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string(containsString("<title>Create recipe</title>")))
                    .andExpect(content().string(containsString("<label for=\"name\">Име:</label>")))
                    .andExpect(content().string(containsString("<label for=\"categoryRecipe\">Категория:</label>")))
                    .andExpect(content().string(containsString("<option value=\"SALAD\">SALAD</option>")))
                    .andExpect(content().string(containsString("<option value=\"SOUP\">SOUP</option>")))
                    .andExpect(content().string(containsString("<option value=\"MAIN\">MAIN</option>")))
                    .andExpect(content().string(containsString("<option value=\"DESSERT\">DESSERT</option>")))
                    .andExpect(content().string(containsString("<button type=\"submit\">Създаване</button>")))
                    .andExpect(content().string(containsString("<h1>Създаване на рецепта</h1>")));

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
