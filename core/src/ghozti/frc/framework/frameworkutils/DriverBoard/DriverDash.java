package ghozti.frc.framework.frameworkutils.DriverBoard;

public class DriverDash {

    private static int score;
    private static String robotName;
    private static float[] coordinates;

    public static void addToScore(int s){
        score += s;
    }

    public static void setName(String name){
        robotName = name;
    }

    public static void addX(int x){
        coordinates[0] += x;
    }

    public static void addY(int y){
        coordinates[1] += y;
    }

    public static int getScore(){
        return score;
    }

    public static String getRobotName(){
        return robotName;
    }

    public static float getX(){
        return coordinates[0];
    }

    public static float getY(){
        return coordinates[1];
    }

    public static void display(){
        //do font shit
    }
}
