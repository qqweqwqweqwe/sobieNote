package YUN.sobieNote.Member.Enum;

public enum AUTH_PROVIDER {
    KAKAO(1);
    private final int id;

    AUTH_PROVIDER(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
