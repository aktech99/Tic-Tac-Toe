import java.util.*;

class tictac{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[][] = new int[3][3];
        for(int i[] : a){
            Arrays.fill(i,-1);
        }
        boolean vis[][] = new boolean[3][3];
        boolean pvis[][] = new boolean[3][3];
        //printgrid(3,a);
        System.out.println("Player 1 name: ");
        String x = sc.next();
        System.out.println("Player 2 name: ");
        String y = sc.next();
        int xs=0;
        int ys=0;
        int visc =0;
        int chanc=0;
        while(visc<9){
        System.out.println(x+": "+xs+y+": "+ys);
        printgrid(3,a);
        System.out.println(chanc%2==0?x+"'s turn : ":y+"'s turn :");
        int xc = sc.nextInt();
        int yc = sc.nextInt();
        if(!valid(xc,yc))System.out.println("Enter a valid index");
        else if(vis[xc][yc])System.out.println("Enter an index which isn't visited");
        else{
            a[xc][yc]=chanc%2==0?1:0;
            vis[xc][yc]=true;
            visc++;
            if(!pvis[xc][yc] && check(a,pvis)){
                if(chanc%2==0)xs++;else ys++;
            }
            chanc++;
        }
    }
    System.out.println(x+": "+xs+y+": "+ys);
    printgrid(3,a);
    if(xs>ys)System.out.println(x+" has Won!");
    else if(xs<ys)System.out.println(y+"has Won!");
    else System.out.println("It's a Draw");
    System.out.println("Game Over");

    }
    public static void printline(int n){
        for(int i=0;i<n;i++){
            System.out.print("+-----");
        }
        System.out.println("+");
    }
    public static void printnum(int n,int a[]){
        for(int i=0;i<n;i++){
            if(a[i]==-1)
            System.out.print("|    ");
            else{
                System.out.print("|  "+(a[i]==0?"O":"X")+"  ");
            }
        }
        System.out.println("|    ");
    }
    public static void printgrid(int n,int a[][]){
        for(int i=0;i<n;i++){
            printline(n);
            //System.out.println();
            printnum(n,a[i]);
            //System.out.println();
        }
        printline(n);
    }
    public static boolean valid(int x,int y){
        return x>=0 && x<3 && y>=0 && y<3;
    }
    public static boolean check(int a[][],boolean pvis[][]){
        if(a[0][1]==a[0][2] && a[0][1]==a[0][0] && a[0][1]!=-1){
            pvis[0][0]=true;
            pvis[0][1]=true;
            pvis[0][2]=true;
            return true;
        }
        if(a[1][1]==a[1][2] && a[1][1]==a[1][0] && a[1][1]!=-1){
            pvis[1][0]=true;
            pvis[1][1]=true;
            pvis[1][2]=true;
            return true;
        }
        if(a[0][0]==a[1][0] && a[0][0]==a[2][0] && a[0][0]!=-1){
            pvis[0][0]=true;
            pvis[1][0]=true;
            pvis[2][0]=true;
            return true;
        }
        if(a[0][1]==a[1][1] && a[0][1]==a[2][1] && a[0][1]!=-1){
            pvis[0][1]=true;
            pvis[1][1]=true;
            pvis[2][1]=true;
            return true;
        }
        if(a[0][2]==a[1][2] && a[0][2]==a[2][2] && a[0][2]!=-1){
            pvis[0][2]=true;
            pvis[1][2]=true;
            pvis[2][2]=true;
            return true;
        }
        if(a[2][1]==a[2][2] && a[2][1]==a[2][0] && a[2][1]!=-1){
            pvis[2][0]=true;
            pvis[2][1]=true;
            pvis[2][2]=true;
            return true;
        }
        if(a[1][1]==a[2][2] && a[0][0]==a[1][1] && a[1][1]!=-1){
            pvis[0][0]=true;
            pvis[1][1]=true;
            pvis[2][2]=true;
            return true;
        }
        if(a[2][0]==a[1][1] && a[0][2]==a[1][1] && a[1][1]!=-1){
            pvis[2][0]=true;
            pvis[1][1]=true;
            pvis[0][2]=true;
            return true;
        }
        return false;
    }
}