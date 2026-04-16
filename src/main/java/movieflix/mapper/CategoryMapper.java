package movieflix.mapper;

import lombok.experimental.UtilityClass;
import movieflix.controller.request.CategoryRequest;
import movieflix.controller.response.CategoryResponse;
import movieflix.entity.Category;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
        return Category.builder()
                .name(categoryRequest.name())
                .build();
    }
    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }


}
