package com.sortiz.springboot.app.springbootwebapplication.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//controller que representa la pagina de inicio
//el nombre como convencion nombreController - incluir la palabra controller
//en springs se utilizan las anotaciones o decoradores - para controllers @Controller
//para importar puede utilizar el comando ctrl + space
@Controller
@RequestMapping("/app")
public class IndexController {

    //clase controller contiene metodos - handler - gestionan peticiones http de usuario
    //ejemplo cargar formulario, cargar datos - listados - queries - guardar, insertar, eliminar
    //cada handler representa una pagina web que realiza algo y trabaja con datos de la applicaciones
    //datos se muestran en una vista - en este caso thymeleaf
    //manejan las peticiones del usuario - mostrar una pagina con datos solicitados por el usuario

    //metodo que son string como retorno - vista que va a cargar
    //controlador va a tener uno o varios metodos que manejan una pagina
    // o peticiones http distintas
    //una para listar, mostrar form, para guardar datos, eliminar
    //por tanto retorna el nombre de la lista
    //si retorna el index - debemos que tener el index.html - en templates
   // public String index(){
        //primero se mapea o relaciona el metodo a una ruta url - para que el usuario escriba y se invoque el metodo
        //y se cargue la vista index.html
        //para mapear se utiliza la notacion requestmapping - contiene una ruta url as value
        //por defecto la peticion es de tipo get
        //por tanto, tambien puede ser de otro tipo
        //post - pasar datos a traves de un formulario - enviar datos
        //put  - with api rest
        //delete - with api rest
        //@GetMapping - otra manera de trabajar el requestMapping
        //es el mismo requestMapping pero con el method definido para get


        //@RequestMapping(value = "/index", method = RequestMethod.GET)
        //puede estar mapeado a varias rutas distintas
        //@GetMapping(value = "/index")

    //using @Value to inject values from the properties
        @Value("${indexcontroller.index}")
        private String index;
        @Value("${indexcontroller.test}")
        private String test;
        @Value("${indexcontroller.modelview}")
        private String modelview;
        @GetMapping({"/index", "/", "/home"})
        public String index(Model model){
            model.addAttribute("titulo", "Hello, World, from Spring");
            model.addAttribute("name", index);
            return "index";
        }

        @GetMapping(value = "/test")
        public String test(Map<String, Object> map){
            map.put("title", "test");
            map.put("name", test);
            return "test";
        }

        //instead of model we can use ModelMap o bien un map de java.util
        @GetMapping(value = "/modelview")
        public ModelAndView modelviewTest(ModelAndView mv) {

            mv.addObject("titulo", "model and view test");
            mv.addObject("name", modelview);
            mv.setViewName("modelview");
            return mv;
        }

}
