package tray.notif;

public enum Notifications implements Notification {

	INFORMATION("res/info.png", "#2C54AB"),
	NOTICE("res/notice.png", "#8D9695"),
	SUCCESS("res/success.png", "#009961"),
	WARNING("res/warning.png", "#E23E0A"),
	ERROR("res/error.png", "#CC0033");

	private final String urlResource;
	private final String paintHex;

	Notifications(String urlResource, String paintHex) {
		this.urlResource = urlResource;
		this.paintHex = paintHex;
	}

	@Override
	public String getURLResource() {
		return urlResource;
	}

	@Override
	public String getPaintHex() {
		return paintHex;
	}

}
