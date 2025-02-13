package YUN.sobieNote.Board.Seeder;

import YUN.sobieNote.Board.Entity.Category;
import YUN.sobieNote.Board.Entity.Emotion;
import YUN.sobieNote.Board.Repository.EmotionRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@RequiredArgsConstructor
public class EmotionSeeder {
    private final EmotionRepository emotionRepository;

    @PostConstruct
    @Transactional
    public void initEmotions() {


        List<String> emotionNames = List.of(
                "HAPPY", "EXCITED", "PROUD", "GRATEFUL", "RELAXED", "CURIOUS",
                "REGRETFUL", "DISAPPOINTED", "UNCOMFORTABLE", "WORRIED", "ANGRY", "EMBARRASSED"
        );

        List<String> emotionDisplayNames = List.of(
                "행복한", "설레는", "뿌듯한", "고마운", "편안한", "신기한",
                "후회하는", "아쉬운", "불편한", "걱정스러운", "화나는", "당황스러운"
        );

        for (int i = 0; i < emotionNames.size (); i++){
            String emotionName = emotionNames.get(i);
            String emotionDisplayName = emotionDisplayNames.get(i);

            if (!emotionRepository.existsByName(emotionName)) { // 중복 방지
                Emotion emotion = Emotion. // "음식" -> "FOOD"
                emotionRepository.save(emotion);
            }
        }
    }


}
