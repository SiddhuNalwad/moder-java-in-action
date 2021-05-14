package com.modernjavainaction.chapter03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class Example {
	public static void main(String[] args) throws IOException{
		Example e = new Example();
		final String fileName = "E:\\\\MyGitHubProjects\\\\modern-java-in-action\\\\modern-java-in-action\\\\src\\\\main\\\\java\\\\com\\\\modernjavainaction\\\\chapter03\\\\Example.java";
		String oneLine = e.processFile(fileName, br -> br.readLine());
		Consumer<String> consumer = s -> System.out.println(s);
		consumer.accept(oneLine);
		
		String fiveLines = e.processFile(fileName, br -> br.readLine() + br.readLine() + br.readLine() + br.readLine() + br.readLine());
		consumer.accept(fiveLines);
	}

	public String processFile(final String fileName, final BufferedReaderProcessor processor) throws IOException{
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			return processor.process(br);

		}
	}
}
