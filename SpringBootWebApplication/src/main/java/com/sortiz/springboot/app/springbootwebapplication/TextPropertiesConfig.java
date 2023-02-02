package com.sortiz.springboot.app.springbootwebapplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//we can have many properties separated by ,
//para agregar varios properties con varios o muchos textos
//para tal vez tener varios lenguajes - multilenguaje
@Configuration
@PropertySources({
        @PropertySource("classpath:texts.properties")
})
public class TextPropertiesConfig {
}
