import java.io.*;
import javax.swing.*;
import interfaces.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;
import java.net.URLClassLoader;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Main {
	private static void createTextWindow(IFrame syntaxHighlighter, File file) throws Exception {
		JFrame frame = new JFrame("Atividade1 App");
		JPanel panel = new JPanel(new BorderLayout());
		RSyntaxTextArea textArea = syntaxHighlighter.createTextArea();
		RTextScrollPane scrollPane = new RTextScrollPane(textArea);
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		panel.add(scrollPane);
		frame.setContentPane(panel);
		textArea.read(input, "...");
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	};
	
	private static void createProducts(Factory factory, File file) throws Exception {
		IBuilder builder = factory.createBuilder();
		IFrame syntaxHighlighter = factory.createSyntaxHighlighter();
		
		createTextWindow(syntaxHighlighter, file);
		builder.compile(file);
	};
	
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("File Chooser");
		JPanel panel = new JPanel(new BorderLayout());
		JFileChooser fileChooser = new JFileChooser();
		JButton readButton = new JButton("Browse");
	   
		frame.setMinimumSize(new Dimension(190, 33));
		panel.add(readButton, BorderLayout.CENTER);
		frame.setContentPane(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	     
		readButton.addActionListener(ev -> {
			int returnVal = fileChooser.showOpenDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				String fileName = file.getName();
				String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		    	
				File currentDir = new File("./plugins");
				String[] plugins = currentDir.list();
				URL[] jars = new URL[plugins.length];
				for (int i = 0; i < plugins.length; i++) {
					try {
						jars[i] = (new File("./plugins/" + plugins[i])).toURL();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				URLClassLoader ulc = new URLClassLoader(jars);
				boolean supportedExtension = false;
				for(String factoryName : plugins) {
					try {
						Factory factory = (Factory) Class.forName(factoryName.toLowerCase().split("\\.")[0] + "." + factoryName.split("\\.")[0], true, ulc).newInstance();
						for(String extension : factory.supportedExtensions())
							if(extension.equals(fileExtension)) {
								createProducts(factory, file);
								supportedExtension = true;
							}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(!supportedExtension)
					System.out.println("Não existe plug-in que suporte este arquivo.");
			}
		});
	};
}
