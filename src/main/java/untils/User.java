package untils;

public class User {
    /**
     * 用户的userid
     */
    private int userid;

    /**
     *用户名字
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserid() {
        return userid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
