import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReadXMLDemo {
	public static void main(String[] args) throws Exception {

		// ��ȡXML�ļ�,���document����
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/test.xml"));

		// ȡ�ýڵ����
		Element root = document.getRootElement();// ȡ�ø��ڵ�
		Element books = root.element("Books"); // ȡ�øýڵ��� "Books" �ӽڵ�
		Element book = books.element("Book");
		System.out.println(book.getName() + book.getText()); // getName()��ȡ�ýڵ�����,getText()ȡ�øýڵ�����

		System.out.println(book.attribute("id").getText()); //book.attribute("id")��ȡ�ýڵ�������Ϊid������
		
		// �����ӽڵ�������Ԫ��
		List<Element> bookList = book.elements();
		for (Element element : bookList) {
			System.out.println(element.getName() + " :" + element.getText());
		}

		//�����ӽڵ����ӽڵ�����Ԫ��
		for (Iterator it = books.elementIterator(); it.hasNext();) {
			Element element = (Element) it.next();
			List<Element> booksList = element.elements();
			for (Element element2 : booksList) {
				System.out.println(element2.getName() + ": " + element2.getText());
			}
		}
	}

}
