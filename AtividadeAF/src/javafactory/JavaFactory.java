package javafactory;

import interfaces.*;

public class JavaFactory implements Factory {
	@Override
	public IBuilder createBuilder() {
		return new JavacBuilder();
	};

	@Override
	public IFrame createSyntaxHighlighter() {
		return new JavaSyntaxHighlighter();
	}

	@Override
	public String[] supportedExtensions() {
		String[] extensions = {"java"};
		return extensions;
	};
}
