package main.java.SecurityManagerPackage;

import org.junit.jupiter.api.Test;

import java.security.Permission;

/**
 * Created by gerry on 8/4/2017.
 */
public class SystemExitControl extends SecurityManager{
    public static class ExitTrappedException extends SecurityException {
    }

    public static void forbidSystemExitCall() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }

    public static void enableSystemExitCall() {
        System.setSecurityManager(null);
    }
}
