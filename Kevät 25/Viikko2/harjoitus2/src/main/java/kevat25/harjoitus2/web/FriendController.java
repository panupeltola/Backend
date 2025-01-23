package kevat25.harjoitus2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kevat25.harjoitus2.domain.Friend;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FriendController {

    private List<Friend> friendList = new ArrayList<>();

    
    
    @GetMapping("add")
    public String newFriendName(Model model){
      model.addAttribute("friend", new Friend());
      return "add";  
    }
    
    @PostMapping("/add")
    public String saveFriend(Friend friend){
        friendList.add(friend);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "success";
    }
    

    @GetMapping("/friends")
    public String showStudents(Model model) {
        model.addAttribute("friends", friendList);
        return "friends";
    }
    

}
