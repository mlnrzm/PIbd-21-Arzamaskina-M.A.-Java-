import java.awt.Color;
import java.awt.Graphics2D;

public interface InterDop {

	void setNumberWheels(int number);
	
	void paint(Graphics2D g2d, Color DopColor, float _startPosX, float _startPosY);
}
