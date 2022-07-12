package ru.job4j.design.srp;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Employee.class, new JsonSerializer<Employee>() {
            @Override
            public JsonElement serialize(Employee employee, Type type, JsonSerializationContext jsonSerializationContext) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("name", employee.getName());
                jsonObject.addProperty("hired", employee.getHired().getTime().toString());
                jsonObject.addProperty("fired", employee.getFired().getTime().toString());
                jsonObject.addProperty("salary", String.format("%.2f", employee.getSalary()));
                return jsonObject;
            }
        });
        return builder.create().toJson(store.findBy(filter));
    }
}
