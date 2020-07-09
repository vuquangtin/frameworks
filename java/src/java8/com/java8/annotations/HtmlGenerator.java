package com.java8.annotations;

import java.lang.reflect.Method;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */
public class HtmlGenerator {

	public static void main(String[] args) {

		Class<?> clazz = DocumentClass.class;

		// Kiểm tra xem lớp này có được chú thích (annotate) bởi AnnHtmlUL hay
		// không.
		boolean isHtmlUL = clazz.isAnnotationPresent(AnnHtmlUL.class);

		StringBuilder sb = new StringBuilder();
		if (isHtmlUL) {

			// Lấy ra đối tượng AnnHtmlUL, chú thích trên lớp này.
			AnnHtmlUL annUL = clazz.getAnnotation(AnnHtmlUL.class);

			sb.append("<H3>" + clazz.getName() + "</H3>");
			sb.append("\n");

			// Lấy ra giá trị của phần tử 'border' của AnnHtmlUL.
			String border = annUL.border();

			sb.append("<UL style='border:" + border + "'>");

			// Thêm dấu xuống dòng.
			sb.append("\n");

			Method[] methods = clazz.getMethods();

			for (Method method : methods) {
				// Kiểm tra xem phương thức này có được chú thích (annotate)
				// bởi AnnHtmlLI hay không?
				if (method.isAnnotationPresent(AnnHtmlLI.class)) {
					// Lấy ra annotation đó.
					AnnHtmlLI annLI = method.getAnnotation(AnnHtmlLI.class);

					// Lấy ra các giá trị các phần tử của AnnHtmlLI.
					String background = annLI.background();
					String color = annLI.color();

					sb.append("<LI style='margin:5px;padding:5px;background:"
							+ background + ";color:" + color + "'>");
					sb.append("\n");
					sb.append(method.getName());
					sb.append("\n");
					sb.append("</LI>");
					sb.append("\n");
				}
			}
			sb.append("</UL>");
		}
		writeToFile(clazz.getSimpleName() + ".html", sb);
	}

	// Ghi các thông tin ra màn hình Console (Hoặc file).
	private static void writeToFile(String fileName, StringBuilder sb) {
		System.out.println(sb);
	}

}