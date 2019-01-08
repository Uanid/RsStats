package kr.tpsw.rsstats.api;

import java.util.LinkedList;
import java.util.List;

import kr.tpsw.rsstats.Main;
import kr.tpsw.rsstats.YamlConfiguration;

import org.bukkit.command.CommandSender;

public class MessageAPI {

	public static List<String> sts;
	public static List<String> stsadmin;
	public static List<String> stsadmin2;
	public static List<String> stscmd;
	public static List<String> stsgive;
	public static List<String> stsuser;

	public static String CANT_FIND_MESSAGELIST;// ����� ã������ �����ϴ�.
	public static String CANT_FINT_STATS_NAME;// �ش�� �̸��� ������ ã������ �����ϴ�.
	public static String CANT_FINT_USER;// �ش� ������ ã������ �����ϴ�.
	public static String CANT_CONSOLE_USE_THIS_COMMAND;// �ܼ��� �ش� ��ɾ��� �����
														// �Ұ����մϴ�.

	public static String NEXT_MESSAGE;// ���� ����� ������<cmd> <index>
	public static String LIST_INDEX_MESSAGE;// <n>���� ã�ҽ��ϴ�. <index>/<all>
	public static String LIST_INDEX;// <index>: <message>
	public static String STATS_LORE_NOW;// ���� ����: <point> / <max>
	public static String ALREADY_HAS_STATS_NAME;// �̹� �����ϴ� ������ �̸��Դϴ�
	public static String PLZ_ENTER_CORRECT_X_Y;// x���� 1~9�� y���� 1~3�� �Է��Ͻʽÿ�.
	public static String INVENTORY_NAME;// ��c<name>��6���� ����
	public static String NO_RELEASE;// <target>���� ���� �������δ� off�Դϴ�.
	public static String AVILABLESTATS;// ���� ����: <point>

	public static String INCORRECT_MESSAGE;// �߸��� ��ɾ��Դϴ�. <cmd>
	public static String INCORRECT_STATS_TYPE;// �ùٸ� ���� Ÿ���� �Է��Ͻʽÿ�.
	public static String INCORRECT_COEFFICIENT;// �ùٸ� ���� ����� �Է��Ͻʽÿ�.
	public static String INCORRECT_LIST_INDEX;// �ش� ��ȣ�� lore�� �������� �ʽ��ϴ�.
	public static String INCORRECT_ITEM_CODE;// �ùٸ��� ���� ������ �ڵ�.
	public static String INCORRECT_POSITIVE_INTEGER;// �ùٸ� ������ �����ʽÿ�.
	public static String INCORRECT_X_Y_INTEGER;// x�� y�� �ùٸ� ������ �����ʽÿ�.

	public static String RUN_CRITICAL; // ũ��Ƽ�� ������!
	public static String RUN_BREAK; // �� ��� �ι�!
	public static String RUN_PLACE; // ������ ����!
	public static String RUN_ITEM; // ���� ����!
	public static String INFINITE; // ����
	public static String AUTO_SAVE; // [RpgStatsSystem] ���� ������ �ڵ� ���� �Ϸ�

	// stsadmin
	public static String SUCCESSFULLY_ADD_STATS;// ���������� ������ �߰��߽��ϴ�.
	public static String SUCCESSFULLY_EDIT_STATS;// ���������� ������ �����߽��ϴ�.
	public static String SUCCESSFULLY_REMOVE_STATS;// ���������� ������ �������ϴ�.
	public static String SUCCESSFULLY_ADDLORE_STATS;// ���������� lore�� �߰��߽��ϴ�.
	public static String SUCCESSFULLY_REMOVELORE_STATS;// ���������� lore�� �������ϴ�.
	public static String SUCCESSFULLY_SETITEM_STATS;// ���������� ������ �ڵ带 �����߽��ϴ�.
	public static String SUCCESSFULLY_SETITEMNAME_STATS;// ���������� ������ �̸��� �����߽��ϴ�.
	public static String SUCCESSFULLY_SETMAX_STATS;// ���������� �ִ� ���ݷ��� �����߽��ϴ�.

