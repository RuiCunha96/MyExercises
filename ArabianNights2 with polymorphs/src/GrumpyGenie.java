public class GrumpyGenie extends  Genie{


    @Override
    public Genie grantWish() {
        if(getWishesGranted()<getWishes()){
            System.out.println("No more wishes!!");
            return this;
        }
        while(getWishesGranted()>0) {
            System.out.println("I'm the grumpy genie!\n");
            Input.wish();
            decrementWishesGranted();
            System.out.println("Do you want another wish ? [y/n]\nyou have " + getWishesGranted() + " wishes left!");
            boolean yesNo = Input.yesNo();
            if (!yesNo) {
                return this;
            }
            grantWish();
        }
        return this;
    }
}
