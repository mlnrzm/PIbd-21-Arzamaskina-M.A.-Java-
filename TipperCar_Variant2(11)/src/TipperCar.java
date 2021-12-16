import java.awt.*;

public class TipperCar {
    /// <summary>
    /// ����� ���������� ��������� ����������
    /// </summary>
    private float _startPosX;

    /// <summary>
    /// ������ ���������� ��������� ����������
    /// </summary>
    private float _startPosY;

    /// <summary>
    /// ������ ���� ���������
    /// </summary>
    public int _pictureWidth;

    /// <summary>
    /// ������ ���� ���������
    /// </summary>
    public int _pictureHeight;

    /// <summary>
    /// ������ ��������� ����������
    /// </summary>
    private final int carWidth = 80;

    /// <summary>
    /// ������ ��������� ����������
    /// </summary>
    private final int carHeight = 70;

    /// <summary>
    /// ������������ ��������
    /// </summary>
    public int MaxSpeed; 

    /// <summary>
    /// ��� ����������
    /// </summary>
    public float Weight;

    /// <summary>
    /// �������� ����
    /// </summary>
    public Color MainColor; 

    /// <summary>
    /// �������������� ����
    /// </summary>
    public Color DopColor; 

    /// <summary>
    /// ������� ������� �������� ������
    /// </summary>
    public boolean WheelRims; 
    public PaintWheels pWheels;

    /// <summary>
    /// ������� ������� ��������� ��������� 
    /// </summary>
    public boolean Platform; 

    /// <summary>
    /// ������� ������� ��� 
    /// </summary>
    public boolean Headlight; 
    
    /// <summary>
    /// ������������� �������
    /// </summary>
    /// <param name="maxSpeed">������������ ��������</param>
    /// <param name="weight">��� ����������</param>
    /// <param name="mainColor">�������� ����</param>
    /// <param name="dopColor">�������������� ����</param>
    /// <param name="wheelRims">������� ������� �������� ������</param>
    /// <param name="platform">������� ������� ��������� ���������</param>
    /// <param name="headlight ">������� ������� ���</param>
    public void Init(int maxSpeed, float weight, Color mainColor, Color dopColor,
   boolean wheelRims, boolean platform, boolean headlight)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        DopColor = dopColor;
        WheelRims = wheelRims;
        Platform = platform;
        Headlight = headlight;
        pWheels = new PaintWheels();
    }

    /// <summary>
    /// ��������� ������� ����������
    /// </summary>
    /// <param name="x">���������� X</param>
    /// <param name="y">���������� Y</param>
    /// <param name="width">������ ��������</param>
    /// <param name="height">������ ��������</param>
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    
    /// <summary>
    /// ��������� ����������� �����������
    /// </summary>
    /// <param name="direction">�����������</param>
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
    
    
    /// <summary>
    /// ��������� ����������
    /// </summary>
    /// <param name="g"></param>
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
            
            pWheels.paintWheels(g2d, DopColor, WheelRims, _startPosX, _startPosY);

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
        }

    }


}
