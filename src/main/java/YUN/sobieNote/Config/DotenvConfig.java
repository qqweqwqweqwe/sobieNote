package YUN.sobieNote.Config;


import io.github.cdimascio.dotenv.Dotenv;

public class DotenvConfig {

    private static Dotenv dotenv;

    private DotenvConfig(){

    }
    public static Dotenv getInstance(){

        if(dotenv==null){
            // 동기화 시작 , 다른 스레드가 초기화 했는지 check
            synchronized (DotenvConfig.class) {
                if (dotenv == null) {
                    dotenv = Dotenv.load();
                }
            }
        }

        return dotenv;

    }

}
