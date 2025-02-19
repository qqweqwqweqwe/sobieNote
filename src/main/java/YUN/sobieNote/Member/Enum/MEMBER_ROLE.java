package YUN.sobieNote.Member.Enum;

public enum MEMBER_ROLE {
    USER(1), ADMIN(2);

    private final int id;

    MEMBER_ROLE(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