	// sts, stsgive
	public static String SUCCESSFULLY_SET_RELEASE;// ���������� ���� ���θ� <release>��
													// �����߽��ϴ�.
	public static String STATS_GIVE_MESSAGE;// ����� <point>��ŭ ������ �޾ҽ��ϴ�.

	// stsuser
	public static String SUCCESSFULLY_ADD_POINT;// ���������� �ش� ������ ���� ����Ʈ�� �߰��߽��ϴ�.
	public static String SUCCESSFULLY_SET_POINT;// ���������� �ش� ������ ���� ����Ʈ�� �����߽��ϴ�.
	public static String VIEW_USER_STATS;// <stats> >> <point>
	public static String SUCCESSFULLY_RESET_POINT;// ���������� �ش� ������ ���� ����Ʈ�� �ʱ�ȭ�߽��ϴ�.
	public static String SUCCESSFULLY_REMOVE_POINT;// ���������� �ش� ������ ���� ����Ʈ�� �����߽��ϴ�.

	// stsadmin2
	public static String INCORRECT_BONUS_TYPE;// �ùٸ� ���ʽ� �̸��� �Է��Ͻʽÿ�.
	public static String SUCCESSFULLY_SET_BONUS;// ���������� ���� ���ʽ��� �����߽��ϴ�.
	public static String SUCCESSFULLY_RELOAD;// ���������� ������ ���ε��߽��ϴ�.
	public static String SUCCESSFULLY_SAVE;// ���������� ������ �����߽��ϴ�.
	public static String VIEW_STATS_BONUS;// <type>: <bonus>
	public static String INCORRECT_FILE_NAME;// �ùٸ� ���� �̸��� �Է��Ͻʽÿ�.
	public static String KICK_MESSAGE;// ������ ���� �ε�� �������� ���Ͽ� ������ �߹��մϴ�.

	// stscmd
	public static String SUCCESSFULLY_CMD_SET;// ���������� ��ɾ �����߽��ϴ�.
	public static String SUCCESSFULLY_CMD_REMOVE;// ���������� ������ ��ɾ �������ϴ�.
	public static String INCORRECT_CMD_TYPE;// �ùٸ��� ���� ��ɾ� Ÿ���Դϴ�.

	// stsupdate
	public static String CANT_FIND_UPDATE_LOG;
	public static String PLUGINLOG1;
	public static String PLUGINLOG2;

	// stscmd
	public static String STSCMD_TYPE;
	public static String STSCMD_CMD;

	public static String PLUGIN_SEARCH;
	public static String PLUGIN_CANT_SEARCH;
	public static String PLUGIN_LOAD_ERROR;
	public static String PLUGIN_LOAD_SUCCESSFULLY;

	static {
		if (Main.lang.equals("kr")) {
			PLUGIN_SEARCH = "<plugin> �÷����� �߰�!";
			PLUGIN_CANT_SEARCH = "<plugin> �÷����� �˻� �Ұ�!";
			PLUGIN_LOAD_ERROR = "�÷����� �ε� �� ���� �߻�";
			PLUGIN_LOAD_SUCCESSFULLY = "�÷����� ���� �ε� �Ϸ�";
		} else if (Main.lang.equals("us")) {
			PLUGIN_SEARCH = "Found <plugin>!";
			PLUGIN_CANT_SEARCH = "Cant found <plugin>!";
			PLUGIN_LOAD_ERROR = "Error occurred while loading plugin";
			PLUGIN_LOAD_SUCCESSFULLY = "Successfully plugin load";
		}
		if (Main.lang.equals("kr")) {
		} else if (Main.lang.equals("us")) {
		}
	}

