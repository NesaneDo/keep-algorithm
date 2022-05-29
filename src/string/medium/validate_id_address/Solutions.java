package string.medium.validate_id_address;

/**
 * LeetCode 468. Validate IP Address
 *
 * @author Rondo Chan
 * @version 1.0.0
 * @desc LeetCode 468. Validate IP Address
 * @since 2022/5/29
 */
class Solution {
    private static final String NEITHER = "Neither";

    public String validIPAddress(String queryIP) {
        String[] ipv4 = ("0" + queryIP + "0").split("\\.");
        String[] ipv6 = ("0" + queryIP + "0").split(":");
        if (ipv4.length == 4) {
            ipv4 = queryIP.split("\\.");
        }
        if (ipv6.length == 8) {
            ipv6 = queryIP.split(":");
        }
        if (ipv4.length == 4) {
            return ipv4(ipv4);
        } else if (ipv6.length == 8) {
            return ipv6(ipv6);
        } else {
            return NEITHER;
        }
    }

    String ipv4(String[] ipv4) {
        for (String ip : ipv4) {
            if (ip.length() > 1 && ip.startsWith("0")) {
                return NEITHER;
            }
            try {
                int i = Integer.parseInt(ip);
                if (!(i >= 0 && i <= 255)) {
                    return NEITHER;
                }
            } catch (NumberFormatException e) {
                return NEITHER;
            }
        }
        return "IPv4";
    }

    String ipv6(String[] ipv6) {
        for (String ip : ipv6) {
            if (ip.length() < 1 || ip.length() > 4) {
                return NEITHER;
            }
            for (char c : ip.toCharArray()) {
                if (Character.isDigit(c) || Character.isLetter(c)) {
                    if (Character.isLowerCase(c) && c > 'f') {
                        return NEITHER;
                    } else if (Character.isUpperCase(c) && c > 'F') {
                        return NEITHER;
                    }
                } else {
                    return NEITHER;
                }
            }
        }
        return "IPv6";
    }
}
