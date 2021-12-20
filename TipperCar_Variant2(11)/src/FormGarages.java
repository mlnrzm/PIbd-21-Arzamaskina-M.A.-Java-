import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class FormGarages {

	public JFrame frame;
	JPanel panelCar;
	private JTextField textField;
	public Garage<Truck, PaintRims> garage;

    /// <summary>
    /// Метод отрисовки машины
    /// </summary>
    private void Draw()
    {
    	panelCar.repaint();
    }

    /// <summary>
    /// Конструктор
    /// </summary>
	public FormGarages() {
		initialize();
		garage = new Garage<Truck, PaintRims>(panelCar.getWidth(), panelCar.getHeight());
        Draw();
	}

	private void initialize() {		
		frame = new JFrame();
		frame.setTitle("\u0413\u0430\u0440\u0430\u0436\u0438");
		frame.setBounds(100, 100, 704, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
        /// <summary>
        /// Панель отрисовки гаражей и грузовиков
        /// </summary>
		panelCar = new JPanel() {
			@Override
		    public void paintComponent(Graphics g) {
					super.paintComponent(g);
			        garage.Draw(g);
		    }
		};
		
		panelCar.setBounds(0, 0, 690, 449);
		panelCar.setLayout(null);
		frame.getContentPane().add(panelCar);
		
        /// <summary>
        /// Обработка нажатия кнопки "Припарковать грузовик"
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
		JButton btnParkingTruck = new JButton("\u041F\u0440\u0438\u043F\u0430\u0440\u043A\u043E\u0432\u0430\u0442\u044C \u0433\u0440\u0443\u0437\u043E\u0432\u0438\u043A");
		btnParkingTruck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Color color = JColorChooser.showDialog(panelCar, "Цвет", null);
	            if (color != null)
	            {
	                Truck car = new Truck((int)(Math.random()*((300-100)+1)+100), (float)(Math.random()*((2000-1000)+1)+1000), color ,80,70);
	                if (garage.plus(garage , car) > -1)
	                {
	                    Draw();
	                }
	                else JOptionPane.showMessageDialog(frame, "Гараж переполнен");
	            }
			}
		});
		btnParkingTruck.setBounds(501, 17, 163, 41);
		panelCar.add(btnParkingTruck);
		
        /// <summary>
        /// Обработка нажатия кнопки "Припарковать самосвал"
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
		JButton btnParkingTipperCar = new JButton("\u041F\u0440\u0438\u043F\u0430\u0440\u043A\u043E\u0432\u0430\u0442\u044C \u0441\u0430\u043C\u043E\u0441\u0432\u0430\u043B");
		btnParkingTipperCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Color color = JColorChooser.showDialog(panelCar, "Цвет", null);
				Color colorDop = JColorChooser.showDialog(panelCar, "Цвет", null);
	            if (color != null)
	            {
	                TipperCar car = new TipperCar((int)(Math.random()*((300-100)+1)+100), (float)(Math.random()*((2000-1000)+1)+1000), 
	                		color, colorDop, true, true, true);
	                if (garage.plus(garage , car) > -1)
	                {
	                    Draw();
	                }
	                else JOptionPane.showMessageDialog(frame, "Гараж переполнен");
	            }
			}
		});
		btnParkingTipperCar.setBounds(501, 68, 163, 48);
		panelCar.add(btnParkingTipperCar);
		
        /// <summary>
        /// Текстовое поле
        /// </summary>
		textField = new JTextField();
		textField.setBounds(521, 157, 96, 19);
		panelCar.add(textField);
		textField.setColumns(10);
		
        /// <summary>
        /// Обработка нажатия кнопки "Забрать"
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
		JButton btnTake = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		btnTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 if (textField.getText() != "")
				 {
				 ITransport car = garage.minus(garage, Integer.parseInt(textField.getText()));
				 if (car != null)
				 {
					FormCar form = new FormCar();
					form.SetCar(car);
					form.frame.setVisible(true);
				 }
				 Draw();
				 }

			}
		});
		btnTake.setBounds(521, 186, 85, 21);
		panelCar.add(btnTake);
		
		JLabel lblTakeCar = new JLabel("\u0417\u0430\u0431\u0440\u0430\u0442\u044C \u0433\u0440\u0443\u0437\u043E\u0432\u0438\u043A/\u0441\u0430\u043C\u043E\u0441\u0432\u0430\u043B:");
		lblTakeCar.setBounds(501, 126, 179, 13);
		panelCar.add(lblTakeCar);
		
		frame.addComponentListener(new ComponentAdapter() {  
	        public void componentResized(ComponentEvent evt) {
	        	panelCar.setBounds(0, 0, frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
	        	panelCar.repaint();
	        }
		});

	}
}
