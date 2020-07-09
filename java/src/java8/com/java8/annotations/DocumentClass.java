package com.java8.annotations;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
@AnnHtmlUL(border = "1px solid red")
public class DocumentClass {

	private String author;

	@AnnHtmlLI(background = "blue", color = "black")
	public String getDocumentName() {
		return "Java Core";
	}

	@AnnHtmlLI(background = "yellow")
	public String getDocumentVersion() {
		return "1.0";
	}

	@AnnHtmlLI(background = "green")
	public void setAuthor(String author) {
		this.author = author;
	}

	@AnnHtmlLI(background = "red", color = "black")
	public String getAuthor() {
		return author;
	}

	// Phương thức này không được chú thích bởi Annotation nào.
	public float getPrice() {
		return 100;
	}

}