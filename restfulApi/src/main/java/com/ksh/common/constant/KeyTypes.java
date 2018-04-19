package com.ksh.common.constant;

import lombok.Getter;

/**
 * Created by becko on 2017. 4. 5..
 */
public enum KeyTypes {
    /* USER ID */
    //USER("USW", 6),
    USER("USP", 6), // 2017.10.11 기준 US또는 KR이외 국가인 경우의 회원 아이디 prefix
    USER_KR("KRP", 6), // 2017.10.11 기준 KR인 경우의 회원 아이디 prefix
    USER_SG("SGP",6),
    //////////////////////////////////////////////////////////////////////////////////////////

    /* PROFILE ID */
    PROFILE("USPRF", 4),
    PROFILE_KR("KRPRF",4), //프로필 아이디 KR
    PROFILE_SG("SGPRF",4), //프로필 아이디 SG
    //////////////////////////////////////////////////////////////////////////////////////////

    /* PROFILE NAME */
    PROFILENM("USER", 4),//프로필 네임 추가
    //////////////////////////////////////////////////////////////////////////////////////////

    /* PUBLIC CHANNEL ID */
    CHANNEL("USCH", 5),
    CHANNEL_KR("KRCH", 5),
    CHANNEL_SG("SGCH",5),
    //////////////////////////////////////////////////////////////////////////////////////////

    /* SECRET(Fans) CHANNEL ID */
    SECRET("USSC", 5), // secret channel 추가
    SECRET_KR("KRSC", 5), // secret KR
    SECRET_SG("SGSC",5), // secret SG
    //////////////////////////////////////////////////////////////////////////////////////////

    CERTIFICATION("CSQ", 4),
    //////////////////////////////////////////////////////////////////////////////////////////

    /* PUBLIC VIDEO CTNT ID */
    VIDEO("USVD", 5), // 2017.10.11 기준 US또는 KR이외 국가인 경우의 ctnt_id prefix
    VIDEO_KR("KRVD", 5), // 2017.10.11 기준 KR인 경우의 ctnt_id prefix
    VIDEO_SG("SGVD",5), // 2018.02.20 seunghwan - locale 기준 SG인 ctnt_id prefix
    //////////////////////////////////////////////////////////////////////////////////////////

    /* VIDEO CTNT FILE ID */
    VIDEOFILE("USVF",5), // 2017.10.11 기준 US또는 KR이외 국가인 경우의 ctnt_file_id prefix
    VIDEOFILE_KR("KRVF",5), // 2017.10.11 기준 KR인 경우의 ctnt_file_id prefix
    VIDEOFILE_SG("SGVF",5), //2018.02.20 seunghwan - 기준 SG인 경우의 ctnt_file_id prefix
    //////////////////////////////////////////////////////////////////////////////////////////

    /* COMMON ID */
    TCASHCHARGE("USTC",5),
	SELLCALCREQ("USSC",5),
	TCASHPGPAY("USPG",5),
    MONPG("USMON",4);

    @Getter
    private String key;
    @Getter
    private int bufferLength;

    KeyTypes(String key, int bufferLength) {
        this.key = key;
        this.bufferLength = bufferLength;
    }
}
