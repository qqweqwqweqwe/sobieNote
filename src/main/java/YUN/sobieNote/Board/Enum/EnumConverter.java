package YUN.sobieNote.Board.Enum;

public class EnumConverter {

    public static CategoryType convertStringToCategory(String str){
        return CategoryType.valueOf(str);
    }

    public static EmotionType convertStringToEmotion(String str){
        return EmotionType.valueOf(str);
    }

}
