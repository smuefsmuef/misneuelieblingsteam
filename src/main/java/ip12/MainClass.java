package ip12;

import ip12.DemoApp.DemoApp;
import ip12.Pong.PongApp;
import ip12.ws2cQlockTwo.QlockTwoStarterApp;
import processing.core.PApplet;

public class MainClass extends PApplet {
    public static void main(String[] args){
        //define which ProcessingApp should run on start (also import it)

        //PApplet.main(DemoApp.class, args);
        //PApplet.main(PongApp.class, args);
        PApplet.main(QlockTwoStarterApp.class, args);
    }
}
