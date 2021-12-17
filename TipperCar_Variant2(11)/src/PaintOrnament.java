import java.awt.Color;
import java.awt.Graphics2D;

public class PaintOrnament implements InterDop{
	
	//Поле-перечисление
	private NumberOfWheels numberOfWheels;
    
	//Метод принимающий принимающий числовое значение
    public void setNumberWheels(int number) {
    	switch(number) {
    	case 2:
    		numberOfWheels = NumberOfWheels.Two;
    		break;
    	case 3:
    		numberOfWheels = NumberOfWheels.Three;
    		break;
    	case 4:
    		numberOfWheels = NumberOfWheels.Four;
    		break;
    	default:
    		numberOfWheels = NumberOfWheels.Two;
    		break;
    	}
    }
    
    //метод отрисовки колёс
    public void paint(Graphics2D g2d, Color DopColor, float _startPosX, float _startPosY) {
    	switch (numberOfWheels) {
    	case Four:
            g2d.setPaint(Color.BLACK);
            g2d.fillOval((int)_startPosX + 45, (int)_startPosY + 55, 15, 15);
            g2d.drawOval((int)_startPosX + 45, (int)_startPosY + 55, 15, 15);
            g2d.setPaint(Color.WHITE);
            g2d.drawOval((int)_startPosX + 45 + 2, (int)_startPosY + 55 + 2, 11, 11);

    	case Three:
            g2d.setPaint(Color.BLACK);
    		g2d.fillOval((int)_startPosX + 20, (int)_startPosY + 55, 15, 15);
    		g2d.drawOval((int)_startPosX + 20, (int)_startPosY + 55, 15, 15);
    		g2d.setPaint(Color.WHITE);
    		g2d.drawOval((int)_startPosX + 20 + 2, (int)_startPosY + 55 + 2, 11, 11);

    	case Two:
            g2d.setPaint(Color.BLACK);
            g2d.fillOval((int)_startPosX, (int)_startPosY + 55, 15, 15);
            g2d.fillOval((int)_startPosX + 65, (int)_startPosY + 55, 15, 15);
            g2d.drawOval((int)_startPosX, (int)_startPosY + 55, 15, 15);
            g2d.drawOval((int)_startPosX + 65, (int)_startPosY + 55, 15, 15);
            g2d.setPaint(Color.WHITE);
            g2d.drawOval((int)_startPosX + 2, (int)_startPosY + 55 + 2, 11, 11);
            g2d.drawOval((int)_startPosX + 65 + 2, (int)_startPosY + 55 + 2, 11, 11);
    		break;
	}

    }
    
}
