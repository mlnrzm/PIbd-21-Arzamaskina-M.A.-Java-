import java.awt.*;

public class Truck extends Vehicle {
	
    // ������ ��������� ����������
    protected int carWidth = 80;

    // ������ ��������� ����������
    protected int carHeight = 70;

    // ������, ���������� �� ��������� �����
    public PaintWheels wheels;
    
    // ������, ���������� �� ��������� ���������
    public InterDop pWheels;

    //���������� ����
    public int num;

    //��� ����
    public int view;

    // ����������� � ���������� �������� ������
    public Truck(int maxSpeed, float weight, Color mainColor)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }

    // ����������� 
    protected Truck(int maxSpeed, float weight, Color mainColor, int carWidth, int
   carHeight)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        this.carWidth = carWidth;
        this.carHeight = carHeight;
        num = 2 + (int) ( Math.random() * 3 );
        view = 1 + (int) ( Math.random() * 2 );
        ViewWheels();
    }
    
    //����� ���������
    protected void ViewWheels() {
        switch(view) {
        case 1:
        	pWheels = new PaintOrnament();
        	break;
        case 2:
        	pWheels = new PaintOrnamentRect();
        	break;
        }
        pWheels.setNumberWheels(num);
        wheels = new PaintWheels();
        wheels.setNumberWheels(num);
    }
    
    //�������� ����������
    @Override
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // ������
            case Right:
                if (_startPosX + step < _pictureWidth - carWidth)
                {
                    _startPosX += step;
                }
                break;
            //�����
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //�����
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;

                }
                break;
            //����
            case Down:
                if (_startPosY + step < _pictureHeight - carHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    
    //��������� ����������
    @Override
    public void DrawTransport(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D)g;

        {
            //��������� ���������
        	g2d.setPaint(MainColor);
            g2d.fillRect((int)_startPosX, (int)_startPosY + 40, 80, 15);
        	g2d.setPaint(Color.BLACK);
            g2d.drawRect((int)_startPosX, (int)_startPosY + 40, 80, 15);

            //��������� ������
            g2d.setPaint(Color.BLACK);
            g2d.drawRect((int)_startPosX + 55, (int)_startPosY, 25, 40);
            g2d.setPaint(MainColor);
            g2d.fillRect((int)_startPosX + 55, (int)_startPosY, 25, 40);

            //��������� �������� ������
            g2d.setPaint(Color.GRAY);
            g2d.fillRect((int)_startPosX + 65, (int)_startPosY + 4, 15, 20);
            g2d.setPaint(Color.BLACK);
            g2d.drawRect((int)_startPosX + 65, (int)_startPosY + 4, 15, 20);
            
            //��������� �����
            wheels.paintWheels(g2d, Color.BLACK, _startPosX, _startPosY);
            
            //��������� ��� ��������� �� �������
            pWheels.paint(g2d, Color.BLACK, _startPosX, _startPosY);
            
        }
    }

}
