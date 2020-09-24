import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardShortCuts implements KeyListener{
	EditorGUI editorGUI;
	
	public KeyBoardShortCuts(EditorGUI editorGUI) {
		this.editorGUI = editorGUI;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			editorGUI.fileOperations.save();
		}
		if(e.isShiftDown() && e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S) {
			editorGUI.fileOperations.saveAs();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N) {
			editorGUI.fileOperations.newFile();
		}
		if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O) {
			editorGUI.fileOperations.open();
		}
		if(e.isAltDown()&& e.getKeyCode()==KeyEvent.VK_F4) {
			editorGUI.fileOperations.closeWindow();
		}
		if(e.isControlDown()&& e.getKeyCode()==KeyEvent.VK_Z) {
			editorGUI.editOperations.undo();
		}
		if(e.isControlDown()&& e.getKeyCode()==KeyEvent.VK_R) {
			editorGUI.editOperations.redo();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
