package problemSolutions;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class E09FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Name");
        EntityManager em = emf.createEntityManager();

        List<Project> projects = em.createQuery("""
                        SELECT p
                        FROM Project p
                        ORDER BY p.name
                        """, Project.class)
                .setMaxResults(10)
                .getResultList();
        for (Project p : projects) {
            System.out.printf("""
                            Project name: %s
                             	Project Description: %s
                             	Project Start Date:%s
                             	Project End Date: %s
                            """,
                    p.getName(),
                    p.getDescription(),
                    formatDate(p.getStartDate()),
                    p.getEndDate() == null ? "null" : formatDate(p.getEndDate()));

        }
    }

    private static String formatDate(LocalDateTime d) {
        Instant time = d.toInstant(ZoneOffset.ofHours(0));
        ZoneId timeZone = ZoneId.of("America/Argentina/Buenos_Aires");

        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss.S")
                .format(ZonedDateTime.ofInstant(time, timeZone));
    }
}
