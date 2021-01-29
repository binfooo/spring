

package org.springframework.util.xml;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Node;
import org.xmlunit.util.Predicate;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import java.io.StringWriter;

import static org.junit.Assert.assertThat;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

public class XMLEventStreamWriterTests {

	private static final String XML =
			"<?pi content?><root xmlns='namespace'><prefix:child xmlns:prefix='namespace2'><!--comment-->content</prefix:child></root>";

	private XMLEventStreamWriter streamWriter;

	private StringWriter stringWriter;

	@Before
	public void createStreamReader() throws Exception {
		stringWriter = new StringWriter();
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(stringWriter);
		streamWriter = new XMLEventStreamWriter(eventWriter, XMLEventFactory.newInstance());
	}

	@Test
	public void write() throws Exception {
		streamWriter.writeStartDocument();
		streamWriter.writeProcessingInstruction("pi", "content");
		streamWriter.writeStartElement("namespace", "root");
		streamWriter.writeDefaultNamespace("namespace");
		streamWriter.writeStartElement("prefix", "child", "namespace2");
		streamWriter.writeNamespace("prefix", "namespace2");
		streamWriter.writeComment("comment");
		streamWriter.writeCharacters("content");
		streamWriter.writeEndElement();
		streamWriter.writeEndElement();
		streamWriter.writeEndDocument();

		Predicate<Node> nodeFilter = n -> n.getNodeType() != Node.DOCUMENT_TYPE_NODE && n.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE;
		assertThat(stringWriter.toString(), isSimilarTo(XML).withNodeFilter(nodeFilter));
	}


}
