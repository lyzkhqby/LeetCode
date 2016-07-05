import java.util.ArrayList;
import java.util.List;

/**
 * Created by rotoosoft-d04 on 2016/7/5.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        String result = "/";
        String[] stubs = path.split("/+");
        List<String> paths = new ArrayList<>();
        for (String stub : stubs) {
            if(stub.equals("..")) {
                if(paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            }else if(!stub.equals(".") && !stub.equals("")){
                paths.add(stub);
            }
        }
        for (String item : paths) {
            result += item + "/";
        }
        if(result.length() > 1) result = result.substring(0, result.length() - 1);
        return result;
    }
}

