import javax.swing.*;
import java.awt.*;
import  java.lang.Math;

/**
 * Created by Nick on 27.06.2017.
 */

public class GraphDraw extends JFrame {

    double PI = 3.14;

    int length;

    int pos[][];

  public  GraphDraw(int n) {
        pos = new int[n][2];
        length = n;

        double angleStep = PI/n;
        double radius = 10*n;

        for (int i = 0; i<n; i++){
            pos[n][0] =  512 + (int)(radius*Math.cos(angleStep*n));
            pos[n][1] =  512 + (int)(radius*Math.sin(angleStep*n));
        }

    }

}

class Window extends JFrame {
    Window() {
        setSize(1024, 1024);
        setVisible(true);

    }

    public void drawPeaks(Graphics g, GraphDraw data) {

        g.setColor(Color.black);

        for (int i =0 ; i<data.length ;i++) {

            g.drawOval(data.pos[i][0],data.pos[i][1],5,5);
        }

    }

    public void drawEdge(Graphics g,GraphDraw data, int p1, int p2, int wg){

        g.setColor(Color.black);

        JLabel wgtxt = new JLabel(Integer.toString(wg));

        g.drawLine(data.pos[p1][0],data.pos[p1][1],data.pos[p2][0],data.pos[p2][1]);

        int wgx = (data.pos[p1][0] + data.pos[p2][0])/2;
        int wgy = (data.pos[p1][1] + data.pos[p2][1])/2;

        g.drawOval(wgx,wgy,5,5);

        wgtxt.setLocation(wgx,wgy);

        wgtxt.setVisible(true);



    }
}
