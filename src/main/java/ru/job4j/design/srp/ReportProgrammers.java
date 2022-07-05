package ru.job4j.design.srp;

import java.util.function.Predicate;
import static ru.job4j.design.srp.Constants.LS;

public class ReportProgrammers implements Report {
    private final Store store;

    public ReportProgrammers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<!DOCTYPE html>").append(LS)
                .append("<html>").append(LS)
                .append("<head>").append(LS)
                .append("<meta charset=\"UTF-8\">").append(LS)
                .append("<title>Таблица</title>").append(LS)
                .append("</head>").append(LS)
                .append("<body>").append(LS)
                .append("<table>").append(LS)
                .append("<tr>").append(LS)
                .append("<th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th>").append(LS)
                .append("</tr>").append(LS);
        for (Employee employee : store.findBy(filter)) {
            text.append("<tr>").append(LS)
                    .append("<td>").append(employee.getName()).append("</td>")
                    .append("<td>").append(employee.getHired()).append("</td>")
                    .append("<td>").append(employee.getFired()).append("</td>")
                    .append("<td>").append(employee.getSalary()).append("</td>")
                    .append("</tr>").append(LS);
        }
        text.append("</table>").append(LS)
                .append("</body>").append(LS)
                .append("</html>").append(LS);
        return text.toString();
    }
}
