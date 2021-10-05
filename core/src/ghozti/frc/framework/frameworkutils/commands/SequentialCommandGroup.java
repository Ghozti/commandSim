package ghozti.frc.framework.frameworkutils.commands;

import java.util.ArrayList;
import java.util.Arrays;

public class SequentialCommandGroup {

    ArrayList<Command> command_lst = new ArrayList<>();

    protected void addCommands(Command... commands){
        command_lst.addAll(Arrays.asList(commands));
    }

    public void executeCommands(){
        boolean newCommandInit = true;
        for(int i = 0; i < command_lst.size(); i+=0){

            if (newCommandInit){
                command_lst.get(i).init();
                newCommandInit = false;
            }

            if (!command_lst.get(i).isFinished()){
                command_lst.get(i).execute();
                executeCommands();
            }else{
                command_lst.get(i).end();
                newCommandInit = true;
                i++;
            }
        }
    }
}
