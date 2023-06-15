package net.atlassian.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.atlassian.models.IssueData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {

    @DataProvider(name = "issueData")
    public Object[][] getIssueData() throws IOException {
        String filePath = "src/test/resources/test-data/issueData.json";
        List<IssueData> issueDataList = readTestDataFromJson(filePath);

        Object[][] data = new Object[issueDataList.size()][1];
        for (int i = 0; i < issueDataList.size(); i++) {
            data[i][0] = issueDataList.get(i);
        }

        return data;
    }

    private List<IssueData> readTestDataFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
            return objectMapper.readValue(fis, new TypeReference<>() {
            });
        }
    }

}