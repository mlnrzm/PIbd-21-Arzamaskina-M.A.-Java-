import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormCar {

	public JFrame frame;
	private ITransport car;
	public JPanel panel;
	
    // Конструктор
	public FormCar() {
		initialize();
	}
	
    // Метод отрисовки машины
    private void Draw()
    {
    	panel.repaint();
    }
    
    //Метод получения машины
    public ITransport SetCar() {
    	return this.car;
    }

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0421\u0430\u043C\u043E\u0441\u0432\u0430\u043B");
		frame.setBounds(100, 100, 702, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.getContentPane().setLayout(null);
		
		frame.addComponentListener(new ComponentAdapter() {  
	        public void componentResized(ComponentEvent evt) {
	        	panel.setBounds(0, 0, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
	        	panel.repaint();
	        }
		});
		
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
		
		JButton ButtonCreate_Truck = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0433\u0440\u0443\u0437\u043E\u0432\u0438\u043A");
		ButtonCreate_Truck.setBounds(10, 10, 192, 28);
		panel.add(ButtonCreate_Truck);
		
		JButton ButtonCreate_TipperCar = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0441\u0430\u043C\u043E\u0441\u0432\u0430\u043B");
		ButtonCreate_TipperCar.setBounds(225, 10, 192, 28);
		panel.add(ButtonCreate_TipperCar);
		
		JButton ButtonRight = new JButton();
		ButtonRight.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\TipperCar_Variant2\\src\\Resources\\\u0432\u043F\u0440\u0430\u0432\u043E.png"));
		ButtonRight.setBounds(649, 396, 29, 29);
		panel.add(ButtonRight);
		
		JButton ButtonDown = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\TipperCar_Variant2\\src\\Resources\\\u0432\u043D\u0438\u0437.png"));
		ButtonDown.setBounds(610, 396, 29, 29);
		panel.add(ButtonDown);
		
		JButton ButtonUp = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\TipperCar_Variant2\\src\\Resources\\\u0432\u0432\u0435\u0440\u0445.png"));
		ButtonUp.setBounds(610, 358, 29, 29);
		panel.add(ButtonUp);
		
		JButton ButtonLeft = new JButton();
		ButtonLeft.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\TipperCar_Variant2\\src\\Resources\\\u0432\u043B\u0435\u0432\u043E.png"));
		ButtonLeft.setBounds(571, 396, 29, 29);
		panel.add(ButtonLeft);

        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(400, 80));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
		
        //Обработка нажатия кнопки "Создать самосвал"
		ButtonCreate_TipperCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            car = new TipperCar((int)(Math.random()*((300-100)+1)+100), (float)(Math.random()*((2000-1000)+1)+1000), Color.BLUE, Color.RED, 
	            		true, true, true);
	            car.SetPosition( (int)(Math.random()*51) + 50,
	            (int)(Math.random()*51) + 50, panel.getWidth(), panel.getHeight());
	            Draw();
			}
		});

		 //Обработка нажатия кнопки "Создать грузовик"
		ButtonCreate_Truck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            car = new Truck((int)(Math.random()*((300-100)+1)+100), (float)(Math.random()*((2000-1000)+1)+1000), Color.BLUE,80,70);
	            car.SetPosition( (int)(Math.random()*51) + 50,
	            (int)(Math.random()*51) + 50, panel.getWidth(), panel.getHeight());
	            Draw();
			}
		});
		
		//Обработка нажатия кнопок направлений движения
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