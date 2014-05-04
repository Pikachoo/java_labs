package DAO;

import Objects.Student;

import java.sql.*;
import java.util.Properties;

public class StudentDAO
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

	public boolean save(Student student)
	{
		try
		{
			this.connect();

			Statement st = this.conn.createStatement();

			st.executeUpdate("INSERT INTO Students (Name, Surname, GroupId) VALUES ('" + student.getName() + "', '" + student.getSurname() +"', '" + student.getGroupId()+ "')");
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

	public boolean update(Student student)
	{
		try
		{
			this.connect();

			Statement st = this.conn.createStatement();

			st.executeUpdate("UPDATE students SET Name = '" + student.getName() + "', Surname = '" + student.getSurname() +  "' WHERE  Id = " + student.getId() + ";");
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

			st.executeUpdate("DELETE FROM students WHERE id = " + id + ";");
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

	public Student select(int id)
	{

		try
		{
			this.connect();

			Statement st = this.conn.createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM students WHERE id = " + id + " LIMIT 1;");

			if (rs.next())
			{
				Student student = new Student();

				student.setId(rs.getInt("Id"));
				student.setName(rs.getString("Name"));
				student.setSurname(rs.getString("Surname"));
                student.setGroupId(rs.getInt("GroupId"));

				return student;
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

    public Student addStudentToGroup(int id, int groupId)
    {

        try
        {
            this.connect();

            Statement st = this.conn.createStatement();

            st.executeUpdate("UPDATE students SET GroupId = '" + groupId +   "' WHERE  Id = " + id + ";");

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
