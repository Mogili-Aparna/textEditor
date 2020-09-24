import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileOperations {
	EditorGUI editorGUI;
	String fileName;
	String fileAddress;

	public FileOperations(EditorGUI editorGUI) {
		this.editorGUI = editorGUI;
	}

	public void newFile() {
		EditorGUI editorGUI = new EditorGUI();
	}

	public void open() {
		FileDialog fileDialog = new FileDialog(editorGUI.window, "Open", FileDialog.LOAD);
		fileDialog.setVisible(true);
		if (fileDialog != null) {
			fileName = fileDialog.getFile();
			fileAddress = fileDialog.getDirectory();
			editorGUI.window.setTitle(fileName);

			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress + fileName));
				String text;
				while ((text = bufferedReader.readLine()) != null) {
					editorGUI.textArea.append(text + "\n");
				}
				bufferedReader.close();
			} catch (Exception e) {
				System.out.println("Error while Opening File!");
			}
		}
	}
	public void save() {
		if(fileName==null) {
			saveAs();
		}
		else {
			try {
				FileWriter fileWriter = new FileWriter(fileAddress+fileName);
				fileWriter.write(editorGUI.textArea.getText());
				fileWriter.close();
			} catch (Exception e) {
				System.out.println("Error while Saving File!");
			}
		}
	}
	public void saveAs() {
		FileDialog fileDialog = new FileDialog(editorGUI.window,"Save",FileDialog.SAVE);
		fileDialog.setVisible(true);
		if (fileDialog != null) {
			fileName = fileDialog.getFile();
			fileAddress = fileDialog.getDirectory();
			editorGUI.window.setTitle(fileName);

			try {
				FileWriter fileWriter = new FileWriter(fileAddress+fileName);
				fileWriter.write(editorGUI.textArea.getText());
				fileWriter.close();
			} catch (Exception e) {
				System.out.println("Error while Saving File!");
			}
		}
	}
	public void closeWindow() {
		System.exit(0);
	}

}
