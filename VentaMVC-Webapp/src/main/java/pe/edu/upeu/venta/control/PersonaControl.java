/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.venta.control;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.upeu.venta.modelo.Persona;
import pe.edu.upeu.venta.modelo.Venta;
import pe.edu.upeu.venta.servicio.PersonaServicioI;

/**
 *
 * @author hernan carbajal
 */
@Controller
public class PersonaControl {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    PersonaServicioI personaServicioI;
    @Autowired
    PersonaServicioI ventaServicioI;
    
    @RequestMapping(value = "/locate", method = RequestMethod.GET)
    public String getLocatePage(){
    return "my-locale";
    }
    
    
@RequestMapping(value = {"/" }, method = RequestMethod.GET)    
public ModelAndView inicio(Locale locale, Map<String,Object> model){
    String welcome=messageSource.getMessage("welcome.message", new Object[]{"Hernan Carbajal"}, locale);
    List<Persona> lista=personaServicioI.listarEntidad();
    model.put("ListaPersona", lista);
    model.put("message", welcome);
    model.put("startMeeting", "09:10");
    
    return new ModelAndView("persona/mainPersona");
}


@RequestMapping(value = {"/pru1" }, method = RequestMethod.GET)    
public ModelAndView inicioUno(){
    
    return new ModelAndView("prueba2");
}
@RequestMapping(value = {"/pru2" }, method = RequestMethod.GET)    
public ModelAndView inicioDos(){
    
    return new ModelAndView("Prueba3");
}

@RequestMapping(value = {"/pers" }, method = RequestMethod.GET)    
public ModelAndView mainPersona(){    
    return new ModelAndView("persona/mainPersona");
}
@RequestMapping(value = {"/report" }, method = RequestMethod.GET)    
public ModelAndView mainPersonaReport(){    
    return new ModelAndView("persona/reporte/reportePersona");
}
    
}

