package ghozti.frc.framework.frameworkutils.commands;

import ghozti.frc.framework.frameworkutils.commands.Command;

public class SequentialCommandGroup {

    void addCommands(Command... commands){
        for(Command c : commands){
            c.init();
            if (!c.isFinished()){
                c.execute();
            }else {
                c.end();
            }
        }
    }
}
