package cz.muni.fi.pa165.mvc.controllers;

import cz.fi.muni.pa165.dto.OrderDTO;
import cz.fi.muni.pa165.dto.UserDTO;
import cz.fi.muni.pa165.enums.OrderState;
import cz.fi.muni.pa165.facade.OrderFacade;
import cz.fi.muni.pa165.facade.UserFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    final static Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        Collection<UserDTO> users = userFacade.getAllUsers();

        model.addAttribute("users", users);
        return "user/list";
    }

}
