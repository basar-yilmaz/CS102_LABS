class Apple {
// N = 29, k = 5, a = 10 => true
// N = 75, k = 25, a = 7 => false
// N = 74, k = 30, a = 16 => true
// N = 75, k = 25, a = 0 => false
// N = 75, k = 75, a = 0 => true

    public static void main(String[] args) {
        System.out.println(apple(12, 4, 3));
        System.out.println(apple(29, 5, 10));
        System.out.println(apple(75, 25, 7));
        System.out.println(apple(74, 30, 16));
        System.out.println(apple(75, 25, 0));
        System.out.println(apple(75, 75, 0));
        
    }

    public static boolean apple(int n, int k, int a) {
        if (n == k) {
            return true;
        }
        if (a == 0) {
            return false;
        }
        return apple(n-2, k, a-1) || apple(n-3, k, a-1);
    }
}