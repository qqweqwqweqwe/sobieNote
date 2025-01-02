package YUN.sobieNote.Member.DTO;

public class MemberLoginResponse {
    private long memberId;

    public MemberLoginResponse(long memberId){
        this.memberId = memberId;
    }

    public long getMemberId() {
        return memberId;
    }
}
