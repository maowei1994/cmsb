package com.hj.biz.util;

import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * ������ѡ��ǰ��̨ת��������
 *
 * @author tinglang (editice@gmail.com)
 * @since 2015/3/22  20:56
 */
public class DropBoxUtil {
    public static String filterOption(String key) {
        if (StringUtils.equals(key, "0")) {
            return "";
        }
        return key;
    }

    public static String filterZtOption(String key) {
        if (StringUtils.equals(key, "0")) {
            return "";
        }
        String val = "";
        if ("1".equals(key)) {
            val = "�ѷ���";
        }
        else if ("2".equals(key)) {
            val = "������";
        }
        else if ("3".equals(key)) {
            val = "������";
        }
        else if ("4".equals(key)) {
            val = "�������";
        }
        else if ("5".equals(key)) {
            val = "������";
        }
        else if ("6".equals(key)) {
            val = "������";
        }
        else if ("7".equals(key)) {
            val = "��֤���";
        }
        else if ("8".equals(key)) {
            val = "�ѷ�֪ͨ��";
        }
        else if ("9".equals(key)) {
            val = "��֤����";
        }
        return val;
    }

    public static String filterSqlxOption(String key) {
        if (StringUtils.equals(key, "0")) {
            return "";
        }
        String val = "";
        if ("1".equals(key)) {
            val = "��ҩ";
        }
        else if ("2".equals(key)) {
            val = "����";
        }
        else if ("3".equals(key)) {
            val = "����";
        }
        else if ("4".equals(key)) {
            val = "��������";
        }
        else if ("5".equals(key)) {
            val = "����";
        }
        else if ("6".equals(key)) {
            val = "���й��ұ�׼";
        }
        else if ("7".equals(key)) {
            val = "�ŶӴ�����";
        }
        else if ("8".equals(key)) {
            val = "������ע��";
        }
        else if ("9".equals(key)) {
            val = "��������ע��";
        }
        else if ("10".equals(key)) {
            val = "ҩе��ϲ�Ʒ";
        }
        return val;
    }

    public static void filterDjOption(Map<String, Object> map, String key) {
        if (StringUtils.equals(key, "0")) {
            return;
        }
        String val = "";
        if ("1".equals(key)) {
            val = "����";
        }
        else if ("2".equals(key)) {
            val = "����";
        }
        else if ("3".equals(key)) {
            val = "һ��";
        }
        else if ("4".equals(key)) {
            val = "����";
        }
        else if ("5".equals(key)) {
            val = "����";
        }
        else if ("6".equals(key)) {
            val = "һ��";
        }
        else if ("7".equals(key)) {
            val = "����";
        }
        else if ("8".equals(key)) {
            val = "����";
        }
        else if ("9".equals(key)) {
            val = "һ��";
        }
        map.put("dj", val);
    }

    public static void filterCwsOption(Map<String, Object> map, String key) {
        if (StringUtils.equals(key, "0")) {
            return;
        }
        int f = 0;
        int n = 0;
        if ("1".equals(key)) {
            f = 0;
            n = 99;
        }
        else if ("2".equals(key)) {
            f = 100;
            n = 499;
        }
        else if ("3".equals(key)) {
            f = 500;
            n = 999;
        }
        else if ("4".equals(key)) {
            f = 1000;
            n = Integer.MAX_VALUE;
        }
        map.put("cws_f", f);
        map.put("cws_n", n);
    }

    public static void filterRmzlOption(Map<String, Object> map, String key) {
        if (StringUtils.equals(key, "0")) {
            return;
        }
        int f = 0;
        int n = 0;
        if ("1".equals(key)) {
            f = 0;
            n = 99;
        }
        else if ("2".equals(key)) {
            f = 100;
            n = 999;
        }
        else if ("3".equals(key)) {
            f = 1000;
            n = 4999;
        }
        else if ("4".equals(key)) {
            f = 5000;
            n = Integer.MAX_VALUE;
        }
        map.put("rmzl_f", f);
        map.put("rmzl_n", n);
    }
}
