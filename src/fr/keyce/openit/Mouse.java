package fr.keyce.openit;

public class Mouse implements MaterialInterface {

	private float price = 0;

	private String name;

	private String serialNumber;

	@Override
	public String toString() {
		return "Mouse";
	}

	@Override
	public float getPrice() {
		return price;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

}
