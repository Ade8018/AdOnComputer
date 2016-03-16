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
		int sleepTime = 10;
		while (System.currentTimeMillis() - start < 60 * 60 * 1000) {
			if (first) {
				first = false;
				ExecutorUtil.post(new Chaping());
			} else {
				
			}
		}
	}
}
