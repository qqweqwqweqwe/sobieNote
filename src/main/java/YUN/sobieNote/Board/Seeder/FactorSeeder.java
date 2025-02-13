package YUN.sobieNote.Board.Seeder;


import YUN.sobieNote.Board.Entity.Category;
import YUN.sobieNote.Board.Entity.Factor;
import YUN.sobieNote.Board.Repository.FactorRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FactorSeeder {
    private final FactorRepository factorRepository;


    @PostConstruct
    @Transactional
    public void initFactors() {

        List<String> factorNames = List.of(
                "ENVIRONMENTAL_PROTECTION", "EFFICIENCY_INCREASE", "HABIT_IMPROVEMENT", "CURIOSITY_SATISFACTION", "PREFERENCE_DIGGING",
                "SELF_DEVELOPMENT", "PHYSICAL_HEALTH", "SIMPLE_PURCHASE", "MOOD_BOOST", "SENSE_OF_BELONGING"
        );

        List<String> factorDisplayNames = List.of(
                "환경보호","효율증가","습관개선","호기심충족","취향디깅",
                "자기계발","몸건강","단순구매","기분전환","소속감"
        );

        for (int i = 0; i < factorNames.size(); i++) {
            String factorName = factorNames.get(i);
            String factorDisplayName = factorDisplayNames.get(i);

            if (!factorRepository.existsByName(factorName)) { // 중복 방지
                Factor factor = Factor.builder()
                        .name(factorName)
                        .displayName(factorDisplayName)
                        .build();
                factorRepository.save(factor);
            }
        }



    }


}
