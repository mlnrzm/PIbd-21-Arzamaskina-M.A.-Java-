import java.awt.*;

public class TipperCar {
    /// <summary>
    /// Левая координата отрисовки автомобиля
    /// </summary>
    private float _startPosX;

    /// <summary>
    /// Правая координата отрисовки автомобиля
    /// </summary>
    private float _startPosY;

    /// <summary>
    /// Ширина окна отрисовки
    /// </summary>
    public int _pictureWidth;

    /// <summary>
    /// Высота окна отрисовки
    /// </summary>
    public int _pictureHeight;

    /// <summary>
    /// Ширина отрисовки автомобиля
    /// </summary>
    private final int carWidth = 80;

    /// <summary>
    /// Высота отрисовки автомобиля
    /// </summary>
    private final int carHeight = 70;

    /// <summary>
    /// Максимальная скорость
    /// </summary>
    public int MaxSpeed; 

    /// <summary>
    /// Вес автомобиля
    /// </summary>
    public float Weight;

    /// <summary>
    /// Основной цвет
    /// </summary>
    public Color MainColor; 

    /// <summary>
    /// Дополнительный цвет
    /// </summary>
    public Color DopColor; 

    /// <summary>
    /// Признак наличия колесных дисков
    /// </summary>
    public boolean WheelRims; 
    public PaintWheels pWheels;

    /// <summary>
    /// Признак наличия платформы самосвала 
    /// </summary>
    public boolean Platform; 

    /// <summary>
    /// Признак наличия фар 
    /// </summary>
    public boolean Headlight; 
    
    /// <summary>
    /// Инициализация свойств
    /// </summary>
    /// <param name="maxSpeed">Максимальная скорость</param>
    /// <param name="weight">Вес автомобиля</param>
    /// <param name="mainColor">Основной цвет</param>
    /// <param name="dopColor">Дополнительный цвет</param>
    /// <param name="wheelRims">Признак наличия колесных дисков</param>
    /// <param name="platform">Признак наличия платформы самосвала</param>
    /// <param name="headlight ">Признак наличия фар</param>
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
    /// Установка позиции автомобиля
    /// </summary>
    /// <param name="x">Координата X</param>
    /// <param name="y">Координата Y</param>
    /// <param name="width">Ширина картинки</param>
    /// <param name="height">Высота картинки</param>
    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }
    
    /// <summary>
    /// Изменение направления перемещения
    /// </summary>
    /// <param name="direction">Направление</param>
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // вправо
            case Right:
                if (_startPosX + step < _pictureWidth - carWidth)
                {
                    _startPosX += step;
                }
                break;
            //влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (_startPosY + step < _pictureHeight - carHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    
    
    /// <summary>
    /// Отрисовка автомобиля
    /// </summary>
    /// <param name="g"></param>
    public void DrawTransport(Graphics g)
    {
    	Graphics2D g2d = (Graphics2D)g;

        {
            //отрисовка платформы
        	g2d.setPaint(MainColor);
            g2d.fillRect((int)_startPosX, (int)_startPosY + 40, 80, 15);
        	g2d.setPaint(Color.BLACK);
            g2d.drawRect((int)_startPosX, (int)_startPosY + 40, 80, 15);

            //отрисовка кабины
            g2d.setPaint(Color.BLACK);
            g2d.drawRect((int)_startPosX + 55, (int)_startPosY, 25, 40);
            g2d.setPaint(MainColor);
            g2d.fillRect((int)_startPosX + 55, (int)_startPosY, 25, 40);

            //отрисовка лобового стекла
            g2d.setPaint(Color.GRAY);
            g2d.fillRect((int)_startPosX + 65, (int)_startPosY + 4, 15, 20);
            g2d.setPaint(Color.BLACK);
            g2d.drawRect((int)_startPosX + 65, (int)_startPosY + 4, 15, 20);
            
            pWheels.paintWheels(g2d, DopColor, WheelRims, _startPosX, _startPosY);

            //отрисовка платформы самосвала
            if (Platform)
            {
            	g2d.setPaint(DopColor);
                g2d.fillRect((int)_startPosX, (int)_startPosY + 10, 50, 30);
                g2d.setPaint(Color.BLACK);
                g2d.drawRect((int)_startPosX, (int)_startPosY + 10, 50, 30);

            }

            //отрисовка фар
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
