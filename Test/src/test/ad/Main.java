package test.ad;

import test.ad.data.AdData;
import test.ad.entity.Base;
import test.ad.thread.ChapingThread;
import test.ad.thread.DesktopThread;
import test.ad.thread.NewDesktopThread;
import test.ad.thread.PushThread;
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
		Thread[] ts = new Thread[4];
		while (System.currentTimeMillis() - start < 10 * 60 * 1000) {
			if (first) {
				first = false;
				ts[0] = new ChapingThread();
				ts[0].start();
			} else {
				int index = Utils.sRandom.nextInt(4);
				if (ts[index] == null || !ts[index].isAlive()) {
					if (index != 0 || Utils.random(0.1f)) {
						Thread t = null;
						switch (index) {
						case 0:
							t = new ChapingThread();
							break;
						case 1:
							t = new DesktopThread();
							break;
						case 2:
							t = new NewDesktopThread();
							break;
						case 3:
							t = new PushThread();
							break;
						}
						ts[index] = t;
						ts[index].start();
						Utils.sleep(5, 200);
					}
				}
			}
		}
		for (int i = 0; i < ts.length; i++) {
			if (ts[i].isAlive()) {
				ts[i].interrupt();
				ts[i] = null;
			}
		}
		Utils.sleep(1, 1);
	}

}
