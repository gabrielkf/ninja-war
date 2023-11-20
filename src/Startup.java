public class Startup
{
    private static final String Title = "Ninja War";
    private static final int ScreenWidth = 1300;
    private static final int ScreenHeight = 700;
    
    public static void main(String[] args)
    {
        var backGround = new NinjaVillage(
                ScreenWidth,
                ScreenHeight,
                0,
                0);
        
        var weapon = new Shuriken(ScreenWidth, ScreenHeight);
        
        var target = new Ninja(ScreenWidth, ScreenHeight);
        
        new Screen(backGround, weapon, target, Title);
    }
}
