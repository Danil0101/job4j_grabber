package ru.job4j.design.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.design.srp.Constants.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;").append(LS)
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(worker.getSalary()).append(";").append(LS);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenForProgrammers() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportProgrammers(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>").append(LS)
                .append("<html>").append(LS)
                .append("<head>").append(LS)
                .append("<meta charset=\"UTF-8\">").append(LS)
                .append("<title>Таблица</title>").append(LS)
                .append("</head>").append(LS)
                .append("<body>").append(LS)
                .append("<table>").append(LS)
                .append("<tr>").append(LS)
                .append("<th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th>").append(LS)
                .append("</tr>").append(LS)
                .append("<tr>").append(LS)
                .append("<td>").append(worker.getName()).append("</td>")
                .append("<td>").append(worker.getHired()).append("</td>")
                .append("<td>").append(worker.getFired()).append("</td>")
                .append("<td>").append(worker.getSalary()).append("</td>")
                .append("</tr>").append(LS)
                .append("</table>").append(LS)
                .append("</body>").append(LS)
                .append("</html>").append(LS);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenForAccounting() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportAccounting(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;").append(LS)
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime())).append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime())).append(";")
                .append(String.format("%.2f", worker.getSalary() / DOLLAR_RATE)).append(";")
                .append(LS);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenForHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Petr", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;").append(LS)
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";").append(LS)
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";").append(LS);
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}