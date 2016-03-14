package test.ad;

public class Request extends Base {
	String sendCount;// 请求的广告数量

	@Override
	public String toString() {
		return super.toString() + "&sendCount="
				+ (sendCount == null ? "" : sendCount);
	}

	public static Request get(String adType,String sendCount) {
		Request r = new Request();
		r.appId = "01hBO810";
		r.uuid = Utils.getRandomIMEI();
		r.ua = Utils.getRandomUA();
		r.os = Utils.getRandomOSVersion();
		r.packageName = Utils.getRandomPackageName();
		r.imsi = Utils.getRandomIMSI();
		r.carrier = Utils.getCarrierByIMSI(r.imsi);
		r.mac = Utils.getRandomMAC();
		r.adType = adType;
		r.sendCount = sendCount;
		return r;
	}
}
