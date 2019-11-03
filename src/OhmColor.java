public class OhmColor {
    public static void main(String[] args) {

    }

    public static String encodeResistorColors(String ohmsString) {
        int black = 0, brown = 1, red = 2, orange = 3, yellow = 4, green = 5,blue = 6, violet = 7, gray = 8, white = 9;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ohmsString.split(" ")[0].length(); i++) {
            for (char c : ohmsString.split(" ")[0].toCharArray()) {
                switch (c){
                    case 0:
                       sb.append(black);
                }
            }
        }
        return null;
    }
}
