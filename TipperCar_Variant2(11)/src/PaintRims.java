import java.awt.Color;
import java.awt.Graphics2D;

public class PaintRims implements InterDop{
	
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
	            	g2d.setPaint(Color.GRAY);
	                g2d.fillOval((int)_startPosX + 50, (int)_startPosY + 60, 5, 5);
	    	case Three:
	            	g2d.setPaint(Color.GRAY);
	                g2d.fillOval((int)_startPosX + 25, (int)_startPosY + 60, 5, 5);
	            
	    	case Two:
	            	g2d.setPaint(Color.GRAY);
	                g2d.fillOval((int)_startPosX + 5, (int)_startPosY + 60, 5, 5);
	                g2d.fillOval((int)_startPosX + 70, (int)_startPosY + 60, 5, 5);
	    		break;
    	}

    }
    
}
