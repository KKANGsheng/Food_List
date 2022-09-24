package project.FoodList.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import project.FoodList.Service.FoodService;
import project.FoodList.Model.Food;

@Controller
public class FoodController {

    private FoodService foodservice;

    public FoodController(FoodService foodservice) {
        this.foodservice = foodservice;
    }

    @GetMapping("/")
    public String getHome(Model model,Food food){
        Food [] foods= foodservice.getFoods();

    model.addAttribute("foods",foods);
    return "home";
    }


    @PostMapping("/home")
        public String addFood(Model model,Food food){

        if (food.getPrice()>1000||food.getPrice()==null){
            model.addAttribute("errormessage",String.format("failed to added %s",food.getName()));
        }else if(foodservice.addFood(food)<1){
            model.addAttribute("errormessage",String.format("not added %s",food.getName()));
        }else{
            model.addAttribute("successmessage",String.format("success added %s",food.getName()));
        }

    
        Food[] foods=foodservice.getFoods();
        model.addAttribute("foods", foods);
        return "home";
    }
}
