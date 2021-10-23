package Job4j.it.question;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.map(pupil -> pupil.getSubjects())
                .flatMap(subjects -> subjects.stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(5);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil
                .getName(), pupil.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(5)))
                .collect(Collectors.toList());
    }

   public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
       return stream.map(Pupil::getSubjects)
               .flatMap(Collection::stream)
             .collect(Collectors
                     .groupingBy(Subject::getName, LinkedHashMap::new, Collectors
                     .averagingDouble(Subject::getScore)))
               .entrySet()
               .stream()
               .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
               .collect(Collectors.toList());

   }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil
                        .getName(), pupil.getSubjects()
                        .stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator
                        .comparing(Tuple::getScore))
                .orElse(new Tuple("ddd", 100));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.map(pupil -> pupil.getSubjects())
                .flatMap(subjects -> subjects.stream())
                .collect(Collectors
                        .groupingBy(Subject::getName, Collectors
                                .summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator
                        .comparing(Tuple::getScore))
                .orElse(new Tuple("ccc", 100));
    }
}
