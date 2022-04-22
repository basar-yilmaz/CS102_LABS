package lab5;
public class WordConverter {



    public static void main(String[] args) {
        System.out.printf("%s: %d %s\n","Should return 0",convert("plane", "plane"), "change(s) should be done.");
        System.out.printf("%s: %d %s\n","Should return 2",convert("exclamation", "excavation"), "change(s) should be done.");
        System.out.printf("%s: %d %s\n","Should return 3",convert("inquire", "ensure"), "change(s) should be done.");
        System.out.printf("%s: %d %s\n","Should return 3",convert("car", "race"), "change(s) should be done.");
        System.out.printf("%s: %d %s\n","Should return 3",convert("sunday", "saturday"), "change(s) should be done.");
        System.out.printf("%s: %d %s\n","Should return 5",convert("patates", "patlican"), "change(s) should be done.");
        System.out.printf("%s: %d %s\n","Should return 3",convert("tate", "patates"), "change(s) should be done.");

    }


    // find the index of the first different char
    public static int findUncommonIndex(String a, String b) {
        int index = 0;
        int len = b.length();
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                index = i;
                break;
            }
        }
        return index;
    }

    // substitute the first different char as it appears in b 
    public static String substitute(String a, String b) {
        int index = findUncommonIndex(a, b);
        StringBuilder sb = new StringBuilder();
        if(index == 0) {
            sb.append(b.charAt(0));
            sb.append(a.substring(1));
        }
        else {
            sb.append(a.substring(0, index));
            sb.append(b.charAt(index));
            sb.append(a.substring(index + 1));
        }
        return sb.toString();
    }

    // create new string without the first different char 
    public static String create1(String a, String b) {
        int index = findUncommonIndex(a, b);
        StringBuilder sb = new StringBuilder();
        sb.append(a.substring(0, index));
        sb.append(a.substring(index+1, a.length()));
        return sb.toString();
    }

    public static String create2(String a, String b) {
        int index = findUncommonIndex(a, b);
        StringBuilder sb = new StringBuilder();
        sb.append(a.substring(0, index));
        sb.append(b.charAt(index));
        sb.append(a.substring(index, a.length()));
        return sb.toString();
    }

    // recursive convert method 'a' to 'b'
    public static int convert(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        
        if (a.equals(b)) {
            return 0;
        }

        if (aLen > bLen) {
            if (a.substring(0, bLen).equals(b)) {
                return aLen-bLen;
            }
            return Math.min(1 + convert(create1(a, b), b), 1 + convert(substitute(a, b), b));
        }
        if (aLen < bLen) {
            if (b.substring(0, aLen).equals(a)) {
                return bLen-aLen;
            }
            return Math.min(1 + convert(create2(a, b), b), 1 + convert(substitute(a, b), b));
        }
        
        if (aLen == bLen) {
            return 1 + convert(substitute(a, b), b);
        }

        return 0;
    }
}