
public class Item {
	int ID;
	long Poster_ID;
	public String Name;
	public String Description;
	public String Date;
	public byte []Pic;
	public Item(int i,String n,String d,String D,byte []p) {
		ID=i;
		Name=n;
		Description=d;
		Date=D;
		Pic=p;
	}public Item() {
	}
	
	public void SetID(int i)
	{
		ID=i;
	}
	public void SetPosterID(long n)
	{
		Poster_ID=n;
	}
	public void SetName(String n)
	{
		Name=n;
	}
	public void SetDescription(String d)
	{
		Description=d;
	}
	public void SetDate(String D)
	{
		Date=D;
	}
	public void SetPic(byte[]p)
	{
		Pic=p;
	}
	public String getName()
	{
		return Name;
	}
	public int getID()
	{
		return ID;
	}
	public long getPosterID()
	{
		return Poster_ID;
	}
	public String getDescription()
	{
		return Description;
	}
	public String getDate()
	{
		return Date;
	}
	public byte[] getPic()
	{
		return Pic;
	}
}
