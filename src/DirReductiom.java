import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/*rite a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

The Haskell version takes a list of directions with data Direction = North | East | West | South. The Clojure version returns nil when the path is reduced to nothing. The Rust version takes a slice of enum Direction {NORTH, SOUTH, EAST, WEST}.

Another solution
public static String[] dirReduc(String[] arr) {
      List<String> dirs = new ArrayList<String>(Arrays.asList(arr));
      for (int i = 0; i + 1 < dirs.size(); i++) {
        if ("NORTHSOUTH,SOUTHNORTH,EASTWEST,WESTEAST".contains(dirs.get(i) + dirs.get(i + 1))) {
          dirs.remove(i + 1);
          dirs.remove(i);
          i = -1;
        }
      }
      return dirs.toArray(new String[dirs.size()]);
    }
 */

public class DirReductiom {
    public static void main(String[] args) {
        Assert.assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        Assert.assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
    }

    public static String[] dirReduc(String[] arr) {
        List<String> listDir = new ArrayList<>(Arrays.asList(arr));
        String strDir = listDir.stream().map(e -> e = e + "1").collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();

        String[] matches = {"NORTH1SOUTH1", "SOUTH1NORTH1", "EAST1WEST1", "WEST1EAST1"};
        while (strDir.contains("NORTH1SOUTH1") || strDir.contains("SOUTH1NORTH1") || strDir.contains("EAST1WEST1") || strDir.contains("WEST1EAST1")){
            for (String str: matches) {

                strDir = strDir.replace(str, "").trim();
                System.out.println(strDir);
            }
        }
        return strDir.trim().isEmpty()? new String[0] : strDir.split("1");
        }
    }
