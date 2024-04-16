import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

//https://stackoverflow.com/questions/62374617/trying-to-draw-a-pie-chart-with-awt-in-java

public class pieChart extends JPanel
{
    int value[];
    int start = 0;

    public Color c1 = new Color(255, 173, 173);
    public Color c2 = new Color(255, 214, 165);
    public Color c3 = new Color(253, 255, 182);
    public Color c4 = new Color(202, 255, 191);
    public Color c5 = new Color(155, 246, 255);
    public Color c6 = new Color(160, 196, 255);
    public Color c7 = new Color(189, 178, 255);
    public Color c8 = new Color(255, 198, 255);
    public Color[] colors = {c1, c2, c3, c4, c5, c6, c7, c8};
    public pieChart(String[] values)
    {
        value = new int[values.length];

        for(int i = 0; i<values.length; i++)
        {
            value[i] = Integer.parseInt(values[i]);
        }

    }

    public void paintComponent(Graphics g)  {
        super.paintComponent(g);
        if (value == null) {
            return;
        }
        for(int i = 0; i<value.length; i++) {
            g.setColor(colors[i%colors.length]);
            g.fillArc(100, 100, 200, 200, start, value[i]);
            start = start + value[i];
        }

    }
}