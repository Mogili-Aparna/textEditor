
public class FormatOperations {
	EditorGUI editorGUI;

	public FormatOperations(EditorGUI editorGUI) {
		this.editorGUI = editorGUI;
	}
	public void wordWrap() {
		System.out.println(editorGUI.wordWrap);
		editorGUI.wordWrap=!editorGUI.wordWrap;
		editorGUI.textArea.setLineWrap(editorGUI.wordWrap);
		editorGUI.textArea.setWrapStyleWord(editorGUI.wordWrap);
		System.out.println(editorGUI.wordWrap);
	}
}
