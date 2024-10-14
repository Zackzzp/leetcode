import java.util.*;

public class GroupAngrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hashTable=new HashMap<>();
        for (String str:strs){
            char []array=str.toCharArray();
            Arrays.sort(array);
            String key=new String(array);
            List<String> data=hashTable.getOrDefault(key,new ArrayList<String>());
            data.add(str);
            hashTable.put(key,data);
        }
        return new ArrayList<List<String>>(hashTable.values());

    }
}
