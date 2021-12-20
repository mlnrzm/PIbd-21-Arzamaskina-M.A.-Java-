import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/// <summary>
    /// Параметризованный класс для хранения набора объектов от интерфейса ITransport
    /// </summary>
    /// <typeparam name="T"></typeparam>
    public class Garage <T extends ITransport, M extends InterDop>
    {
        /// <summary>
        /// Массив объектов, которые храним
        /// </summary>
        private List<T> _garages;
        /// <summary>
        /// Ширина окна отрисовки
        /// </summary>
        private final int pictureWidth;
        /// <summary>
        /// Высота окна отрисовки
        /// </summary>
        private final int pictureHeight;
        /// <summary>
        /// Размер места в гаражe (ширина)
        /// </summary>
        private final int _garageSizeWidth = 210;
        /// <summary>
        /// Размер места в гаражe (высота)
        /// </summary>
        private final int _garageSizeHeight = 100;
        
        int width;
        int height;
        /// <summary>
        /// Конструктор
        /// </summary>
        /// <param name="picWidth">Размер гаража - ширина</param>
        /// <param name="picHeight">Размер гаража - высота</param>
		public Garage(int picWidth, int picHeight)
        {
            width = picWidth / _garageSizeWidth;
            height = picHeight / _garageSizeHeight;
            _garages = new ArrayList<T>();
            pictureWidth = picWidth;
            pictureHeight = picHeight;
        }
        /// <summary>
        /// Перегрузка оператора сложения
        /// Логика действия: в гараж добавляется автомобиль
        /// </summary>
        /// <param name="p">Гаражи</param>
        /// <param name="car">Добавляемый автомобиль</param>
        /// <returns></returns>
        public int plus(Garage<T,M> p , T car)
        {
        	int add_car = -1;
        	if(p._garages.size() < (pictureHeight / _garageSizeHeight)*2) {
                p._garages.add(car);
                add_car = p._garages.size() ;
        	}
            return add_car;
        }
        /// <summary>
        /// Перегрузка оператора вычитания
        /// Логика действия: из гаража забираем автомобиль
        /// </summary>
        /// <param name="p">Гаражи</param>
        /// <param name="index">Индекс гаража, с которого пытаемся извлечь объект</param>
        /// <returns></returns>
        public T minus(Garage<T,M> p, int index)
        {
            T t = null;
            if ((index > -1) && (index < p._garages.size()) && (p._garages.get(index) != null))
            {
                t = (T) p._garages.get(index);
                p._garages.remove(index);
            }
            return t;
        }
        /// <summary>
        /// Перегрузка оператора больше
        /// </summary>
        public boolean more(Garage<T,M> p, int ind) {
        	return (ind > _garages.size());
        }
        /// <summary>
        /// Перегрузка оператора меньше
        /// </summary>
        public boolean less(Garage<T,M> p, int ind) {
        	return (ind < _garages.size());
        }
        /// <summary>
        /// Метод отрисовки гаражей
        /// </summary>
        /// <param name="g"></param>
        public void Draw(Graphics g)
        {
            DrawMarking(g);
            for (int i = 0; i < _garages.size(); i++)
            {
                _garages.get(i).SetPosition(5 + (i % ((pictureWidth-100) / _garageSizeWidth)) * _garageSizeWidth,
                    (i / ((pictureWidth-100) / _garageSizeWidth)) * _garageSizeHeight + 25, (pictureWidth-100), pictureHeight);
                 _garages.get(i).DrawTransport(g);
            }
            
        }
        /// <summary>
        /// Метод отрисовки разметки гаражных мест 
        /// </summary>
        /// <param name="g"></param>
        private void DrawMarking(Graphics g)
        {
        	Graphics2D g2d = (Graphics2D)g;
        	
        	g2d.setPaint(Color.BLACK);
            for (int i = 0; i < (pictureWidth - 100) / _garageSizeWidth; i++)
            {
                for (int j = 0; j < pictureHeight / _garageSizeHeight + 1; ++j)
                {
                    //крыши гаражей
                    if (j < pictureHeight / _garageSizeHeight)
                    {
                    	int x[] = {i * _garageSizeWidth,i * _garageSizeWidth + _garageSizeWidth / 2 - 15, i * _garageSizeWidth};
                    	int y[] = {j * _garageSizeHeight, j * _garageSizeHeight + 20, j * _garageSizeHeight + 20};
                    	g2d.fillPolygon(x , y, 3);
                    	g2d.drawPolygon(x, y, 3);
                    }

                    if (j > 0) g2d.drawLine( i * _garageSizeWidth, j * _garageSizeHeight, i *
                   _garageSizeWidth + _garageSizeWidth / 2, j * _garageSizeHeight);
                }
                g2d.drawLine(i * _garageSizeWidth, 0, i * _garageSizeWidth,
               (pictureHeight / _garageSizeHeight) * _garageSizeHeight);
            }
        }
    }

