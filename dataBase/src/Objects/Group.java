package Objects;

/**
 * Created by nastya on 30.03.14.
 */
public class Group
{
        private int id;
        private String name;


        public Group()
        {

        }

        public Group(int id, String name)
        {
            this.setId(id);
            this.setName(name);

        }

        public Group(String name)
        {
            this.setName(name);

        }

        public int getId()
        {
            return this.id;
        }

        public String getName()
        {
            return this.name;
        }


        public void setId(int id)
        {
            this.id = id;
        }

        public void setName(String name)
        {
            this.name = name;
        }






}
