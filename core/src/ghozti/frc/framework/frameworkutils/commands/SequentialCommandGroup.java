package ghozti.frc.framework.frameworkutils.commands;

import java.util.ArrayList;
import java.util.Arrays;

public class SequentialCommandGroup {

    protected void addCommands(Command... commands){
        command_lst.addAll(Arrays.asList(commands));
    }

    ArrayList<Command> command_lst = new ArrayList<>();
    boolean newCommandInit = true;
    int currentInd = 0;

    public void executeCommands(){

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

    public int getListSize(){
        return command_lst.size();
    }

    public int getCurrentIndex(){
        return currentInd;
    }
}
