/*
Given a string queryIP, return "IPv4" if IP is a valid IPv4 address,
 "IPv6" if IP is a valid IPv6 address or "Neither" if IP is not a correct IP of any type.

A valid IPv4 address is an IP in the form "x1.x2.x3.x4" where 0 <= xi <= 255 and 
xi cannot contain leading zeros. For example, "192.168.1.1" and "192.168.1.0" are 
valid IPv4 addresses while "192.168.01.1", "192.168.1.00", and "192.168@1.1" are invalid IPv4 addresses.

A valid IPv6 address is an IP in the form "x1:x2:x3:x4:x5:x6:x7:x8" where:

1 <= xi.length <= 4
xi is a hexadecimal 
string which may contain digits, lowercase English letter
 ('a' to 'f') and upper-case English letters ('A' to 'F').
Leading zeros are allowed in xi.
For example, "2001:0db8:85a3:0000:0000:8a2e:0370:7334" and
 "2001:db8:85a3:0:0:8A2E:0370:7334" are valid IPv6 addresses, while
  "2001:0db8:85a3::8A2E:037j:7334" and "02001:0db8:85a3:0000:0000:8a2e:0370:7334" are invalid IPv6 addresses. */


/*
 * Input: queryIP = "172.16.254.1"
Output: "IPv4"
Explanation: This is a valid IPv4 address, return "IPv4".

Input: queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
Output: "IPv6"
Explanation: This is a valid IPv6 address, return "IPv6".

Input: queryIP = "256.256.256.256"
Output: "Neither"
Explanation: This is neither a IPv4 address nor a IPv6 address.
 */




import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
 class Solution{
    public String validIPAddress(String queryIP) {
        if(isValidIPv4(queryIP))
            return "IPv4";
        else if(isValidIPv6(queryIP))
            return "IPv6";

        return "Neither";

    }

    public static boolean isValidIPv4(String ip)
    {
         String parts
            = "^([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        String regex
            = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
        Pattern checkIp = Pattern.compile(regex);

        if (ip == null)
            return false;
        Matcher m = checkIp.matcher(ip);
        return m.matches();
    }
    public static boolean isValidIPv6(String ip)
    {
         String regex
            = "^(?:[A-F0-9]{1,4}:){7}[A-F0-9]{1,4}$";
        Pattern checkIp= Pattern.compile(regex,Pattern.CASE_INSENSITIVE);

        if (ip == null)
            return false;
        Matcher m = checkIp.matcher(ip);
        return m.matches();
    }

}

class ValiDateIp{
public static void main(String args[]){
    Scanner inp=new Scanner(System.in);
    Solution sol=new Solution();
    String queryIp=inp.next();
    System.out.print(sol.validIPAddress(queryIp));
    }
}