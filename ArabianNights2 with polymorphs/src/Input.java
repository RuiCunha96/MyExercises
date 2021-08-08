import java.util.Scanner;

public class Input {
    static Scanner scan = new Scanner(System.in);

    public static boolean yesNo(){
        String answer = scan.next();
        while (!answer.toUpperCase().equals("NO") && !answer.toUpperCase().equals("YES") && !answer.toUpperCase().equals("N") && !answer.toUpperCase().equals("Y")){
            System.out.println("Repeat answer.");
            answer = scan.next();
        }
        if(answer.toUpperCase().equals("NO") || answer.toUpperCase().equals("N")){
            return false;
        }
        else{return true;}
    }
    public static String wish(){
        System.out.println("What do you wish for?");
        String answer = scan.next();
        return answer;

    }

    public static int choice(){
        System.out.println("What You want?\n1) Wish?\n2) Recharge Lamp\n3) Leave me be?");
        int answer = scan.nextInt();
        while(answer != 1 && answer != 2 && answer != 3 ){
            System.out.println("Repeat!");
                answer = scan.nextInt();
        }
        return answer;
    }

    public static int mainMenu(){
        System.out.println("What to do?\n1) Rub\n2) Lamp info\n3) Exit");
        int answer = scan.nextInt();
        while (answer != 1 && answer !=2 && answer !=3){
            answer = scan.nextInt();
        }
        return answer;
    }

}
