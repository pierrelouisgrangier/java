package fr.keyce.openit;

public abstract class Computer implements MaterialInterface{

	private String name;
	
	private String serialNumber;

	private Keyboard keyboard;

	private Mouse mouse;
	
	private float price;

	public Mouse getMouse() {
		return mouse;
	}

	protected Keyboard getKeyboard() {
		return keyboard;
	}

	void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	protected void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Computer " + name + " a le numéro de série : " + serialNumber;
	}

	@Override
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public abstract String instructionsGame();
	
}
