package main.java.SecurityManagerPackage;

import java.security.Permission;

/**
 * Created by gerry on 8/4/2017.
 */
public class StopExitSecurityManager extends SecurityManager{
    private SecurityManager _prevMgr = System.getSecurityManager();

    public void checkPermission(Permission perm)
    {
    }

    public void checkExit(int status)
    {
        super.checkExit(status);
        try {
            throw new ExitTrappedException("System exit invoked"); //This throws an exception if an exit is called.
        } catch (ExitTrappedException e) {

        }
    }

    public SecurityManager getPreviousMgr() { return _prevMgr; }
}
