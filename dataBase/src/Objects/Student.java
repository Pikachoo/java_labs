package Objects;

public class Student
{
	private int id;
	private String name;
	private String surname;
    private int groupId;

	public Student()
	{

	}

	public Student(int id, String name, String surname, int groupId)
	{
		this.setId(id);
		this.setName(name);
		this.setSurname(surname);
        this.setGroupId(groupId);
	}

	public Student(String name, String surname, int groupId)
	{
		this.setName(name);
		this.setSurname(surname);
        this.setGroupId(groupId);
	}

	public int getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public String getSurname()
	{
		return this.surname;
	}

    public int getGroupId() {return  this.groupId; }

	public void setId(int id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

    public void setGroupId(int groupId) { this.groupId = groupId; }

}
