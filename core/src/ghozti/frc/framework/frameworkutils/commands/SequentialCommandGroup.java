package ghozti.frc.framework.frameworkutils.commands;

import java.util.ArrayList;
import java.util.Arrays;

public class SequentialCommandGroup {

    protected static void addCommands(Command... commands){
        command_lst.addAll(Arrays.asList(commands));
    }

    static ArrayList<Command> command_lst = new ArrayList<>();
    static boolean newCommandInit = true;
    static int currentInd = 0;

    public static void executeCommands(){

        if (newCommandInit){
            command_lst.get(currentInd).init();
            newCommandInit = false;
        }

        if (!command_lst.get(currentInd).isFinished()){
            command_lst.get(currentInd).execute();
            executeCommands();
        }else{
            command_lst.get(currentInd).end();
            newCommandInit = true;
            currentInd++;
        }
    }

    public static int getListSize(){
        return command_lst.size();
    }

    public static int getCurrentIndex(){
        return currentInd;
    }
}
