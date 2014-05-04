package DAO;

import Objects.Group;

import java.sql.*;
import java.util.Properties;

/**
 * Created by nastya on 30.03.14.
 */
public class GroupDAO
{

        private Connection conn = null;
        PreparedStatement pstmt = null;




        private boolean connect() throws SQLException
        {
            String host = "jdbc:mysql://localhost:3306/java";
            String user = "root";
            String pass = "1234";
            String charset = "UTF8";

            try
            {
                Properties properties = new Properties();

                properties.put("characterEncoding", charset);
                properties.put("user", user);
                properties.put("password", pass);

                conn = DriverManager.getConnection(host + "?", properties);
            }
            catch (SQLException e)
            {
                System.out.println(e.toString());

                return false;
            }

            return true;
        }


    private boolean disconnect()
        {
            try
            {
                if (pstmt != null) { pstmt.close(); }
                if (conn  != null) { conn.close();  }
            }
            catch (SQLException e)
            {
                System.out.println("On close: " + e.toString());

                return false;
            }

            return true;
        }

        public boolean save(Group group)
        {
            try
            {
                this.connect();

                Statement st = this.conn.createStatement();

                st.executeUpdate("INSERT INTO Groups (Name) VALUES ( '" + group.getName() + "')");
            }
            catch (SQLException e)
            {
                System.out.println(e.toString());

                return false;
            }
            finally
            {
                this.disconnect();
            }

            return true;
        }

        public boolean update(Group group)
        {
            try
            {
                this.connect();

                Statement st = this.conn.createStatement();

                st.executeUpdate("UPDATE Groups SET Name = '" + group.getName() +   "' WHERE  Id = " + group.getId() + ";");
            }
            catch (SQLException e)
            {
                System.out.println(e.toString());

                return false;
            }
            finally
            {
                this.disconnect();
            }

            return true;
        }

        public boolean delete(int id)
        {
            try
            {
                this.connect();

                Statement st = this.conn.createStatement();

                st.executeUpdate("DELETE FROM Groups WHERE Id = " + id + ";");
            }
            catch (SQLException e)
            {
                System.out.println(e.toString());

                return false;
            }
            finally
            {
                this.disconnect();
            }

            return true;
        }

        public Group select(int id)
        {

            try
            {
                this.connect();

                Statement st = this.conn.createStatement();

                ResultSet rs = st.executeQuery("SELECT * FROM Groups WHERE Id = " + id + " LIMIT 1;");

                if (rs.next())
                {
                    Group group = new Group();

                    group.setId(rs.getInt("Id"));
                    group.setName(rs.getString("Name"));

                    return group;
                }
            }
            catch (SQLException e)
            {
                System.out.println(e.toString());
            }
            finally
            {
                this.disconnect();
            }

            return null;
        }




}
