public class ArabiaNights {

    public static void main(String[] args) {
        boolean runTime=true;

        Lamp lamp = new Lamp();
        while(runTime){

            int mainMenu=Input.mainMenu();
            switch (mainMenu){
                case 1:
                    //rub
                    Genie genie = lamp.rub();
                    lamp.ask4Wish(genie);
                    break;
                case 2:
                    //lamp info
                    lamp.lampInfo();
                    break;
                case 3:
                    runTime=false;
            }

        }


    }
}
