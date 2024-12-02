package pe.edu.cibertec.web_backoffice_lym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @GetMapping("/start")
    public String start(Model model) {
        model.addAttribute("message", "Hello World!!");
        return "maintenance";

    }

}
