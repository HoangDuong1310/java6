package com.example.resttemplate.repository;

import com.example.resttemplate.entitys.StudentEntity;
import com.example.resttemplate.map.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class StudentRepo {
    RestTemplate rest = new RestTemplate();
    String url = "https://java6-da032-default-rtdb.firebaseio.com/students.json";

    private String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public StudentMap findAll() {
        return rest.getForObject(url, StudentMap.class);

    }

    public StudentEntity findByKey(String key) {

        return rest.getForObject(getUrl(key), StudentEntity.class);
    }

    public String create(StudentEntity data) {
        HttpEntity<StudentEntity> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText();

    }

    public StudentEntity update(String key, StudentEntity data) {
        HttpEntity<StudentEntity> entity = new HttpEntity<>(data);
        rest.put(getUrl(key), entity);
        return data;
    }

    public void delete(String key) {
        rest.delete(getUrl(key));

    }

}
