package sktvp18library;

import classes.App;

/**
 *
 * @author User
 */
public class SKTVp18Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String flag = "base";
        if(args != null){
            flag = args[0];
        }
        App app = new App(flag);
        app.run();
        }
   }
