import java.awt.*;

public class Truck extends Vehicle {
	
    // Ширина отрисовки автомобиля
    protected int carWidth = 80;

    // Высота отрисовки автомобиля
    protected int carHeight = 70;

    // Объект, отвечающий за отрисовку колес
    public PaintWheels wheels;
    
    // Объект, отвечающий за отрисовку орнамента
    public InterDop pWheels;

    //Количество колёс
    public int num;

    //Вид колёс
    public int view;

    // Конструктор с изменением размеров машины
    public Truck(int maxSpeed, float weight, Color mainColor)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }

    // Конструктор 
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
    
    //Выбор орнамента
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
    
    //Движение транспорта
    @Override
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
    
    //Отрисовка транспорта
    @Override
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
            
            //отрисовка колес
            wheels.paintWheels(g2d, Color.BLACK, _startPosX, _startPosY);
            
            //отрисовка доп орнамента на колесах
            pWheels.paint(g2d, Color.BLACK, _startPosX, _startPosY);
            
        }
    }

}
