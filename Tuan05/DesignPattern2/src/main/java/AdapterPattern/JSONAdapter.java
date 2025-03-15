package AdapterPattern;

import org.json.JSONObject;
import org.json.XML;

public class JSONAdapter implements  JSONTarget{
    private XMLService xmlService;

    public JSONAdapter(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public String processJSON(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        String xmlData = XML.toString(jsonObject);
        System.out.println("Chuyển đổi JSON sang XML: " + xmlData);

        // Gửi dữ liệu XML cho XMLService xử lý
        xmlService.processXML(xmlData);
        return xmlData;
    }
}
