package project.FoodList.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import project.FoodList.Model.Food;

@Mapper
// ID,NAME,price
public interface FoodMapper{
    @Select("Select * From Food")
    Food[] selectFoods();

    @Insert("INSERT INTO FOOD(name,price) VALUES(#{name},#{price})")
    int addfood(Food food);
}

