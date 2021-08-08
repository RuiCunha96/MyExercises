public class RandomSetter {
    private static int maxGenieNumber = 4;
    private static int maxWishesNumber = 3;

    public static int maxGenieRandomizer(){
        int random = (int)(Math.random()*maxGenieNumber);
        while(random == 0){
            random = (int)(Math.random()*maxGenieNumber);
        }
        return random;
    }

    public static int maxWishesRandomizer(){
        int random = (int)(Math.random()*maxWishesNumber);
        while(random == 0){
            random = (int)(Math.random()*maxWishesNumber);
        }
        return random;
    }

}
