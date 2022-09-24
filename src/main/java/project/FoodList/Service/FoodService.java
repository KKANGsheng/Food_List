package project.FoodList.Service;

import org.springframework.stereotype.Service;
import project.FoodList.mapper.FoodMapper;
import project.FoodList.Model.Food;

//main business logic
//call third party api
@Service
public class FoodService {
    private FoodMapper foodmapper;

    public FoodService(FoodMapper foodmapper){
        this.foodmapper=foodmapper;
    }

    public Food[] getFoods(){
        Food[] foods=foodmapper.selectFoods();
        return foods;
    }

    public int addFood(Food food){
        return foodmapper.addfood(food);
    }
}
