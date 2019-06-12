package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() + 1);

   group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
   before.add(group);
   Assert.assertEquals(before, after);

  }
}
  /*
  //Поиск максимального эл-та в коллекции
  int max = 0;
    for (GroupData g: after){
      if (g.getId() > max){
        max = g.getId();
      }
    }
    group.setId(max);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    */
