package kr.or.ddit.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import kr.or.ddit.sha256.KISA_SHA256;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private static final Logger logger = LoggerFactory.getLogger(User.class);

    private String userId;
    private String userNm;
    private String pass;

    @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    @DateTimeFormat( pattern = "yyyy-MM-dd" )
    private Date reg_dt;

    private String alias;
    private String addr1;
    private String addr2;
    private String zipCode;
    private String fileName;
    private String realFileName;
    private String realFileName2;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNm() {
        return userNm;
    }

    public void setUserNm(String userNm) {
        this.userNm = userNm;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = KISA_SHA256.encrypt(pass);
    }

    public Date getReg_dt() {
        return reg_dt;
    }

    public void setReg_dt(Date reg_dt) {
        this.reg_dt = reg_dt;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getRealFileName() {
        return realFileName;
    }

    public void setRealFileName(String realFileName) {
        this.realFileName = realFileName;
    }

    public String getRealFileName2() {
        return realFileName2;
    }

    public void setRealFileName2(String realFileName2) {
        this.realFileName2 = realFileName2;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userNm='" + userNm + '\'' +
                ", pass='" + pass + '\'' +
                ", reg_dt=" + reg_dt +
                ", alias='" + alias + '\'' +
                ", addr1='" + addr1 + '\'' +
                ", addr2='" + addr2 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", fileName='" + fileName + '\'' +
                ", realFileName='" + realFileName + '\'' +
                ", realFileName2='" + realFileName2 + '\'' +
                '}';
    }

    public boolean checkLoginValidate(String userId, String pass) {
        //암호화 문장끼리 비교
        logger.debug("pass : {}", KISA_SHA256.encrypt(pass));
        if(userId.equals(this.userId) && KISA_SHA256.encrypt(pass).equals(this.pass))
//        if(userId.equals(this.userId) && pass.equals(this.pass))
            return true;
        return false;
    }
}
