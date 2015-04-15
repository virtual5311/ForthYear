package com.nickname.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by salexandru on 3/22/15.
 */
public class XMLParsers {
    private List<Rule> rules;
    private Map<String, List<String>> questions;
    private Map<String, List<String>> sets;

    public XMLParsers(String path) throws IOException, SAXException, ParserConfigurationException {
        Document dom = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(path));
        
        dom.getDocumentElement().normalize();
        

        questions = new HashMap<>();
        sets = new HashMap<>();
        rules = new ArrayList<>();

        parseSets((Element)dom.getElementsByTagName("Sets").item(0));
        parseQuestions((Element)dom.getElementsByTagName("Questions").item(0));
        parseRules((Element)dom.getElementsByTagName("Rules").item(0));
    }

    private void parseRules (Element root) {
        NodeList children = root.getElementsByTagName("if");

        if (null == children || 0 == children.getLength()) {
            return;
        }

        for (int i = 0; i < children.getLength(); ++i) {
        	if (Node.ELEMENT_NODE != children.item(0).getNodeType()) {
        		continue;
        	}
        	
            NodeList cond = ((Element)children.item(i)).getElementsByTagName("cond");
            String then = ((Element)children.item(i)).getElementsByTagName("then").item(0).getTextContent();

            if (null == cond || 0 == cond.getLength()) {
                continue;
            }

            Rule x = new Rule();

            x.setThen(then);
            for (int j = 0; j < cond.getLength(); ++j) {
            	if (Node.ELEMENT_NODE != children.item(0).getNodeType()) {
            		continue;
            	}
            	
                String condTxt = ((Element)cond.item(j)).getChildNodes().item(0).getTextContent();
                x.addCond(condTxt);
            }
            rules.add(x);
        }


    }

    private void parseQuestions (Element root) {
        NodeList children = root.getElementsByTagName("Question");

        if (null == children || 0 == children.getLength()) {
            return;
        }

        for (int i = 0; i < children.getLength(); ++i) {
        	if (Node.ELEMENT_NODE != children.item(0).getNodeType()) {
        		continue;
        	}
        	
            Element question = (Element)children.item(i);
            String text = question.getElementsByTagName("Text").item(0).getTextContent();

            if (!questions.containsKey(text)) {
                questions.put(text, new ArrayList<>());
            }
            NodeList answers = question.getElementsByTagName("Answer");

            if (null == answers || 0 == answers.getLength()) {
                continue;
            }

            List<String> ans = questions.get(text);

            for (int j = 0; j < answers.getLength(); ++j) {
            	if (Node.ELEMENT_NODE != children.item(0).getNodeType()) {
            		continue;
            	}
            	
                ans.add(answers.item(j).getTextContent());
            }
        }
    }

    private void parseSets (Element root) {
        NodeList children = root.getElementsByTagName("Set");

        if (null == children || 0 == children.getLength()) {
            return;
        }

        for (int i = 0; i < children.getLength(); ++i) {
        	if (Node.ELEMENT_NODE != children.item(0).getNodeType()) {
        		continue;
        	}
        	
            Element set = (Element)children.item(i);
            String name = set.getElementsByTagName("Name").item(0).getTextContent();
            String values = set.getElementsByTagName("Value").item(0).getTextContent();

            if (!sets.containsKey(name)) {
                sets.put(name, new ArrayList<>());
            }
            
            sets.get(name).addAll(Arrays.asList(values.split(";")));
        }
    }

    public List<Rule> getRules() {return rules;}
    public Map<String, List<String>> getQuestions() {return questions;}
    public Map<String, List<String>> getSets()      {return sets;}
}