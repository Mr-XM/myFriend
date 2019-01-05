package mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接和断开
 */
public class MysqlConnect {
    public static final String url = "jdbc:MySQL://localhost:3306/myfriend?characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=true";
    public static final String name = "com.mysql.cj.jdbc.Driver";
    public static final boolean testFlag=false;

    Connection con;
    /**
     * 连接数据库
     * @return
     */
    public Connection getConnect() {
        try {
            Class.forName(name);
            if(testFlag==true){
                System.out.println("驱动加载成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            if(testFlag==true){
                System.out.println("驱动加载出错！");
            }
        }
        try {
            con = DriverManager.getConnection(url, "root", "4230980MENG");
            if(testFlag==true){
                System.out.println("数据库连接成功！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if(testFlag==true){
                System.out.println("数据库连接出错！");
            }
        }
        return con;
    }

    /**
     * 断开数据库
     * @return
     */
    public Connection closeConnect() {
        try {
            con.close();
            if(testFlag==true){
                System.out.println("连接断开成功！");
            }
        } catch (SQLException e) {
            if(testFlag==true){
                System.out.println("连接断开出错！");
            }
            e.printStackTrace();
        }
        return con;
    }
    /*public static void main(String[] args)
	{
		MysqlConnect c=new MysqlConnect();
		c.getConnect();
	    c.closeConnect();
	}*/
}

