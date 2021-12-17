import java.awt.*;

public class PaintWheels{
	
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
    
    //Метод отрисовки колёс
    public void paintWheels(Graphics2D g2d, Color DopColor,  float _startPosX, float _startPosY) {
    	switch (numberOfWheels) {
	    	case Four:
	            g2d.setPaint(Color.BLACK);
	            g2d.fillOval((int)_startPosX + 45, (int)_startPosY + 55, 15, 15);
	            g2d.drawOval((int)_startPosX + 45, (int)_startPosY + 55, 15, 15);
	    	case Three:
	            g2d.setPaint(Color.BLACK);
	    		g2d.fillOval((int)_startPosX + 20, (int)_startPosY + 55, 15, 15);
	    		g2d.drawOval((int)_startPosX + 20, (int)_startPosY + 55, 15, 15);
	    	case Two:
	            g2d.setPaint(Color.BLACK);
	            g2d.fillOval((int)_startPosX, (int)_startPosY + 55, 15, 15);
	            g2d.fillOval((int)_startPosX + 65, (int)_startPosY + 55, 15, 15);
	            g2d.drawOval((int)_startPosX, (int)_startPosY + 55, 15, 15);
	            g2d.drawOval((int)_startPosX + 65, (int)_startPosY + 55, 15, 15);
	    		break;
    	}

    }
    
}
