package test.ad;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Request r = Request.get("chaping","3");
		System.out.println(r.toString());
		String resp = postInfo(
				Base64.encodeToString(r.toString().getBytes(), 0), "a");
		System.out.println(resp);

		String[] adids = Utils.getAdIds(resp);
		if (adids.length < 1) {
			return;
		}
		System.out.println(Arrays.toString(adids));
		String province = Utils.getProvince(resp);
		r.adId = adids[0];
		r.province = province;
//		
//		Request desktop = Request.get("desktop", "9");
//		System.out.println(desktop.toString());
//		resp = postInfo(
//				Base64.encodeToString(desktop.toString().getBytes(), 0), "a");
//		System.out.println(resp);
//		
//		Request chaping1 = Request.get("chaping1", "1");
//		System.out.println(chaping1.toString());
//		resp = postInfo(
//				Base64.encodeToString(chaping1.toString().getBytes(), 0), "a");
//		System.out.println(resp);
//		
//		Request newDesktop = Request.get("newDesktop", "8");
//		System.out.println(newDesktop.toString());
//		resp = postInfo(
//				Base64.encodeToString(newDesktop.toString().getBytes(), 0), "a");
//		System.out.println(resp);
//		
//		Request push = Request.get("push", "1");
//		System.out.println(push.toString());
//		resp = postInfo(
//				Base64.encodeToString(push.toString().getBytes(), 0), "a");
//		System.out.println(resp);
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Action a = new Action(r, "push");
		System.out.println(a.toString());
		resp = postInfo(Base64.encodeToString(a.toString().getBytes(), 0), "b");
		System.out.println(resp);
		
		r.adId = adids[1];
		System.out.println(r.toString());
		resp = postInfo(Base64.encodeToString(r.toString().getBytes(), 0), "a");
		System.out.println(resp);
		
		r.adId = adids[0];

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.action = "download";
		System.out.println(a.toString());
		resp = postInfo(Base64.encodeToString(a.toString().getBytes(), 0), "b");
		System.out.println(resp);

		try {
			Thread.sleep(12000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.action = "install";
		System.out.println(a.toString());
		resp = postInfo(Base64.encodeToString(a.toString().getBytes(), 0), "b");
		System.out.println(resp);

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		a.action = "start";
		System.out.println(a.toString());
		resp = postInfo(Base64.encodeToString(a.toString().getBytes(), 0), "b");
		System.out.println(resp);
	}

	private static String postInfo(String param, String method) {
		URL url;
		String result = null;
		try {
			url = new URL("http://bz.ooxxz.com/" + method);
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "text/plain");

			conn.getOutputStream().write(param.getBytes());
			conn.getOutputStream().flush();

			InputStream is = conn.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int len = 0;
			byte buffer[] = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
				baos.flush();
			}
			result = baos.toString();
			baos.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
