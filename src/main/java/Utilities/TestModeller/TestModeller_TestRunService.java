package Utilities.TestModeller;

import Utilities.PropertiesLoader;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class TestModeller_TestRunService {
    private String m_ErrorMessage;

    public TestModeller_TestRunService()
    {
        m_ErrorMessage = "";
    }

    public String getErrorMessage() {
        return m_ErrorMessage;
    }

    public boolean saveTestPathRun(TestPathRunEntity runEntity)
    {
        // Only one time
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Object to Json
        try {
            HttpResponse<JsonNode> postResponse = Unirest.post(PropertiesLoader.getProperties().getProperty("testModeller.apiHost") + "/api/apikey/" + PropertiesLoader.getProperties().getProperty("testModeller.apiKey") + "/model/version/profile/testcollection/testsuite/testpath/run")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(runEntity)
                    .asJson();

            if (postResponse.getStatus() == 200) {
                return true;
            } else {
                m_ErrorMessage = postResponse.toString();

                return false;
            }
        } catch (Exception e) {
            m_ErrorMessage = e.getMessage();

            return false;
        }
    }
}
