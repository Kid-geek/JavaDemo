import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXMLDemo {
	public static void main(String[] args) throws Exception {

		// 读取XML文件,获得document对象
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/test.xml"));

		// 取得节点对象
		Element root = document.getRootElement();// 取得根节点
		Element books = root.element("Books"); // 取得该节点下 "Books" 子节点
		Element book = books.element("Book");
		System.out.println(book.getName() + book.getText()); // getName()获取该节点名字,getText()取得该节点内容

		System.out.println(book.attribute("id").getText()); //book.attribute("id")获取该节点下属性为id的内容
		
		// 遍历子节点下所有元素
		List<Element> bookList = book.elements();
		for (Element element : bookList) {
			System.out.println(element.getName() + " :" + element.getText());
		}

		//遍历子节点下子节点所有元素
		for (Iterator it = books.elementIterator(); it.hasNext();) {
			Element element = (Element) it.next();
			List<Element> booksList = element.elements();
			for (Element element2 : booksList) {
				System.out.println(element2.getName() + ": " + element2.getText());
			}
		}
	}

}
