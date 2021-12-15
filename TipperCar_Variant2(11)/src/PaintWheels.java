import java.awt.*;

public class PaintWheels {
	
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
    public void paintWheels(Graphics2D g2d, Color DopColor, boolean WheelRims, float _startPosX, float _startPosY) {
    	switch (numberOfWheels) {
	    	case Four:
	            //отрисовка 4 колеса
	            g2d.setPaint(Color.BLACK);
	            g2d.fillOval((int)_startPosX + 45, (int)_startPosY + 55, 15, 15);
	            g2d.drawOval((int)_startPosX + 45, (int)_startPosY + 55, 15, 15);
	            //отрисовка колесных дисков
	            if (WheelRims)
	            {
	            	g2d.setPaint(Color.GRAY);
	                g2d.fillOval((int)_startPosX + 50, (int)_startPosY + 60, 5, 5);
	            }
	    	case Three:
	            g2d.setPaint(Color.BLACK);
	    		g2d.fillOval((int)_startPosX + 20, (int)_startPosY + 55, 15, 15);
	    		g2d.drawOval((int)_startPosX + 20, (int)_startPosY + 55, 15, 15);
	            //отрисовка колесных дисков
	            if (WheelRims)
	            {
	            	g2d.setPaint(Color.GRAY);
	                g2d.fillOval((int)_startPosX + 25, (int)_startPosY + 60, 5, 5);
	            }
	    	case Two:
	            //отрисовка колес
	            g2d.setPaint(Color.BLACK);
	            g2d.fillOval((int)_startPosX, (int)_startPosY + 55, 15, 15);
	            g2d.fillOval((int)_startPosX + 65, (int)_startPosY + 55, 15, 15);
	            g2d.drawOval((int)_startPosX, (int)_startPosY + 55, 15, 15);
	            g2d.drawOval((int)_startPosX + 65, (int)_startPosY + 55, 15, 15);
	            //отрисовка колесных дисков
	            if (WheelRims)
	            {
	            	g2d.setPaint(Color.GRAY);
	                g2d.fillOval((int)_startPosX + 5, (int)_startPosY + 60, 5, 5);
	                g2d.fillOval((int)_startPosX + 70, (int)_startPosY + 60, 5, 5);
	            }
	    		break;
    	}

    }
    
}
