package test.ad;

import test.ad.data.AdData;
import test.ad.entity.Base;
import test.ad.thread.Chaping;
import test.ad.thread.Desktop;
import test.ad.thread.NewDesktop;
import test.ad.thread.Push;
import test.ad.util.ExecutorUtil;
import test.ad.util.Utils;

public class Main {
	public static void main(String[] args) {
		while (true) {
			startNew();
		}
	}

	private static void startNew() {
		AdData data = AdData.create();
		data.base = Base.get();
		long start = System.currentTimeMillis();
		boolean first = true;
		while (System.currentTimeMillis() - start < 10 * 60 * 1000) {
			if (first) {
				first = false;
				ExecutorUtil.post(new Chaping());
			} else {
				ExecutorUtil.post(getRandomRun());
			}
			if (System.currentTimeMillis() - start < 1 * 60 * 1000) {
				Utils.sleep(2, 8);
			} else {
				Utils.sleep(30, 270);
			}
			if (AdData.getCurrent().activeCount >= 3 || AdData.getCurrent().pushCount >= 30) {
				break;
			}
		}
		Utils.sleep(60, 10);
	}

	public static Runnable getRandomRun() {
		float f = Utils.sRandom.nextFloat();
		if (f < 0.05f) {
			return new Chaping();
		} else if (f >= 0.05f && f < 0.45f) {
			return new Push();
		} else if (f >= 0.45f && f < 0.75f) {
			return new Desktop();
		}
		return new NewDesktop();
	}
}
