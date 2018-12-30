package com.kat.lap_trinh_web.common.model;

import java.io.Serializable;

public class MemberDto implements Serializable {
    private int memberId;
    private String memberName;

    public MemberDto(){}
    public MemberDto(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;

    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
