/**
 * Created by zk on 2016/6/19.
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = null;
        String[] v2 = null;

        if(version1.contains(".")) {
            v1 = version1.split("\\.");
        }else {
            v1 = new String[]{version1};
        }
        if(version2.contains(".")) {
            v2 = version2.split("\\.");
        }else {
            v2 = new String[]{version2};
        }

        int len = v1.length < v2.length ? v1.length: v2.length;
        for(int i = 0; i < len; i++) {
            if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                return -1;
            }else if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                return 1;
            }else {
                if(i == len - 1) {
                    if(v1.length > len) {
                        int j = len;
                        while(j < v1.length) {
                            if(Integer.parseInt(v1[j]) != 0) {
                                return 1;
                            }else {
                                j++;
                            }
                        }
                    }else if(v2.length > len) {
                        int k = len;
                        while(k < v2.length) {
                            if(Integer.parseInt(v2[k]) != 0) {
                                return -1;
                            }else {
                                k++;
                            }
                        }
                    }
                    return 0;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        compareVersion("1.0.1", "1");
    }
}