	public static void updateMessageAPIs() {
		YamlConfiguration me = Main.message;
		sts = me.getStringList("command.sts.help");
		stsadmin = me.getStringList("command.stsadmin.help");
		stsadmin2 = me.getStringList("command.stsadmin2.help");
		stscmd = me.getStringList("command.stscmd.help");
		stsgive = me.getStringList("command.stsgive.help");
		stsuser = me.getStringList("command.stsuser.help");

		CANT_FIND_MESSAGELIST = me.getString("command.general.cant.CANT_FIND_MESSAGELIST");
		CANT_FINT_STATS_NAME = me.getString("command.general.cant.CANT_FINT_STATS_NAME");
		CANT_FINT_USER = me.getString("command.general.cant.CANT_FINT_USER");
		CANT_CONSOLE_USE_THIS_COMMAND = me.getString("command.general.cant.CANT_CONSOLE_USE_THIS_COMMAND");

		NEXT_MESSAGE = me.getString("command.general.etc.NEXT_MESSAGE");
		LIST_INDEX_MESSAGE = me.getString("command.general.etc.LIST_INDEX_MESSAGE");
		LIST_INDEX = me.getString("command.general.etc.LIST_INDEX");
		STATS_LORE_NOW = me.getString("command.general.etc.STATS_LORE_NOW");
		ALREADY_HAS_STATS_NAME = me.getString("command.general.etc.ALREADY_HAS_STATS_NAME");
		PLZ_ENTER_CORRECT_X_Y = me.getString("command.general.etc.PLZ_ENTER_CORRECT_X_Y");
		INVENTORY_NAME = me.getString("command.general.etc.INVENTORY_NAME");
		NO_RELEASE = me.getString("command.general.etc.NO_RELEASE");
		AVILABLESTATS = me.getString("command.general.etc.AVILABLESTATS");
		RUN_CRITICAL = me.getString("command.general.etc.RUN_CRITICAL");
		RUN_BREAK = me.getString("command.general.etc.RUN_BREAK");
		RUN_PLACE = me.getString("command.general.etc.RUN_PLACE");
		RUN_ITEM = me.getString("command.general.etc.RUN_ITEM");
		INFINITE = me.getString("command.general.etc.INFINITE");
		AUTO_SAVE = me.getString("command.general.etc.AUTO_SAVE");

		INCORRECT_MESSAGE = me.getString("command.general.incorrect.INCORRECT_MESSAGE");
		INCORRECT_STATS_TYPE = me.getString("command.general.incorrect.INCORRECT_STATS_TYPE");
		INCORRECT_COEFFICIENT = me.getString("command.general.incorrect.INCORRECT_COEFFICIENT");
		INCORRECT_LIST_INDEX = me.getString("command.general.incorrect.INCORRECT_LIST_INDEX");
		INCORRECT_ITEM_CODE = me.getString("command.general.incorrect.INCORRECT_ITEM_CODE");
		INCORRECT_POSITIVE_INTEGER = me.getString("command.general.incorrect.INCORRECT_POSITIVE_INTEGER");
		INCORRECT_X_Y_INTEGER = me.getString("command.general.incorrect.INCORRECT_X_Y_INTEGER");

		SUCCESSFULLY_ADD_STATS = me.getString("command.stsadmin.general.SUCCESSFULLY_ADD_STATS");
		SUCCESSFULLY_EDIT_STATS = me.getString("command.stsadmin.general.SUCCESSFULLY_EDIT_STATS");
		SUCCESSFULLY_REMOVE_STATS = me.getString("command.stsadmin.general.SUCCESSFULLY_REMOVE_STATS");
		SUCCESSFULLY_ADDLORE_STATS = me.getString("command.stsadmin.general.SUCCESSFULLY_ADDLORE_STATS");
		SUCCESSFULLY_REMOVELORE_STATS = me.getString("command.stsadmin.general.SUCCESSFULLY_REMOVELORE_STATS");
		SUCCESSFULLY_SETITEM_STATS = me.getString("command.stsadmin.general.SUCCESSFULLY_SETITEM_STATS");
		SUCCESSFULLY_SETITEMNAME_STATS = me.getString("command.stsadmin.general.SUCCESSFULLY_SETITEMNAME_STATS");
		SUCCESSFULLY_SETMAX_STATS = me.getString("command.stsadmin.general.SUCCESSFULLY_SETMAX_STATS");

		SUCCESSFULLY_SET_RELEASE = me.getString("command.sts.general.SUCCESSFULLY_SET_RELEASE");
		STATS_GIVE_MESSAGE = me.getString("command.stsgive.general.STATS_GIVE_MESSAGE");

		SUCCESSFULLY_ADD_POINT = me.getString("command.stsuser.general.SUCCESSFULLY_ADD_POINT");
		SUCCESSFULLY_SET_POINT = me.getString("command.stsuser.general.SUCCESSFULLY_SET_POINT");
		VIEW_USER_STATS = me.getString("command.stsuser.general.VIEW_USER_STATS");
		SUCCESSFULLY_REMOVE_POINT = me.getString("command.stsuser.general.SUCCESSFULLY_REMOVE_POINT");
		SUCCESSFULLY_RESET_POINT = me.getString("command.stsuser.general.SUCCESSFULLY_RESET_POINT");

		INCORRECT_BONUS_TYPE = me.getString("command.stsadmin2.general.INCORRECT_BONUS_TYPE");
		SUCCESSFULLY_SET_BONUS = me.getString("command.stsadmin2.general.SUCCESSFULLY_SET_BONUS");
		SUCCESSFULLY_RELOAD = me.getString("command.stsadmin2.general.SUCCESSFULLY_RELOAD");
		SUCCESSFULLY_SAVE = me.getString("command.stsadmin2.general.SUCCESSFULLY_SAVE");
		VIEW_STATS_BONUS = me.getString("command.stsadmin2.general.VIEW_STATS_BONUS");
		INCORRECT_FILE_NAME = me.getString("command.stsadmin2.general.INCORRECT_FILE_NAME");
		KICK_MESSAGE = me.getString("command.stsadmin2.general.KICK_MESSAGE");

		SUCCESSFULLY_CMD_SET = me.getString("command.stscmd.general.SUCCESSFULLY_CMD_SET");
		SUCCESSFULLY_CMD_REMOVE = me.getString("command.stscmd.general.SUCCESSFULLY_CMD_REMOVE");
		INCORRECT_CMD_TYPE = me.getString("command.stscmd.general.INCORRECT_CMD_TYPE");

		CANT_FIND_UPDATE_LOG = me.getString("command.stsupdate.general.CANT_FIND_UPDATE_LOG");
		PLUGINLOG1 = me.getString("command.stsupdate.general.PLUGINLOG1");
		PLUGINLOG2 = me.getString("command.stsupdate.general.PLUGINLOG2");

		STSCMD_TYPE = me.getString("command.stscmd.general.STSCMD_TYPE");
		STSCMD_CMD = me.getString("command.stscmd.general.STSCMD_CMD");

	}

