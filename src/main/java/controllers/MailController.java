package controllers;

import entities.Mail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("mail",new Mail());


        return "create";
    }
    @PostMapping("/addMail")
    public String create(@ModelAttribute("mail") Mail mail,Model model){
        model.addAttribute("language", mail.getLanguage());
        model.addAttribute("pageSize", mail.getPageSize());
        if(mail.isSpamFilter()){
            model.addAttribute("isSpamFilter","true");
        }else{
            model.addAttribute("isSpamFilter","false");
        }

        model.addAttribute("signature", mail.getSignature());

        return "info";
    }

}
