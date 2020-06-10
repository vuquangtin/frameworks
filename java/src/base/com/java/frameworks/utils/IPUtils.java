package com.java.frameworks.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.apache.log4j.Logger;
/**
 * 
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin">https://github.com/vuquangtin
 *      </a>
 *
 */

public class IPUtils {
    static Logger logger = Logger.getLogger(IPUtils.class.getName());
    // private static IPInfor currentIPInfor = null;
    private static String IP_LOCAL = "127.0.0.1";
    public static int IP_LOCAL_NUMBER = 127001;
    // private static int ID_LOCAL = 0;
    // private static int ID_DEFAULT = 100;
    // private final static String FILE_CONF = "conf/sever_id.txt";
    private static String CURRENT_IP = null;

    public static void refeshIp() {
        CURRENT_IP = null;
    }

    public static void main(String[] args) throws Exception {
        if (logger.isDebugEnabled())
            logger.debug("Your Host addr: " + InetAddress.getLocalHost().getHostAddress()); // often
        // returns
        // "127.0.0.1"
        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        for (; n.hasMoreElements(); ) {
            NetworkInterface e = n.nextElement();

            Enumeration<InetAddress> a = e.getInetAddresses();
            for (; a.hasMoreElements(); ) {
                InetAddress addr = a.nextElement();
                if (logger.isDebugEnabled())
                    logger.debug("  " + addr.getHostAddress());
            }
        }
        if (logger.isDebugEnabled())
            logger.debug(generateUnique());

        String A = "fe80:0:0:0:f816:3eff:feb9:bded%2";
        if (A.matches(".*:.*")) {
            if (logger.isDebugEnabled())
                logger.debug("true");
        } else if (logger.isDebugEnabled())
            logger.debug("false");
    }

    public static String getCurrentIPString() {
        // if(true)
        // return "10536116";
        //if (logger.isDebugEnabled())
        //	logger.debug("CURRENT_IP == " + CURRENT_IP);
        if (CURRENT_IP == null) {
            if (logger.isDebugEnabled())
                logger.debug("CURRENT_IP == null");
            // Any address in the range 127.xxx.xxx.xxx is a "loopback" address.
            // It
            // is only visible to "this" host.
            // Any address in the range 192.168.xxx.xxx is a private (aka site
            // local) IP address. These are reserved for use within an
            // organization.
            // The same applies to 10.xxx.xxx.xxx addresses, and 172.16.xxx.xxx
            // through 172.31.xxx.xxx.
            // Addresses in the range 169.254.xxx.xxx are link local IP
            // addresses.
            // These are reserved for use on a single network segment.
            // Addresses in the range 224.xxx.xxx.xxx through 239.xxx.xxx.xxx
            // are
            // multicast addresses.
            // The address 255.255.255.255 is the broadcast address.
            // Anything else should be a valid public point-to-point IPv4
            // address.
            // String ip = null;

            try {

                Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
                for (; n.hasMoreElements(); ) {
                    NetworkInterface e = n.nextElement();

                    Enumeration<InetAddress> a = e.getInetAddresses();
                    for (; a.hasMoreElements(); ) {
                        InetAddress addr = a.nextElement();
                        if (logger.isDebugEnabled())
                            logger.debug("addr.getHostAddress:= " + addr.getHostAddress());
                        if (addr.getHostAddress().matches("(172\\.|127\\.|192\\.168\\.|169\\.254\\.|224\\.|239\\.|255\\.).*")) {
                            // Logs.infoTerminalNoCheck(" continue:" +
                            // addr.getHostAddress());
                            //CURRENT_IP = addr.getHostAddress();
                            continue;
                        }
                        if (addr.getHostAddress().matches(".*:.*")) {
                            // fe80:0:0:0:f816:3eff:feb9:bded%2
                            // 0:0:0:0:0:0:0:1%1
                            continue;
                        }
                        CURRENT_IP = addr.getHostAddress();
                        if (logger.isDebugEnabled())
                            logger.debug("ip:" + addr.getHostAddress());

                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (CURRENT_IP == null) {
                try {
                    InetAddress IP = InetAddress.getLocalHost();
                    if (logger.isDebugEnabled())
                        logger.debug("IP of my system is := " + IP.getHostAddress());
                    CURRENT_IP = IP.getHostAddress();
                    if (CURRENT_IP.matches("(127\\.|192\\.168\\.|169\\.254\\.|224\\.|239\\.).*")) {
                        logger.debug(" continue:" + IP.getHostAddress());
                        CURRENT_IP = IP_LOCAL;

                    }
                    if (logger.isDebugEnabled())
                        logger.debug("CURRENT_IP:" + CURRENT_IP);
                    return CURRENT_IP;
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
        return CURRENT_IP;
    }

    public static int generateUnique() {
        if (logger.isDebugEnabled())
            logger.debug("generateUnique");
        int ip = 0;
        try {
            ip = getCurrentIP();
        } catch (Exception e) {
        	logger.error(Common.EXCEPTION_MESSAGE + e);
            e.printStackTrace();
        }

        if (ip == 0) {
            if (logger.isDebugEnabled())
                logger.debug("ip == 0");
            return Integer.parseInt(IP_LOCAL.replaceAll("\\.", ""));

        }
        if (logger.isDebugEnabled())
            logger.debug("ip == " + ip);
        return ip;
    }

    public static int getCurrentIP() {
        String ip = getCurrentIPString();
        return getCurrentIP(ip);

    }

    public static boolean isLocalHost() {
        String ip = getCurrentIPString();
        return getCurrentIP(ip) == IP_LOCAL_NUMBER;

    }

    public static int getCurrentIP(String ip) {
        if (ip != null)
            return Integer.parseInt(ip.replaceAll("\\.", ""));
        else
            return 0;

    }
    // private static List<IPInfor> getList() {
    // List<IPInfor> list = new ArrayList<IPInfor>();
    // list.add(new IPInfor(IP_LOCAL, readLine()));
    // if (ConfigSingleton.getInstance().getConfig().get("apps.run.listserver",
    // "") != "") {
    // if (logger.isDebugEnabled())
    // logger.debug(
    // "apps.run.listserver::" +
    // ConfigSingleton.getInstance().getConfig().get("apps.run.listserver"));
    // String[] ips =
    // ConfigSingleton.getInstance().getConfig().get("apps.run.listserver").split("|");
    // int i = 1;
    // for (String string : ips) {
    // list.add(new IPInfor(string, i++));
    // }
    // // list.add(new IPInfor(IP_LOCAL, ID_DEFAULT));
    // } else {
    //
    // // list.add(new IPInfor("10.3.34.66", 1));
    // // list.add(new IPInfor("10.3.24.215", 37));
    // list.add(new IPInfor(IP_LOCAL, readLine()));
    // }
    // return list;
    // }

    // private static int readLine() {
    // return Line.readIntLine(FILE_CONF, true);
    //
    // }
}
