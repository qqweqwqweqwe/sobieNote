package YUN.sobieNote.Board.Enum;


// 문자열을 enum의 정수형으로 바꿔주는 converter
// ex) input(스포츠) -> output(1)
public class EnumConverter {

    public static CategoryType convertStringToCategory(String str){
        return CategoryType.valueOf(str);
    }

    public static EmotionType convertStringToEmotion(String str){
        return EmotionType.valueOf(str);
    }

    public static FactorType convertStringToFactor(String str){
        return FactorType.valueOf(str);
    }
}
