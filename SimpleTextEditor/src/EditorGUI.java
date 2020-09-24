import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class EditorGUI implements ActionListener{
	
	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu fileMenu,editMenu,formatMenu;
	JMenuItem newMenuItem,openMenuItem,saveMenuItem,saveAsMenuItem,closeMenuItem,wrapMenuItem,undoMenuItem,redoMenuItem;
	FileOperations fileOperations = new FileOperations(this);
	FormatOperations formatOperations = new FormatOperations(this);
	EditOperations editOperations = new EditOperations(this);
	UndoManager undoManager = new UndoManager();
	KeyBoardShortCuts keyBoardShortCuts = new KeyBoardShortCuts(this); 
	Boolean wordWrap=false;
	public EditorGUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		window.setVisible(true);
	}
	public static void main(String[] args) {
		new EditorGUI();
	}
	public void createWindow() {
		window = new JFrame("textEditor");
		window.setSize(1000,800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createTextArea() {
		textArea = new JTextArea();
		textArea.addKeyListener(keyBoardShortCuts);
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				undoManager.addEdit(e.getEdit());
				
			}
		});
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		window.add(scrollPane);
	}
	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		formatMenu = new JMenu("Format");
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(formatMenu);
		createFileMenu();
		createFormatMenu();
		createEditMenu();
	}
	public void createFileMenu() {
		newMenuItem = new JMenuItem("New");
		newMenuItem.addActionListener(this);
		newMenuItem.setActionCommand("New");
		fileMenu.add(newMenuItem);

		openMenuItem = new JMenuItem("Open");
		openMenuItem.addActionListener(this);
		openMenuItem.setActionCommand("Open");
		fileMenu.add(openMenuItem);
		
		saveMenuItem = new JMenuItem("Save");
		saveMenuItem.addActionListener(this);
		saveMenuItem.setActionCommand("Save");
		fileMenu.add(saveMenuItem);
		
		saveAsMenuItem = new JMenuItem("Save As");
		saveAsMenuItem.addActionListener(this);
		saveAsMenuItem.setActionCommand("Save As");
		fileMenu.add(saveAsMenuItem);
		
		closeMenuItem = new JMenuItem("Exit");
		closeMenuItem.addActionListener(this);
		closeMenuItem.setActionCommand("Exit");
		fileMenu.add(closeMenuItem);
	}
	public void createFormatMenu() {
		wrapMenuItem = new JMenuItem("Word Wrap");
		wrapMenuItem.addActionListener(this);
		wrapMenuItem.setActionCommand("Wrap");
		formatMenu.add(wrapMenuItem);
	}
	public void createEditMenu() {
		undoMenuItem = new JMenuItem("Undo");
		undoMenuItem.addActionListener(this);
		undoMenuItem.setActionCommand("Undo");
		editMenu.add(undoMenuItem);
		
		redoMenuItem = new JMenuItem("Redo");
		redoMenuItem.addActionListener(this);
		redoMenuItem.setActionCommand("Redo");
		editMenu.add(redoMenuItem);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "New":fileOperations.newFile();break;
		case "Open":fileOperations.open();break;
		case "Save":fileOperations.save();break;
		case "Save As":fileOperations.saveAs();break;
		case "Exit":fileOperations.closeWindow();break;
		case "Wrap":formatOperations.wordWrap();break;
		case "Undo":editOperations.undo();break;
		case "Redo":editOperations.redo();break;
		}
	}
	
}
