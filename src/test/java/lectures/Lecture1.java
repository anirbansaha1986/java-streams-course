package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people`
    List<Person> less18People = Lists.newArrayList();//new ArrayList<Person>();
    int count = 0;
    for(int i=0; i<people.size();i++){
      if (people.get(i).getAge() <= 18){
        if (count < 10) {
          less18People.add(people.get(i));
          System.out.println("People name: " + people.get(i).getFirstName() + "Age: "+ people.get(i).getAge());
          count++;
        }
        else {
          break;
        }
      }
    }

  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    MockData.getPeople().stream()
            .filter(person -> person.getAge() <= 18)
            .limit(10)
            .collect(Collectors.toList())
            .forEach(System.out::println);
  }
}
