public class FriendlyGenie extends Genie{



    @Override
    public Genie grantWish() {
        if(getWishesGranted()<0){
            System.out.println("No more wishes");
            return this;
        }
        while(getWishesGranted()>0) {
            System.out.println("I'm the friendly genie!\n");
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
