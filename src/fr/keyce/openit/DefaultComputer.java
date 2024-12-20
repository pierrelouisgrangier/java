package fr.keyce.openit;

public class DefaultComputer extends Computer{

	@Override
	public String instructionsGame() {
		return "unknow";
	}

	@Override
	protected String getType() {
		return "other";
	}

}
