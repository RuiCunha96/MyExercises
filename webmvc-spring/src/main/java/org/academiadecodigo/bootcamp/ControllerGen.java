package org.academiadecodigo.bootcamp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerGen {

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String sayHello(Model model) {


        Customer customer = new Customer();

        customer.setId(1);
        customer.setFirstName("Rui");
        customer.setLastName("Ferrão");
        customer.setEmail("rui.ferrao@academiadecodigo.org");
        customer.setPhone("916668877");


        // Add an attribute to the request
        model.addAttribute("customer", customer);

        // Return the view name
        return "index";

    }

}
