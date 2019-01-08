package kr.tpsw.rsstats;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class WordPressParsing {
	public final static List<String> updateLogList;
	public final static Map<String, List<String>> updateLogMap;
	public final static List<String> blacklistsIp;
	public final static List<String> blacklistsVersion;

	public final static String PLUGIN_NAME;
	public final static String PLUGIN_NAME_LOWER;
	public final static String PLUGIN_VERSION;

	public final static String PLUGIN_UPDATE_URL;
	public final static String IP;

	public final static boolean PLUGIN_IS_FINAL_VERSION;
	public final static boolean PLUGIN_IS_REGISTERED_BLACKLIST_IP;
	public final static boolean PLUGIN_IS_REGISTERED_BLACKLIST_VERSION;

	// 1.0 ���� ǥ�� ���°�
	// 1.1 ������Ʈ Ŀ�ǵ忡 �޼��� �ٲ�
	// 1.2 blacklist ip,version��� �߰�
	// 1.3 �÷����� ���� üũ ��� ��ȭ
	// 1.4 ���ͳ� ���� ��쵵 �۵��ϰ� ����, ������Ʈ ��� ��ȭ

	public static void main(String[] args) {
		Map<String, List<String>> map = WordPressParsing.updateLogMap;
		System.out.println("������Ʈ �ʿ�: " + !PLUGIN_IS_FINAL_VERSION);
		if (map == null) {
			System.out.println("��ã�Ҵ�");
		}
		for (String key : map.keySet()) {
			System.out.println("<version>:".replace("<version>", key));
			List<String> list = map.get(key);
			for (String s : list) {
				System.out.println("  - <log>".replace("<log>", s));
			}
		}
		System.out.println("ip=" + IP);
		System.out.println("update=" + PLUGIN_UPDATE_URL);
		enableCheck();
	}

	static {
		PLUGIN_VERSION = "1.6.3";
		PLUGIN_NAME = "RsStats";
		updateLogList = new LinkedList<String>();
		PLUGIN_NAME_LOWER = PLUGIN_NAME.toLowerCase();

		String postid = "34";
		String posturl = "http://tpsw.or.kr/" + postid;
		StringBuilder sb = new StringBuilder();
		List<String> postlist = new LinkedList<String>();

		int i1 = 0;
		int i2 = 0;
		StringBuilder sb2;
		String tag;
		String[] args;
		boolean isConnected = true;

		StringBuilder builder = new StringBuilder();
		try {
			URL url = new URL(posturl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line).append('\n');
			}
		} catch (Exception e) {
			if (e instanceof UnknownHostException) {
				System.out.println("[" + PLUGIN_NAME + "] ������Ʈ �������� ������ �� �����ϴ�. UnknownHostException");
			} else {
				e.printStackTrace();
			}
			isConnected = false;
		}
		// stream��������

		if (isConnected == true && builder.indexOf("Manager:TPsw") == -1) {
			System.out.println("[" + PLUGIN_NAME + "] ������Ʈ �������� �����Ǿ� �ֽ��ϴ�.");
			isConnected = false;
		}

		if (isConnected) {
			{
				tag = "ip";
				i1 = builder.indexOf("<" + tag + ">");
				i2 = builder.indexOf("</" + tag + ">");
				if (i1 == -1 || i2 == -1) {
					IP = null;
				} else {
					IP = builder.substring(i1 + tag.length() + 2, i2);
				}
			}// ip��������

			{
				i1 = builder.indexOf("<div class=\"post-content\">");
				builder.delete(0, i1);
				i1 = builder.indexOf("<p>");
				builder.delete(0, i1 + 3);
				i1 = builder.indexOf("</div>");
				args = builder.substring(0, i1).replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("<p>", "").replace("\n", "").trim().split("</p>");
				for (String line : args) {
					postlist.add(line);
					sb.append(line).append('\n');
				}
			}// �Խù� �κи� �ڸ���

			{
				i1 = sb.indexOf("<" + PLUGIN_NAME_LOWER + ">");
				i2 = sb.indexOf("</" + PLUGIN_NAME_LOWER + ">");
				sb2 = new StringBuilder(sb.substring(i1 + PLUGIN_NAME_LOWER.length() + 3, i2 - 1));
			}// �÷����� �κ� �ڸ���

			{
				tag = "update";
				i1 = sb2.indexOf("<" + tag + ">");
				i2 = sb2.indexOf("</" + tag + ">");
				args = sb2.substring(i1 + tag.length() + 3, i2 - 1).split("\n");
				updateLogMap = new LinkedHashMap<String, List<String>>();
				List<String> inst = null;
				String name = null;
				for (String str : args) {
					updateLogList.add(str);
					if (str.contains(":")) {
						inst = new LinkedList<String>();
						name = str.replace(":", "");
						updateLogMap.put(name, inst);
					} else {
						inst.add(str.replace("-", ""));
					}
				}
			}// ������Ʈ �α�

			{
				tag = "download";
				i1 = sb2.indexOf("<" + tag + ">");
				i2 = sb2.indexOf("</" + tag + ">");
				if (i1 == -1 || i2 == -1) {
					// �Ѿ��
					PLUGIN_UPDATE_URL = null;
				} else {
					PLUGIN_UPDATE_URL = sb2.substring(i1 + tag.length() + 3, i2 - 1);
				}
			}// �ٿ�ε� �ּ�

			{
				tag = "blacklist-ip";
				i1 = sb2.indexOf("<" + tag + ">");
				i2 = sb2.indexOf("</" + tag + ">");
				if (i1 == -1 || i2 == -1) {
					blacklistsIp = null;
				} else {
					args = sb2.substring(i1 + tag.length() + 3, i2 - 1).split("\n");
					blacklistsIp = Arrays.asList(args);
				}
			}// ������Ʈ ������ �ּ�

			{
				tag = "blacklist-version";
				i1 = sb2.indexOf("<" + tag + ">");
				i2 = sb2.indexOf("</" + tag + ">");
				if (i1 == -1 || i2 == -1) {
					blacklistsVersion = null;
				} else {
					args = sb2.substring(i1 + tag.length() + 3, i2 - 1).split("\n");
					blacklistsVersion = Arrays.asList(args);
				}
			}// ������Ʈ ����

			if (blacklistsIp != null && blacklistsIp.size() > 0) {
				if (blacklistsIp.get(0).equals("*")) {
					PLUGIN_IS_REGISTERED_BLACKLIST_IP = true;
				} else {
					PLUGIN_IS_REGISTERED_BLACKLIST_IP = blacklistsIp.contains(IP);
				}// ������ üũ
			} else {
				PLUGIN_IS_REGISTERED_BLACKLIST_IP = false;
			}

			if (blacklistsVersion != null && blacklistsVersion.size() > 0) {
				if (blacklistsVersion.get(0).equals("*")) {
					PLUGIN_IS_REGISTERED_BLACKLIST_VERSION = true;
				} else {
					PLUGIN_IS_REGISTERED_BLACKLIST_VERSION = blacklistsVersion.contains(PLUGIN_VERSION);
				}// ���� üũ
			} else {
				PLUGIN_IS_REGISTERED_BLACKLIST_VERSION = false;
			}

			boolean bool = true;
			double plugin_double_version = trasferVersion(PLUGIN_VERSION);
			for (String ver : WordPressParsing.updateLogMap.keySet()) {
				double logversion = trasferVersion(ver);
				if (logversion <= plugin_double_version) {
					// bool = true;
				} else {
					bool = false;
				}
			}

			PLUGIN_IS_FINAL_VERSION = bool;
			// �ֽ� ���� Ȯ��
		} else {
			updateLogMap = new HashMap<String, List<String>>();
			blacklistsIp = new ArrayList<String>();
			blacklistsVersion = new ArrayList<String>();
			PLUGIN_UPDATE_URL = null;
			IP = "null";
			PLUGIN_IS_FINAL_VERSION = true;
			PLUGIN_IS_REGISTERED_BLACKLIST_IP = false;
			PLUGIN_IS_REGISTERED_BLACKLIST_VERSION = false;
		}

	}

	public static void wordPressDownload(String surl, File file) {
		try {
			URL url = new URL(surl);
			URLConnection urlc = url.openConnection();
			InputStream is = urlc.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);

			FileOutputStream fos = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			int r;
			byte[] buffer = new byte[1024];
			while ((r = bis.read(buffer, 0, buffer.length)) != -1) {
				bos.write(buffer, 0, r);
			}
			bos.close();
			bis.close();
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
	}

	public static double trasferVersion(String version) {
		StringBuilder sb = new StringBuilder();
		for (char c : version.toCharArray()) {
			if (('0' <= c && c <= '9') || c == '.') {
				sb.append(c);
			}
		}
		version = sb.toString();
		if (version.indexOf('.') > -1) {
			int i1 = version.indexOf('.');
			String s = new StringBuilder(version).substring(i1 + 1, version.length()).replace(".", "");
			return Double.valueOf(version.substring(0, i1) + "." + s);
		} else {
			return Double.valueOf(version);
		}
	}

	private static boolean enableCheck() {
		if (PLUGIN_IS_REGISTERED_BLACKLIST_VERSION) {
			System.out.println("[" + PLUGIN_NAME + "] �÷������� ������Ʈ�� ��ϵǾ� �ֽ��ϴ�.");
			return false;
		}
		if (PLUGIN_IS_REGISTERED_BLACKLIST_IP) {
			System.out.println("[" + PLUGIN_NAME + "] ������ ������Ʈ�� ��ϵǾ� �ֽ��ϴ�.");
			return false;
		}
		if (PLUGIN_IS_FINAL_VERSION) {
			System.out.println("[" + PLUGIN_NAME + "] �÷������� �ֽ� �����Դϴ�.");
		} else {
			System.out.println("[" + PLUGIN_NAME + "] �÷������� �ֽ� ������ �ƴմϴ�.");
		}
		return true;
	}

	public static boolean initRegister(Plugin pl, final PluginCommand pc, final File file) {
		if (enableCheck() == false) {
			System.out.println("[" + PLUGIN_NAME + "]�÷������� ������ ��Ȱ��ȭ��ŵ�ϴ�.");
			Bukkit.getPluginManager().disablePlugin(pl);
			return false;
		}

		Bukkit.getPluginManager().registerEvents(new Listener() {
			@EventHandler
			public void onJoin(PlayerJoinEvent event) {
				Player player = event.getPlayer();
				if ((player.hasPermission(PLUGIN_NAME_LOWER + ".admin") || player.isOp()) && !PLUGIN_IS_FINAL_VERSION) {
					player.sendMessage("��6" + PLUGIN_NAME + "�÷������� �� ������ �߰ߵǾ����ϴ�. ��ɾ�:" + pc.getLabel());
				}
			}
		}, pl);
		if (PLUGIN_UPDATE_URL != null) {
			pc.setExecutor(new CommandExecutor() {
				@Override
				public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
					if (args.length == 0) {
						sender.sendMessage("��6/" + label + " true");
						sender.sendMessage("��f�÷������� �ֽ� ������ �ڵ����� �����޽��ϴ�.");
						sender.sendMessage("��f������ ����� �ϰ� �� ��� �÷������� �� �������� ����˴ϴ�.");
					} else if (args[0].equals("true")) {
						sender.sendMessage("��f�÷����� �ٿ�ε� ��...");
						wordPressDownload(PLUGIN_UPDATE_URL, new File(file.getPath()));
						sender.sendMessage("��f�÷������� �ֽ� ������ �ڵ����� �����޾ҽ��ϴ�.");
						sender.sendMessage("��f������ ����� �ϰ� �� ��� �÷������� �� �������� ����˴ϴ�.");
					} else {
						sender.sendMessage("��c�ùٸ� ��ɾ �Է��ϼ���.");
					}
					return false;
				}
			});
		}
		return true;
	}
}
