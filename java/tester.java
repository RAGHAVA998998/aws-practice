import jdk.dynalink.beans.StaticClass;
import jdk.internal.joptsimple.internal.Rows;

class teser{
    public static void rectpattern(int row, int column){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=column;j++){
                System.out.print("*");
            } System.out.println();
        }}
        public static void righttrianglepattern(int row){
            for(int i=0;i<row;i++){
                for(int j=0;j<=i;j++){
                    System.out.print("*");
                }System.out.println();
            }
        }
    

    public static void main(String[] args) {
        rectpattern(4, 3);
        righttrianglepattern(4);
    }
}