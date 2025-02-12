package YUN.sobieNote.Board.Seeder;


import YUN.sobieNote.Board.Entity.Category;
import YUN.sobieNote.Board.Repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategorySeeder {
    private final CategoryRepository categoryRepository;


    @PostConstruct
    @Transactional
    public void initCategories() {

        List<String> categoryNames = List.of(
                "FOOD", "FASHION", "DIGITAL", "BEAUTY", "PET", "SPORTS", "INTERIOR",
                "BOOKS", "AUTOMOBILE", "HOME_APPLIANCES", "HEALTH", "HOUSEHOLD", "HOBBY", "TRAVEL"
        );

        List<String> categoryDisplayNames = List.of(
                "식품", "패션", "디지털", "미용", "반려동물", "스포츠", "인테리어",
                "도서", "자동차", "가전", "건강", "생활용품", "취미", "여행"
        );

        for (int i = 0; i < categoryNames.size(); i++) {
            String categoryName = categoryNames.get(i);
            String categoryDisplayName = categoryDisplayNames.get(i);

            if (!categoryRepository.existsByName(categoryName)) { // 중복 방지
                Category category = new Category(0,categoryName,categoryDisplayName); // "음식" -> "FOOD"
                categoryRepository.save(category);
            }
        }
    }

    //    static let TagList4 = ["100","80","60","40","20"]

}
