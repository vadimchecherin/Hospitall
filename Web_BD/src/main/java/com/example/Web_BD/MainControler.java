package com.example.Web_BD;


import com.example.Web_BD.models.Services;
import com.example.Web_BD.models.Personal;
import com.example.Web_BD.models.Post;
import com.example.Web_BD.models.Therpy;
import com.example.Web_BD.repo.PersonalRepo;
import com.example.Web_BD.repo.PostRepository;
import com.example.Web_BD.repo.ServicesRepo;
import com.example.Web_BD.repo.TherpyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
class MainControler {

    @Autowired private PostRepository postRepository;
    @Autowired private PersonalRepo personalrepository;
    @Autowired private ServicesRepo ServicesRepo;
    @Autowired private TherpyRepo TherpyRepo;


    @GetMapping("/useraccount")
    public String userAcc ( Model model) {
        Iterable <Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "useraccount";
    }


    @GetMapping ("/addClient")
    public String addgetclient ( Model model) {
        return "addClient";
    }

    @PostMapping  ("/addClient")
    public String addpostclient ( @RequestParam String FIO,
                                  @RequestParam String Sex,
                                  @RequestParam String Date_of_Birthday,
                                  @RequestParam String Date_of_Reg,
                                  @RequestParam String passport,
                                  Model model) {
        Post post = new Post (FIO,Sex,Date_of_Birthday,Date_of_Reg,passport);
        postRepository.save(post);
        return "redirect:/";
    }


    @GetMapping("/useraccount/{id}")
    public String userid (@PathVariable(value = "id") Long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/useraccount";
        }
      Optional <Post> post= postRepository.findById(id);
      ArrayList <Post> res = new ArrayList<>();
      post.ifPresent(res::add);
      model.addAttribute("post", res);
      return "useraccountid";
    }

    @GetMapping("/useraccount/{id}/edit")
    public String useridedit (@PathVariable(value = "id") Long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/useraccount";
        }
        Optional <Post> post= postRepository.findById(id);
        ArrayList <Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "useraccountid-edit";
    }

    @PostMapping  ("/useraccount/{id}/edit")
    public String clientUpdate (
                                  @PathVariable(value = "id") Long id,
                                  @RequestParam String FIO,
                                  @RequestParam String Sex,
                                  @RequestParam String Date_of_Birthday,
                                  @RequestParam String Date_of_Reg,
                                  @RequestParam String passport) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setFIO(FIO);
        post.setSex(Sex);
        post.setDate_of_Birthday(Date_of_Birthday);
        post.setDate_of_Reg(Date_of_Reg);
        post.setPassport(passport);
        postRepository.save(post);
        return "redirect:/";
    }

    @PostMapping ("/useraccount/{id}/remove")
    public String clientdelete (@PathVariable(value = "id") Long id, Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/useraccount";
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping ("/personal")
    public String personal ( Model model) {
        Iterable <Personal> per = personalrepository.findAll();
        model.addAttribute("per",per);
        return "personal";
    }

    @PostMapping  ("/personal")
    public String addpostclient ( @RequestParam String FIO,
                                  @RequestParam String speciality) {
        Personal personal = new Personal (FIO, speciality);
        personalrepository.save(personal);
        return "redirect:/personal";
    }

    @GetMapping("/personal/{id}")
    public String personalid (@PathVariable(value = "id") Long id, Model model) {
        if(!personalrepository.existsById(id)){
            return "redirect:/personal";
        }
        Optional <Personal> per = personalrepository.findById(id);
        ArrayList <Personal> personal = new ArrayList<>();
        per.ifPresent(personal::add);
        model.addAttribute("per", personal);
        return "personalid";
    }


    @PostMapping  ("/personal/{id}")
    public String personalUpdate (
            @PathVariable(value = "id") Long id,
            @RequestParam String FIO,
            @RequestParam String speciality) {
        Personal personal = personalrepository.findById(id).orElseThrow();
        personal.setFIO(FIO);
        personal.setSpeciality(speciality);
        personalrepository.save(personal);
        return "redirect:/personal";
    }

    @PostMapping ("/personal/{id}/remove")
    public String personaldelete (@PathVariable(value = "id") Long id, Model model) {
        Personal personaldelete = personalrepository.findById(id).orElseThrow();
        personalrepository.delete(personaldelete);
        return "redirect:/personal";
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping ("/therpy")
    public String therpy ( Model model) {
        Iterable <Therpy> therpy = TherpyRepo.findAll();
        model.addAttribute("therpy",therpy);
        return "therpy";
    }
    @PostMapping ("/therpy")
    public String addtherpy (@RequestParam String lecarst,
                             @RequestParam String price) {
        Therpy therpy = new Therpy(lecarst, price);
        TherpyRepo.save(therpy);
        return "redirect:/therpy";
    }

    @GetMapping("/therpy/{id}")
    public String therpyid (@PathVariable(value = "id") Long id, Model model) {
        if(!TherpyRepo.existsById(id)){
            return "redirect:/therpy";
        }
        Optional <Therpy> therpy = TherpyRepo.findById(id);
        ArrayList <Therpy> ther = new ArrayList<>();
        therpy.ifPresent(ther::add);
        model.addAttribute("therpy", ther);
        return "therpyid";
    }

    @PostMapping  ("/therpy/{id}")
    public String therpyUpdate (
            @PathVariable(value = "id") Long id,
            @RequestParam String price,
            @RequestParam String lecarst) {
        Therpy therpy = TherpyRepo.findById(id).orElseThrow();
        therpy.setPrice(price);
        therpy.setLecarst(lecarst);
        TherpyRepo.save(therpy);
        return "redirect:/therpy";
    }

    @PostMapping ("/therpy/{id}/remove")
    public String therpydelete (@PathVariable(value = "id") Long id, Model model) {
        Therpy therpydelete = TherpyRepo.findById(id).orElseThrow();
        TherpyRepo.delete(therpydelete);
        return "redirect:/therpy";
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping ("/services")
    public String services ( Model model) {
    Iterable <Services> services = ServicesRepo.findAll();
    model.addAttribute("services", services);
    return "services";
}
    @PostMapping  ("/services")
    public String addservices ( @RequestParam String price,
                                @RequestParam String name) {
        Services services = new Services (price, name);
        ServicesRepo.save(services);
        return "redirect:/services";
    }

    @GetMapping("/services/{id}")
    public String servicesid (@PathVariable(value = "id") Long id, Model model) {
        if(!ServicesRepo.existsById(id)){
            return "redirect:/services";
        }
        Optional <Services> services = ServicesRepo.findById(id);
        ArrayList <Services> servic = new ArrayList<>();
        services.ifPresent(servic::add);
        model.addAttribute("services", servic);
        return "servicesid";
    }

    @PostMapping  ("/services/{id}")
    public String servicesUpdate (
            @PathVariable(value = "id") Long id,
            @RequestParam String price,
            @RequestParam String name) {
        Services services = ServicesRepo.findById(id).orElseThrow();
        services.setPrice(price);
        services.setName(name);
        ServicesRepo.save(services);
        return "redirect:/services";
    }

    @PostMapping ("/services/{id}/remove")
    public String servicesdelete (@PathVariable(value = "id") Long id, Model model) {
        Services servicesdelete = ServicesRepo.findById(id).orElseThrow();
        ServicesRepo.delete(servicesdelete);
        return "redirect:/services";
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/history")
    public String history ( Model model) {
        return "history";
    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    @GetMapping ("/reg")
    public String reg (Model model) {
        return "register";
        }

    @GetMapping("/")
    public String home ( Model model) {
        return "home";
    }
}