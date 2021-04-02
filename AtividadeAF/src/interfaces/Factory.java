package interfaces;

public interface Factory {
	public abstract IBuilder createBuilder();
	public abstract IFrame createSyntaxHighlighter();
	String [] supportedExtensions();
}
