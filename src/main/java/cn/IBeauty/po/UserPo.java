package cn.IBeauty.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
public class UserPo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String nickname;

    private String pwd;

    @Column(name = "user_integral")
    private Integer userIntegral;

    @Column(name = "is_email_verify")
    private Integer isEmailVerify;

    @Column(name = "email_verify_code")
    private String emailVerifyCode;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "user_pic")
    private String userPic;

    public UserPo(Integer id, String email, String nickname, String pwd, Integer userIntegral, Integer isEmailVerify, String emailVerifyCode, Date lastLoginTime, String lastLoginIp, String userPic) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.pwd = pwd;
        this.userIntegral = userIntegral;
        this.isEmailVerify = isEmailVerify;
        this.emailVerifyCode = emailVerifyCode;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.userPic = userPic;
    }

    public UserPo() {
        super();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * @return user_integral
     */
    public Integer getUserIntegral() {
        return userIntegral;
    }

    /**
     * @param userIntegral
     */
    public void setUserIntegral(Integer userIntegral) {
        this.userIntegral = userIntegral;
    }

    /**
     * @return is_email_verify
     */
    public Integer getIsEmailVerify() {
        return isEmailVerify;
    }

    /**
     * @param isEmailVerify
     */
    public void setIsEmailVerify(Integer isEmailVerify) {
        this.isEmailVerify = isEmailVerify;
    }

    /**
     * @return email_verify_code
     */
    public String getEmailVerifyCode() {
        return emailVerifyCode;
    }

    /**
     * @param emailVerifyCode
     */
    public void setEmailVerifyCode(String emailVerifyCode) {
        this.emailVerifyCode = emailVerifyCode == null ? null : emailVerifyCode.trim();
    }

    /**
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return last_login_ip
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * @param lastLoginIp
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    /**
     * @return user_pic
     */
    public String getUserPic() {
        return userPic;
    }

    /**
     * @param userPic
     */
    public void setUserPic(String userPic) {
        this.userPic = userPic == null ? null : userPic.trim();
    }
}