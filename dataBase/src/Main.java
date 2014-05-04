import Objects.Group;
import DAO.GroupDAO;
import Objects.Student;
import DAO.StudentDAO;

public class Main {

    public static void main(String[] args) {

        GroupDAO groupd = new GroupDAO();
        Group g = new Group("153503");
        groupd.save(g);

         StudentDAO userd =  new StudentDAO();
         Student us =  new Student("Вася","Пупкин",3);
         userd.save(us);

    }
}
