import java.awt.*;

public class TipperCar extends Truck{
	
    // �������������� ����
    public Color DopColor; 

    // ������� ������� �������� ������
    public boolean WheelRims; 

    // ������� ������� ��������� ��������� 
    public boolean Platform;

    // ������� ������� ��� 
    public boolean Headlight; 

    // ��������� �������� ������
    public InterDop WheelsR;

    // �����������
    public TipperCar(int maxSpeed, float weight, Color mainColor, Color dopColor,
   boolean wheelRims, boolean headlight, boolean platform)
    {
    	super(maxSpeed, weight, mainColor, 90, 50);
        DopColor = dopColor;
        WheelRims = wheelRims;
        Headlight = headlight;
        Platform = platform;
        WheelsR = new PaintRims();
        WheelsR.setNumberWheels(num);
    }

    // ��������� ����������
    @Override
    public void DrawTransport(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D)g;
    	super.DrawTransport(g);
        {
            //��������� ��������� ���������
            if (Platform)
            {
            	g2d.setPaint(DopColor);
                g2d.fillRect((int)_startPosX, (int)_startPosY + 10, 50, 30);
                g2d.setPaint(Color.BLACK);
                g2d.drawRect((int)_startPosX, (int)_startPosY + 10, 50, 30);

            }

            //��������� ���
            if (Headlight)
            {
            	g2d.setPaint(Color.RED);
                g2d.fillRect((int)_startPosX + 70, (int)_startPosY + 45, 10, 5);
                g2d.fillRect((int)_startPosX, (int)_startPosY + 45, 10, 5);
                g2d.setPaint(Color.BLACK);
                g2d.drawRect((int)_startPosX + 70, (int)_startPosY + 45, 10, 5);
                g2d.drawRect((int)_startPosX, (int)_startPosY + 45, 10, 5);
            }
            
          //��������� �������� ������
            if(WheelRims) {
                WheelsR.paint(g2d, Color.GRAY, _startPosX, _startPosY);
            }

        }

    }

}

