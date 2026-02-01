package tp.contactssystem.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tp.contactssystem.model.Contact;
import tp.contactssystem.service.ContactService;

import java.util.List;

@Controller
public class IndexController{
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public String init(ModelMap model){
        List<Contact> contact =contactService.listContacts();
        contact.forEach(c -> logger.info(c.toString()));
        model.put("contacts",contact);
        return "index";
    }

    @GetMapping("/add")
    public String showAdd(){
        return "add";
    }

    @PostMapping("/add")
    public String addContact(@ModelAttribute("contactForm") Contact contact){
        logger.info("add contact " + contact);
        contactService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable(value = "id") int id, ModelMap model){
        Contact contact = contactService.getContactById(id);
        logger.info("edit contact " + contact);
        model.put("contact",contact);
        return "edit";
    }

    @PostMapping("/edit")
    public String editContact(@ModelAttribute("contactForm") Contact contact){
        logger.info("edit contact " + contact);
        contactService.saveContact(contact);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable(value = "id") int id){
        contactService.deleteContactById(id);
        return "redirect:/";
    }
}
