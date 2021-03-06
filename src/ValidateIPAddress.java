/**
 * Created by zk on 2017/1/18.
 */
public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (isValidIpv4(IP)) return "IPv4";
        else if (isValidIpv6(IP)) return "IPv6";
        else return "Neither";
    }

    private boolean isValidIpv4(String ip) {
        if (ip.length() < 7) return false;
        if (ip.charAt(0) == '.') return false;
        if (ip.charAt(ip.length() - 1) == '.') return false;
        String[] tokens = ip.split("\\.");
        if (tokens.length != 4) return false;
        for (String token : tokens) {
            if (!isValidTokenIpv4(token)) return false;
        }
        return true;
    }

    private boolean isValidTokenIpv4(String token) {
        if (token.startsWith("0") && token.length() > 1) return false;
        try {
            int parsedInt = Integer.parseInt(token);
            if (parsedInt < 0 || parsedInt > 255) return false;
            if (parsedInt == 0 && token.charAt(0) != '0') return false;
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean isValidIpv6(String ip) {
        if (ip.length() < 15) return false;
        if (ip.charAt(0) == ':') return false;
        if (ip.charAt(ip.length() - 1) == ':') return false;
        String[] tokens = ip.split(":");
        if (tokens.length != 8) return false;
        for (String token : tokens) {
            if (!isValidTokenIpv6(token)) return false;
        }
        return true;
    }

    private boolean isValidTokenIpv6(String token) {
        if (token.length() > 4 || token.length() == 0) return false;
        char[] chars = token.toCharArray();
        for (char c : chars) {
            boolean isDigit = (c >= 48 && c <= 57);
            boolean isUpperCaseAF = (c >= 65 && c <= 70);
            boolean isLowerCaseAF = (c >= 97 && c <= 102);
            if (!(isDigit || isUpperCaseAF || isLowerCaseAF)) return false;
        }
        return true;
    }
}
