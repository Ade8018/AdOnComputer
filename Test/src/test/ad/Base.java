package test.ad;
public class Base {
	public static final String SDK_VERSION = "2.6.4";
	String appId;
	String uuid;// imei
	String ua;// GiONEE@GN9006
	String os;// 4.4.2
	String safe = "1";// unknow default 1
	String versionCode = "1.0";// unknow default 1
	String packageName;
	String sdkVersion = SDK_VERSION;
	String province;// 广东
	String carrier;// cmcc
	String imsi;// 460020103263174
	String mac;// 00:08:22:24:fe:fb
	String adId;// 首次获取广告为空
	String adType;// chaping

	@Override
	public String toString() {
		return "appId=" + (appId == null ? "" : appId) + "&uuid="
				+ (uuid == null ? "" : uuid) + "&ua=" + (ua == null ? "" : ua)
				+ "&os=" + (os == null ? "" : os) + "&safe="
				+ (safe == null ? "" : safe) + "&versionCode="
				+ (versionCode == null ? "" : versionCode) + "&packageName="
				+ (packageName == null ? "" : packageName) + "&sdkVersion="
				+ (sdkVersion == null ? "" : sdkVersion) + "&province="
				+ (province == null ? "" : province) + "&carrier="
				+ (carrier == null ? "" : carrier) + "&imsi="
				+ (imsi == null ? "" : imsi) + "&mac="
				+ (mac == null ? "" : mac)  + "&adId="
				+ (adId == null ? "" : adId) + "&adType="
				+ (adType == null ? "" : adType);
	}
}
