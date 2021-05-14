package clicker;

public class Upgrade {
	public String displayName;
	public float multiplier;
	public int cost;
	public Money money;

	public Upgrade(String displayName, float multiplier, int cost, Money money) {
		this.displayName = displayName;
		this.multiplier = multiplier;
		this.cost = cost;
		this.money = money;
	}

	public void PurchaseUpgrade() {
		int oldCost = cost;
		cost *= multiplier;
		System.out.println(oldCost);
		money.subtract(oldCost);
		
		
	}

}
