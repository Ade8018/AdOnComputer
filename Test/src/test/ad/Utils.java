package test.ad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Utils {
	private static Random sRandom = new Random();
	public static String[] all = new String[] { "46000", "46002", "46007",
			"46001", "46006", "46003", "46005" };

	public static String getRandomIMEI() {
		// 例 507835236185671
		String result = "";
		for (int i = 0; i < "507835236185671".length(); i++) {
			result += sRandom.nextInt(10);
		}
		return result;
	}

	public static String getRandomIMSI() {
		// 460020103263174
		String result = all[sRandom.nextInt(all.length)];
		for (int i = 0; i < "0103263174".length(); i++) {
			result += sRandom.nextInt(10);
		}
		return result;
	}

	public static String getCarrierByIMSI(String imsi) {
		// cucc "46001", "46006"
		// ctcc "46003", "46005"
		// cmcc 46002 46000 46007
		if (imsi.startsWith("46001") || imsi.startsWith("46006")) {
			return "cucc";
		} else if (imsi.startsWith("46003") || imsi.startsWith("46005")) {
			return "ctcc";
		} else {
			return "cmcc";
		}
	}

	public static String getRandomMAC() {
		// 00:08:22:24:fe:fb
		String result = "";
		String srcs[] = "00:08:22:24:fe:fb".split(":");
		for (int i = 0; i < srcs.length; i++) {
			for (int j = 0; j < 2; j++) {
				result += Integer.toHexString(sRandom.nextInt(16));
			}
			if (i < srcs.length - 1) {
				result += ":";
			}
		}
		return result;
	}

	public static String[] oss = new String[] { "4.4.2", "4.4.3", "4.4.4",
			"5.0.0", "5.0.1", "5.1.1" };

	public static String getRandomOSVersion() {
		return oss[sRandom.nextInt(oss.length)];
	}

	public static String getRandomPackageName() {
		String result = "";
		int fst = sRandom.nextInt(5) + 1;
		int sec = sRandom.nextInt(5) + 1;
		int trd = sRandom.nextInt(5) + 1;
		for (int i = 0; i < fst; i++) {
			result += (char) ('a' + sRandom.nextInt(25));
		}
		result += ".";
		for (int i = 0; i < sec; i++) {
			result += (char) ('a' + sRandom.nextInt(25));
		}
		result += ".";
		for (int i = 0; i < trd; i++) {
			result += (char) ('a' + sRandom.nextInt(25));
		}
		return result;
	}

	public static String[] uas = new String[] { "GiONEE@GN9006" };

	public static String getRandomUA() {
		return uas[sRandom.nextInt(uas.length)];
	}

	public static String[] getAdIds(String resp) {
		int len = "\"adId\":\"".length();
		int index = resp.indexOf("\"adId\":\"");
		List<String> ids = new ArrayList<String>();
		while (index > 0) {
			resp = resp.substring(index + len);
			ids.add(resp.substring(0, 4));
			index = resp.indexOf("\"adId\":\"");
		}
		String[] results = new String[ids.size()];
		return ids.toArray(results);
	}

	public static String getProvince(String resp) {
		String anchor = "\"province\":\"";
		int len = anchor.length();
		int index = resp.indexOf(anchor);
		if (index > 0) {
			return resp.substring(index + len, index + len + 2);
		}
		return "";
	}
}
