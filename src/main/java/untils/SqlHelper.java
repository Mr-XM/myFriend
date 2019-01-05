package untils;

import mysql.MysqlConnect;
import untils.Friend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqlHelper {
    /**
     * 判断账户密码是否有效
     *
     * @param userId
     * @param password
     * @return
     */
    public static boolean isValid(String userId, String password) {
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            Statement sql;
            con = ps.getConnect();
            ResultSet res;
            sql = con.createStatement();
            res = sql.executeQuery("select * from user where name = '" + userId + "'and password = '" + password + "'");
            if (res.next()) {
                return true;
            }
            sql.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 用户名是否已经存在
     *
     * @param userId
     * @return
     */
    public static boolean isExisted(String userId) {
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            Statement sql;
            con = ps.getConnect();
            ResultSet res;
            sql = con.createStatement();
            res = sql.executeQuery("select * from user where name = '" + userId + "'");
            if (res.next()) {
                return true;
            }
            sql.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 添加用户
     *
     * @param name
     * @param password
     * @return
     */
    public static boolean addUser(String name, String password) {
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            PreparedStatement sql;
            con = ps.getConnect();
            sql = con.prepareStatement("insert into user(name,password)" + "values(?,?)");
            sql.setString(1, name);
            sql.setString(2, password);

            sql.executeUpdate();
            sql.close();
            ps.closeConnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取全部好友信息
     *
     * @param userid
     * @return
     */
    public static List<Friend> getAllFriend(int userid) {
        List<Friend> list = new ArrayList<>();
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            Statement sql;
            con = ps.getConnect();
            ResultSet res;
            sql = con.createStatement();
            res = sql.executeQuery("select * from myfriend where userid = " + userid);
            while (res.next()) {
                Friend friend = new Friend();
                friend.setAddress(res.getString("address"));
                friend.setAge(res.getInt("age"));
                friend.setEmail(res.getString("email"));
                friend.setQq(res.getString("qq"));
                friend.setName(res.getString("name"));
                friend.setTelephone(res.getString("telephone"));
                friend.setUserid(res.getInt("userid"));
                friend.setSex(res.getString("sex"));
                friend.setId(res.getInt("id"));
                list.add(friend);
            }
            sql.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取部分好友信息
     *
     * @param userid
     * @param name
     * @return
     */
    public static List<Friend> getPartFriend(int userid, String name) {
        List<Friend> list = new ArrayList<>();
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            Statement sql;
            con = ps.getConnect();
            ResultSet res;
            sql = con.createStatement();
            res = sql.executeQuery("select * from myfriend where userid = " + userid + " and name like '%" + name + "%'");
            while (res.next()) {
                Friend friend = new Friend();
                friend.setAddress(res.getString("address"));
                friend.setAge(res.getInt("age"));
                friend.setEmail(res.getString("email"));
                friend.setQq(res.getString("qq"));
                friend.setName(res.getString("name"));
                friend.setTelephone(res.getString("telephone"));
                friend.setUserid(res.getInt("userid"));
                friend.setSex(res.getString("sex"));
                friend.setId(res.getInt("id"));
                list.add(friend);
            }
            sql.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据用户名获取userid
     *
     * @param userName
     * @return
     */
    public static int getUserId(String userName) {
        int userid = 0;
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            Statement sql;
            con = ps.getConnect();
            ResultSet res;
            sql = con.createStatement();
            res = sql.executeQuery("select * from user where name = '" + userName + "'");
            if (res.next()) {
                userid = res.getInt("userid");
            }
            sql.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userid;
    }

    /**
     * 根据ID删除好友
     *
     * @param id
     * @return
     */
    public static boolean deleteFriend(int id) {
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            Statement sql;
            con = ps.getConnect();
            sql = con.createStatement();
            String deleteuser = "delete from myfriend where id =" + id;
            sql.executeUpdate(deleteuser);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据id获取好友信息
     *
     * @param id
     * @return
     */
    public static Friend getFriend(int id) {
        Friend friend = new Friend();
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            Statement sql;
            con = ps.getConnect();
            ResultSet res;
            sql = con.createStatement();
            res = sql.executeQuery("select * from myfriend where id = " + id);
            while (res.next()) {
                friend.setAddress(res.getString("address"));
                friend.setAge(res.getInt("age"));
                friend.setEmail(res.getString("email"));
                friend.setQq(res.getString("qq"));
                friend.setName(res.getString("name"));
                friend.setTelephone(res.getString("telephone"));
                friend.setUserid(res.getInt("userid"));
                friend.setSex(res.getString("sex"));
                friend.setId(res.getInt("id"));
            }
            sql.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return friend;
    }

    /**
     * 更新朋友信息
     * @param friend
     * @return
     */
    public static boolean updateFriendInformation(Friend friend) {
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            PreparedStatement sql;
            con = ps.getConnect();
            sql = con.prepareStatement("update myfriend set name = ?,sex = ?,address = ?,age = ?,qq = ?,telephone = ?,email = ?,userid = ? where id = " + friend.getId());
            sql.setString(1, friend.getName());
            sql.setString(2, friend.getSex());
            sql.setString(3,friend.getAddress());
            sql.setInt(4, friend.getAge());
            sql.setString(5, friend.getQq());
            sql.setString(6, friend.getTelephone());
            sql.setString(7, friend.getEmail());
            sql.setInt(8, friend.getUserid());
            sql.executeUpdate();
            sql.close();
            ps.closeConnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加朋友
     * @param friend
     * @return
     */
    public static boolean addFriend(Friend friend) {
        try {
            MysqlConnect ps = new MysqlConnect();
            Connection con;
            PreparedStatement sql;
            con = ps.getConnect();
            sql = con.prepareStatement("insert into myfriend(name,userid,sex,address,age,telephone,email,qq)" + "values(?,?,?,?,?,?,?,?)");
            sql.setString(1, friend.getName());
            sql.setInt(2,friend.getUserid());
            sql.setString(3, friend.getSex());
            sql.setString(4,friend.getAddress());
            sql.setInt(5,friend.getAge());
            sql.setString(6,friend.getTelephone());
            sql.setString(7,friend.getEmail());
            sql.setString(8,friend.getQq());
            sql.executeUpdate();
            sql.close();
            ps.closeConnect();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /*public static void main(String[] arg) {
        //System.out.println(isValid("admin","admin"));
        //System.out.println(isValid("abc","1234"));
        //System.out.println(addUser("dog","1234"));
        List<Friend> list=getPartFriend(2,"李");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName());
        }
        //System.out.println(getUserId("abc"));
        //System.out.println(deleteFriend(5));
        System.out.println(getFriend(6).getName());
    }*/
}
