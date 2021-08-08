public class RecyclableDemon extends Genie {
    boolean recycled = false;
    boolean leave = false;


    @Override
    public Genie grantWish() {

        while(!leave) {
            System.out.println("I'm the Recyclable Demon! Hello!!\n");
            Input.wish();
            decrementWishesGranted();

            int choice = Input.choice();
            switch (choice){
                case 1:
                    grantWish();
                case 2:
                    leave = true;
                    return this;
                case 3:
                    leave = false;
                    return null;
            }

        }
        return null;
    }


}
