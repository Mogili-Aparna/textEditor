
public class EditOperations {
	EditorGUI editorGUI;

	public EditOperations(EditorGUI editorGUI) {
		this.editorGUI = editorGUI;
	}
	
	public void undo() {
		editorGUI.undoManager.undo();
	}
	
	public void redo() {
		editorGUI.undoManager.redo();
	}
}
