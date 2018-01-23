package com.schedule.demo.Controllers;

import com.schedule.demo.Entities.Group_;
import com.schedule.demo.Entities.University;
import com.schedule.demo.Repository.FacultyRepository;
import com.schedule.demo.Repository.GroupRepository;
import com.schedule.demo.Repository.UniversityRepository;
import com.schedule.demo.Services.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    Service1 service;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index() {

        return new ModelAndView("index");
    }

    @GetMapping("/univ")
    public String getUniversities(ModelMap model){
        model.addAttribute("university", service.getUniversities());
        return "univ";
    }



    @GetMapping("/univ/{id}")
    public University getUniversity(@PathVariable int id){
        return service.getUniversity(id);
    }

    @GetMapping("/univ/search_by")
    public Iterable<University> searchPersons(@ModelAttribute(name = "q") String query) {
        return service.universitySearch(query);
    }
    /*
    @GetMapping("/group")
    public Iterable<Group_> searchGroup(@ModelAttribute(name = "q") String query){

        return service.groupSearch(query);
    }
    */
}
