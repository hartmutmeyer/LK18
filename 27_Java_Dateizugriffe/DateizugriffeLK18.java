import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DateizugriffeLK18 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateizugriffeLK18 frame = new DateizugriffeLK18();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DateizugriffeLK18() {
		createGUI();
		dateiSchreiben();
		dateiLesen();
	}

	private void dateiSchreiben() {
		URL url = getClass().getResource("dateiQ1.txt");
		try (OutputStream fileOut = new FileOutputStream(url.getFile());
				OutputStreamWriter out = new OutputStreamWriter(fileOut, "UTF-8")) {
			out.write("Ich hab's kapiert" + System.lineSeparator() + "oder vielleicht doch nicht?"
					+ System.lineSeparator());
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void dateiLesen() {
		URL url = getClass().getResource("dateiQ1.txt");
		InputStream fileIn;
		int zeichen;
		char c;
		try {
			fileIn = new FileInputStream(url.getFile());
			InputStreamReader in = new InputStreamReader(fileIn, "UTF-8");
			while ((zeichen = in.read()) != -1) {
				c = (char) zeichen;
				//				zeichen = (char) in.read();
				System.out.print(c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
