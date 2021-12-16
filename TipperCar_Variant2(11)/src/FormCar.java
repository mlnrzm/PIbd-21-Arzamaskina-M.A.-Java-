import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCar {

	public JFrame frame;
	public TipperCar car;
	public JPanel panel;
	
    /// <summary>
    /// Конструктор
    /// </summary>
	public FormCar() {
		initialize();
	}
	
    /// <summary>
    /// Метод отрисовки машины
    /// </summary>
    private void Draw()
    {
    	panel.repaint();
    }
    
    public TipperCar SetCar() {
    	return this.car;
    }

	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0421\u0430\u043C\u043E\u0441\u0432\u0430\u043B");
		frame.setBounds(100, 100, 702, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.getContentPane().setLayout(null);
		
		frame.addComponentListener(new ComponentAdapter() {  
	        public void componentResized(ComponentEvent evt) {
	        	panel.setBounds(0, 0, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
	        	if(car != null) {
	        		car._pictureWidth = frame.getContentPane().getWidth();
	        		car._pictureHeight = frame.getContentPane().getHeight();
	        	}
	        	panel.repaint();
	        }
		});
		
		//Панель отрисовки самосвала
		panel = new JPanel() {
			@Override
		    public void paintComponent(Graphics g) {
					super.paintComponent(g);
			        Graphics2D g2d = (Graphics2D)g;
			        car.DrawTransport(g2d);
		    }
		};
		panel.setBounds(0, 0, 688, 434);
		panel.setLayout(null);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		
		//Кнопка "Создать"
		JButton ButtonCreate = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
		ButtonCreate.setBounds(10, 10, 121, 28);
		panel.add(ButtonCreate);
		
		//Кнопка "Вправо"
		JButton ButtonRight = new JButton();
		ButtonRight.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\TipperCar_Variant2\\src\\Resources\\\u0432\u043F\u0440\u0430\u0432\u043E.png"));
		ButtonRight.setBounds(649, 396, 29, 29);
		panel.add(ButtonRight);
		
		//Кнопка "Вниз"
		JButton ButtonDown = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\TipperCar_Variant2\\src\\Resources\\\u0432\u043D\u0438\u0437.png"));
		ButtonDown.setBounds(610, 396, 29, 29);
		panel.add(ButtonDown);
		
		//Кнопка "Вверх"
		JButton ButtonUp = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\TipperCar_Variant2\\src\\Resources\\\u0432\u0432\u0435\u0440\u0445.png"));
		ButtonUp.setBounds(610, 358, 29, 29);
		panel.add(ButtonUp);
		
		//Кнопка "Влево"
		JButton ButtonLeft = new JButton();
		ButtonLeft.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\TipperCar_Variant2\\src\\Resources\\\u0432\u043B\u0435\u0432\u043E.png"));
		ButtonLeft.setBounds(571, 396, 29, 29);
		panel.add(ButtonLeft);
		panel.repaint();

		//Обработка нажатия кнопки "Создать"
		ButtonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            car = new TipperCar();
	            car.Init((int)(Math.random()*((300-100)+1)+100), (float)(Math.random()*((2000-1000)+1)+1000), Color.BLUE,
	           Color.YELLOW, true, true, true);
	            car.SetPosition( (int)(Math.random()*51) + 50,
	            (int)(Math.random()*51) + 50, panel.getWidth(), panel.getHeight());
	            car.pWheels.setNumberWheels(2 + (int) ( Math.random() * 3 ));
	            Draw();
			}
		});
		
		
		//Обработка нажатия кнопок направления движения
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(event.getSource() == ButtonRight) car.MoveTransport(Direction.Right);
                if(event.getSource() == ButtonLeft) car.MoveTransport(Direction.Left);
                if(event.getSource() == ButtonDown) car.MoveTransport(Direction.Down);
                if(event.getSource() == ButtonUp) car.MoveTransport(Direction.Up);
                Draw();
            }
        } ;
        ButtonRight.addActionListener(actionListener);
        ButtonLeft.addActionListener(actionListener);
        ButtonDown.addActionListener(actionListener);
        ButtonUp.addActionListener(actionListener);
	}

}
