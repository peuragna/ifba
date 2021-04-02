package cppfactory;

import interfaces.*;

public class CppFactory implements Factory {
	@Override
	public IBuilder createBuilder() {
		return new GppBuilder();
	};

	@Override
	public IFrame createSyntaxHighlighter() {
		return new CppSyntaxHighlighter();
	}

	@Override
	public String[] supportedExtensions() {
		String[] extensions = {"cc","cpp"};
		return extensions;
	};
}
