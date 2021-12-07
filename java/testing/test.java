package testing;

class test{
    public static void main(String[] args) {
        String regex = "[Employee]+.?";
        String str = "Employee";
        System.out.println(str.matches(regex));
    }
}