	public static void helpMessageList(CommandSender sender, List<String> list, int i, String label) {
		if (i * 10 - 9 > list.size() || i == 0) {
			sender.sendMessage(CANT_FIND_MESSAGELIST);
		} else {
			for (int j = (i - 1) * 10; j < i * 10; j++) {
				sender.sendMessage(list.get(j).replace('&', '��'));
				if (list.size() == (j + 1)) {
					break;
				}
				if (((i * 10) - 1) == j && list.size() > (j + 1)) {
					sender.sendMessage(NEXT_MESSAGE.replace("<cmd>", label).replace("<index>", String.valueOf(i + 1)));
				}
			}
		}
	}

	public static void helpMessageListPLUSINDEX(CommandSender sender, List<String> list, int i, String label) {
		if (i * 10 - 9 > list.size() || i == 0) {
			sender.sendMessage(CANT_FIND_MESSAGELIST);
		} else {
			if (list.size() % 10 == 0) {
				sender.sendMessage(MessageAPI.LIST_INDEX_MESSAGE.replace("<n>", String.valueOf(list.size())).replace("<index>", String.valueOf(i)).replace("<all>", String.valueOf(list.size() / 10)));
			} else {
				sender.sendMessage(MessageAPI.LIST_INDEX_MESSAGE.replace("<n>", String.valueOf(list.size())).replace("<index>", String.valueOf(i)).replace("<all>", String.valueOf(list.size() / 10 + 1)));
			}
			for (int j = (i - 1) * 10; j < i * 10; j++) {
				sender.sendMessage(LIST_INDEX.replace("<index>", String.valueOf(j + 1)).replace("<message>", list.get(j).replaceAll("&", "��")));
				if (list.size() == (j + 1)) {
					break;
				}
				if (((i * 10) - 1) == j && list.size() > (j + 1)) {
					sender.sendMessage(NEXT_MESSAGE.replace("<cmd>", label).replace("<index>", String.valueOf(i + 1)));
				}
			}
		}
	}

