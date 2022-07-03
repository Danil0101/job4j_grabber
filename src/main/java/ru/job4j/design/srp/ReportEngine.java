package ru.job4j.design.srp;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportEngine implements Report {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");
    public static final double DOLLAR_RATE = 60;
    private final Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter, TypesReports typesReports) {
        StringBuilder text = new StringBuilder();
        switch (typesReports) {
            case PROGRAMMERS:
                for (Employee employee : store.findBy(filter)) {
                    text.append(employee.getName()).append(";")
                            .append(employee.getHired().getTime()).append(";")
                            .append(employee.getFired().getTime()).append(";")
                            .append(employee.getSalary()).append(";")
                            .append(System.lineSeparator());
                }
                break;
            case ACCOUNTING:
                text.append("Name; Hired; Fired; Salary;")
                        .append(System.lineSeparator());
                for (Employee employee : store.findBy(filter)) {
                    text.append(employee.getName()).append(";")
                            .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                            .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                            .append(String.format("%.2f", employee.getSalary() / DOLLAR_RATE)).append(";")
                            .append(System.lineSeparator());
                }
                break;
            case HR:
                List<Employee> employees = store.findBy(filter).stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .collect(Collectors.toList());
                text.append("Name; Salary;").append(System.lineSeparator());
                for (Employee employee : employees) {
                    text.append(employee.getName()).append(";")
                            .append(employee.getSalary()).append(";")
                            .append(System.lineSeparator());
                }
                break;
            default:
                text.append("Name; Hired; Fired; Salary;")
                        .append(System.lineSeparator());
                for (Employee employee : store.findBy(filter)) {
                    text.append(employee.getName()).append(";")
                            .append(DATE_FORMAT.format(employee.getHired().getTime())).append(";")
                            .append(DATE_FORMAT.format(employee.getFired().getTime())).append(";")
                            .append(employee.getSalary()).append(";")
                            .append(System.lineSeparator());
                }
        }
        return text.toString();
    }
}
