package ru.job4j.design.srp;

import java.util.function.Predicate;

import static ru.job4j.design.srp.Constants.DATE_FORMAT;
import static ru.job4j.design.srp.Constants.LS;

public class ReportEngine implements Report {
    private final Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;").append(LS);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(LS);
        }
        return text.toString();
    }
}