	public static void saveMessageConfig() {
		YamlConfiguration me = Main.message;
		List<String> sts = new LinkedList<String>();
		List<String> stsadmin = new LinkedList<String>();
		List<String> stsadmin2 = new LinkedList<String>();
		List<String> stscmd = new LinkedList<String>();
		List<String> stsgive = new LinkedList<String>();
		List<String> stsuser = new LinkedList<String>();
		sts.add("��6/sts (v|view)");
		sts.add("��6/sts (v|view) <name>");
		sts.add("��6/sts (r|release) (true|false)");

		stsadmin.add("��6/stsadmin add <stats> <x> <y> <type> <coefficient>");
		stsadmin.add("��6/stsadmin edit <stats> <x> <y> <type> <coefficient>");
		stsadmin.add("��6/stsadmin addlore <stats> <message>");
		stsadmin.add("��6/stsadmin removelore <stats> <index>");
		stsadmin.add("��6/stsadmin setitem <stats> <item-code>");
		stsadmin.add("��6/stsadmin setitemname <stats> <displayname>");
		stsadmin.add("��6/stsadmin setmax <stats> <value>");
		stsadmin.add("��6/stsadmin remove <stats>");
		stsadmin.add("��6/stsadmin list");
		if (Main.lang.equals("kr")) {
			stsadmin.add("��cHEALTH, ORE, BREAK, PLACE, DAMAGE, PLANTS, DEFENSE, FOOD, CRITICAL, ATTACK_RESIST, ARROW, LIFESTEAL���� Ÿ���� �����մϴ�.");
		} else if (Main.lang.equals("us")) {
			stsadmin.add("��ctype is exists such as HEALTH, ORE, BREAK, PLACE, DAMAGE, PLANTS, DEFENSE, FOOD, CRITICAL, ATTACK_RESIST, ARROW, LIFESTEAL");
		}

		stsadmin2.add("��6/stsadmin2 set (rpgexpsystem|mclevelup) <value>");
		stsadmin2.add("��6/stsadmin2 reload (config|stats|user|message)");
		stsadmin2.add("��6/stsadmin2 save (config|stats|user|message)");
		stsadmin2.add("��6/stsadmin2 viewconfig");

		stscmd.add("��6/stscmd set <stats> <point> <cmd type> (command)");
		stscmd.add("��6/stscmd remove <stats> <point>");
		stscmd.add("��6/stscmd list");
		if (Main.lang.equals("kr")) {
			stscmd.add("��cCMD, CMDOP, CMDCON, CHAT, CHATOP���� Ÿ���� �����մϴ�.");
		} else if (Main.lang.equals("us")) {
			stscmd.add("��ccmdtype is exists such as CMD, CMDOP, CMDCON, CHAT, CHATOP");
		}

		stsuser.add("��6/stsuser dset <user> <stats> <point>");
		stsuser.add("��6/stsuser dadd <user> <stats> <point>");
		stsuser.add("��6/stsuser dview <user> <stats>");
		stsuser.add("��6/stsuser set <user> <value>");
		stsuser.add("��6/stsuser add <user> <value>");
		stsuser.add("��6/stsuser view <user>");
		stsuser.add("��6/stsuser reset <user> <stats>");
		stsuser.add("��6/stsuser remove <user>");

		stsgive.add("��6/stsgive <name> <value>");

		me.set("command.sts.help", sts);
		me.set("command.stsadmin.help", stsadmin);
		me.set("command.stsadmin2.help", stsadmin2);
		me.set("command.stscmd.help", stscmd);
		me.set("command.stsuser.help", stsuser);
		me.set("command.stsgive.help", stsgive);

		if (Main.lang.equals("kr")) {
			me.set("command.general.incorrect.INCORRECT_MESSAGE", "��6�߸��� ��ɾ��Դϴ�. ��c/<cmd> ��6��ɾ ����Ͻʽÿ�.");
			me.set("command.general.incorrect.INCORRECT_STATS_TYPE", "��6�ùٸ� ���� ��cŸ�ԡ�6�� �Է��Ͻʽÿ�.");
			me.set("command.general.incorrect.INCORRECT_COEFFICIENT", "��6�ùٸ� ���� ��c�����6�� �Է��Ͻʽÿ�.");
			me.set("command.general.incorrect.INCORRECT_LIST_INDEX", "��6�ش� ��ȣ�� ��clore��c6�� �������� �ʽ��ϴ�.");
			me.set("command.general.incorrect.INCORRECT_ITEM_CODE", "��6�ùٸ��� ���� ��c������ �ڵ��6�Դϴ�.");
			me.set("command.general.incorrect.INCORRECT_POSITIVE_INTEGER", "��6�ùٸ� ��c������6�� �����ʽÿ�.");
			me.set("command.general.incorrect.INCORRECT_X_Y_INTEGER", "��cX��6�� ��cY��6�� �ùٸ� ��c������6�� �����ʽÿ�.");

			me.set("command.general.cant.CANT_FIND_MESSAGELIST", "��c�ش� ����� �������� �ʽ��ϴ�.");
			me.set("command.general.cant.CANT_FINT_STATS_NAME", "��c�ش�� �̸��� ������ ã������ �����ϴ�.");
			me.set("command.general.cant.CANT_FINT_USER", "��c�ش� ������ ã������ �����ϴ�.");
			me.set("command.general.cant.CANT_CONSOLE_USE_THIS_COMMAND", "��c�ܼ��� �ش� ��ɾ��� ����� �Ұ����մϴ�.");

			me.set("command.general.etc.NEXT_MESSAGE", "��6���� ����� ������ ��c/<cmd> <index>");
			me.set("command.general.etc.LIST_INDEX_MESSAGE", "��c<n>��6���� ����� ã�ҽ��ϴ�. ��c<index>��6/��c<all>");
			me.set("command.general.etc.LIST_INDEX", "��c<index>: ��6<message>");
			me.set("command.general.etc.STATS_LORE_NOW", "��6���� ����: ��c<point>��6/��c<max>");
			me.set("command.general.etc.ALREADY_HAS_STATS_NAME", "��c�̹� �����ϴ� ������ �̸��Դϴ�.");
			me.set("command.general.etc.PLZ_ENTER_CORRECT_X_Y", "��cX��6���� ��c1~9��6�� ��cY��6���� ��c1~3��6�� �Է��Ͻʽÿ�.");
			me.set("command.general.etc.INVENTORY_NAME", "��c<name>��6���� ����");
			me.set("command.general.etc.NO_RELEASE", "��c<name>��6���� ���� �������δ� ��cFalse��6�Դϴ�.");
			me.set("command.general.etc.AVILABLESTATS", "��6���� ����: ��c<point>");
			me.set("command.general.etc.RUN_CRITICAL", "��cũ��Ƽ�� ��6������!");
			me.set("command.general.etc.RUN_BREAK", "��6�� ��c��� �ι�!");
			me.set("command.general.etc.RUN_PLACE", "��6������ ��c����!");
			me.set("command.general.etc.RUN_ITEM", "��6���� ��c����!");
			me.set("command.general.etc.INFINITE", "Infinite");
			me.set("command.general.etc.AUTO_SAVE", "��c[RsStats] ��6[����, ����] ������ �ڵ� ���� �Ϸ�");

			me.set("command.stsadmin.general.SUCCESSFULLY_ADD_STATS", "��6���������� ��c���ݡ�6�� �߰��߽��ϴ�.");
			me.set("command.stsadmin.general.SUCCESSFULLY_EDIT_STATS", "��6���������� ��c���ݡ�6�� �����߽��ϴ�.");
			me.set("command.stsadmin.general.SUCCESSFULLY_REMOVE_STATS", "��6���������� ��c���ݡ�6�� �����߽��ϴ�.");
			me.set("command.stsadmin.general.SUCCESSFULLY_ADDLORE_STATS", "��6���������� ��clore��6�� �߰��߽��ϴ�.");
			me.set("command.stsadmin.general.SUCCESSFULLY_REMOVELORE_STATS", "��6���������� ��clore��6�� �������ϴ�.");
			me.set("command.stsadmin.general.SUCCESSFULLY_SETITEM_STATS", "��6���������� ��c������ �ڵ��6�� �����߽��ϴ�.");
			me.set("command.stsadmin.general.SUCCESSFULLY_SETITEMNAME_STATS", "��6���������� ��c������ �̸���6�� �����߽��ϴ�.");
			me.set("command.stsadmin.general.SUCCESSFULLY_SETMAX_STATS", "��6���������� ��c�ִ� ���ݷ���6�� �����߽��ϴ�.");

			me.set("command.sts.general.SUCCESSFULLY_SET_RELEASE", "��6���������� ���� ���� ���θ� ��c<release>��6�� �����߽��ϴ�.");
			me.set("command.stsgive.general.STATS_GIVE_MESSAGE", "��6����� ��c<point>��6��ŭ ���� ����Ʈ�� �޾ҽ��ϴ�.");

			me.set("command.stsuser.general.SUCCESSFULLY_ADD_POINT", "��6���������� �ش� ������ ���� ����Ʈ�� �߰��߽��ϴ�.");
			me.set("command.stsuser.general.SUCCESSFULLY_SET_POINT", "��6���������� �ش� ������ ���� ����Ʈ�� �����߽��ϴ�.");
			me.set("command.stsuser.general.VIEW_USER_STATS", "��c<stats> ��6>> ��c<point>");
			me.set("command.stsuser.general.SUCCESSFULLY_RESET_POINT", "��6���������� �ش� ������ ���� ����Ʈ�� �ʱ�ȭ�߽��ϴ�.");
			me.set("command.stsuser.general.SUCCESSFULLY_REMOVE_POINT", "��6���������� �ش� ������ ��� ���� ����Ʈ�� �����߽��ϴ�.");

			me.set("command.stsadmin2.general.INCORRECT_BONUS_TYPE", "��c�ùٸ� ���ʽ� �̸��� �Է��Ͻʽÿ�.");
			me.set("command.stsadmin2.general.SUCCESSFULLY_SET_BONUS", "��6���������� ���� ���ʽ��� �Է��߽��ϴ�.");
			me.set("command.stsadmin2.general.SUCCESSFULLY_RELOAD", "��6���������� ������ ���ε��߽��ϴ�.");
			me.set("command.stsadmin2.general.SUCCESSFULLY_SAVE", "��6���������� ������ �����߽��ϴ�.");
			me.set("command.stsadmin2.general.VIEW_STATS_BONUS", "��6<type>: ��c<bonus>");
			me.set("command.stsadmin2.general.INCORRECT_FILE_NAME", "��c�ùٸ� ���� �̸��� �Է��Ͻʽÿ�.");
			me.set("command.stsadmin2.general.KICK_MESSAGE", "��c[RsStats] ��6������ ���� �ε�� �������� ���Ͽ� ������ �߹��մϴ�.");

			me.set("command.stscmd.general.SUCCESSFULLY_CMD_SET", "��6���������� ��ɾ �����߽��ϴ�.");
			me.set("command.stscmd.general.SUCCESSFULLY_CMD_REMOVE", "��6���������� ������ ��ɾ �����߽��ϴ�.");
			me.set("command.stscmd.general.INCORRECT_CMD_TYPE", "��c�ùٸ��� ���� ��ɾ� Ÿ���Դϴ�.");

			me.set("command.stsupdate.general.CANT_FIND_UPDATE_LOG", "��c������Ʈ �α׸� ã������ �����ϴ�.");
		} else if (Main.lang.equals("us")) {
	
		}
		me.set("command.stsupdate.general.PLUGINLOG1", "��6<version>:");
		me.set("command.stsupdate.general.PLUGINLOG2", "  - ��c<log>");

		me.set("command.stscmd.general.STSCMD_TYPE", " - ��6<stats>");
		me.set("command.stscmd.general.STSCMD_CMD", "��c<index>: ��6<cmd>");

		me.saveYaml();
	}
}
