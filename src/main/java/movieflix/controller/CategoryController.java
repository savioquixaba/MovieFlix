package movieflix.controller;

import lombok.RequiredArgsConstructor;
import movieflix.controller.request.CategoryRequest;
import movieflix.controller.response.CategoryResponse;
import movieflix.entity.Category;
import movieflix.mapper.CategoryMapper;
import movieflix.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<CategoryResponse> findAllCategories(){
        List<Category> categories = categoryService.findAll();
        return categories.stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();
    }

    @PostMapping()
    public CategoryResponse saveCategory(@RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
        return CategoryMapper.toCategoryResponse(savedCategory);
    }

    @GetMapping("/{id}")
    public CategoryResponse getByCategoryId(@PathVariable Long id){
        Optional<Category> optCategory = categoryService.findById(id);
        if (optCategory.isPresent()){
            return CategoryMapper.toCategoryResponse(optCategory.get());
        }return  null;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }
}
