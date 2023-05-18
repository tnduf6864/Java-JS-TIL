
public class TV {
	
	boolean power = false;
	int channel = 7;
	int volume = 50;

	void powerOn()
	{
		power = true;
	}
	
	void powerOff()
	{
		power = false;
	}
	
	boolean isPower()
	{
		return power;
	}
	
	void print()
	{
		System.out.println("채널은 " + channel + "번, 음량은 " + volume);
	}
}
