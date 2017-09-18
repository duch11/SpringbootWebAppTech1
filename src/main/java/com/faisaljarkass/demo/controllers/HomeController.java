package com.faisaljarkass.demo.controllers;

import com.faisaljarkass.demo.domains.Message;
import com.faisaljarkass.demo.domains.MyUser;
import com.faisaljarkass.demo.repositories.MessageRepository;
import com.faisaljarkass.demo.repositories.MessageRepositoryImpl;
import com.faisaljarkass.demo.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {

    private static Logger logger = Logger.getLogger(HomeController.class.getName());

    private UserService userService;
    private MessageRepositoryImpl messages;

    public HomeController(UserService userService){

        this.userService = userService;
        this.messages = new MessageRepositoryImpl();
    }

    @RequestMapping(value = {"","/","index"}, method = RequestMethod.GET)
    public String index(Model model){
        logger.info("index method called...");

        model.addAttribute("user", new MyUser());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute MyUser user, Model model){
        logger.info("login method called with: " + user);
        user = userService.getUser(user.getUsername(), user.getPassword());
        messages.addMessage(new Message("Thanks for all the tuna!", "Whiff, zebra bullhead shark orbicular batfish atka mackerel orangespine unicorn fish. Temperate perch bull shark luminous hake sand knifefish barracuda dogfish shark hog sucker warmouth tigerperch tetra, porbeagle shark. Garden eel scorpionfish ribbon sawtail fish false moray Indian mul surgeonfish tube-snout yellowtail snapper fathead sculpin!\n" +
                "\n" +
                "Buri Mexican golden trout eelblenny, huchen deepwater stingray scaly dragonfish. Goldeye daggertooth pike conger flashlight fish half-gill skipping goby. Clingfish mosquitofish earthworm eel, tiger shovelnose catfish, Pacific saury.\" Menhaden featherback; moray eel harelip sucker Chinook salmon burbot? Salmon, torrent catfish sockeye salmon, zebra pleco footballfish remora trout cod fire bar danio white croaker."));
        if(user != null){
            for (String role : user.getRoles()) {
                if (role.equals("admin")){
                    model.addAttribute("admin", true);
                }
            }
            model.addAttribute("message", new Message());
            model.addAttribute("messages", messages.getMessages());
            model.addAttribute("login", true);
            return "home";
        }
        model.addAttribute("error", true);
        model.addAttribute("logout", true);
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "logout";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("message", new Message());
        model.addAttribute("messages", messages.getMessages());
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String submitMessage(@ModelAttribute Message message, Model model){
        messages.addMessage(message);
        model.addAttribute("messages", messages.getMessages());
        for (Message m : messages.getMessages()) {
            System.out.println(m.getText());
        }
        model.addAttribute("admin",true);
        return "home";
    }
}
