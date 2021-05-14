package clicker;

public class Money {
	
	
	int Pmoney = 0;

	float multiplier = 1;

	public void add(int amount) {
		Pmoney += amount * multiplier;

	}
	
	public void subtract(int amount) {
		System.out.println(Pmoney);
		System.out.println(amount);
		Pmoney -= amount;
	}

	public void addMultiplier(float amount) {
		multiplier += amount;
	}

}
