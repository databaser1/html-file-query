package app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlanReaderApplication {
  @Bean
  public Map<String, String> getBookList() {
    HashMap<String, String> bookList = new HashMap<String, String>();
    bookList.put("gen", "创世记");
    bookList.put("exo", "出埃及记");
    bookList.put("lev", "利未记");
    bookList.put("num", "民数记");
    bookList.put("deu", "申命记");
    bookList.put("jos", "约书亚记");
    bookList.put("jdg", "士师记");
    bookList.put("rut", "路得记");
    bookList.put("1sa", "撒母耳记上");
    bookList.put("2sa", "撒母耳记下");
    bookList.put("1ki", "列王纪上");
    bookList.put("2ki", "列王纪下");
    bookList.put("1ch", "历代志上");
    bookList.put("2ch", "历代志下");
    bookList.put("ezr", "以斯拉记");
    bookList.put("neh", "尼西米记");
    bookList.put("est", "以斯帖记");
    bookList.put("job", "约伯记");
    bookList.put("psa", "诗篇");
    bookList.put("pro", "箴言");
    bookList.put("ecc", "传道书");
    bookList.put("son", "雅歌");
    bookList.put("isa", "以赛亚书");
    bookList.put("jer", "耶利米书");
    bookList.put("lam", "耶利米哀歌");
    bookList.put("eze", "以西结书");
    bookList.put("dan", "但以理书");
    bookList.put("hos", "何西阿书");
    bookList.put("joe", "约珥书");
    bookList.put("amo", "阿摩司书");
    bookList.put("oba", "俄巴底亚书");
    bookList.put("jon", "约拿书");
    bookList.put("mic", "弥迦书");
    bookList.put("nah", "那鸿书");
    bookList.put("hab", "哈巴谷书");
    bookList.put("zep", "西番雅书");
    bookList.put("hag", "哈该书");
    bookList.put("zec", "撒迦利亚书");
    bookList.put("mal", "玛拉基书");
    bookList.put("mat", "马太福音");
    bookList.put("mar", "马可福音");
    bookList.put("luk", "路加福音");
    bookList.put("joh", "约翰福音");
    bookList.put("act", "使徒行传");
    bookList.put("rom", "罗马书");
    bookList.put("1co", "哥林多前书");
    bookList.put("2co", "哥林多后书");
    bookList.put("gal", "加拉太书");
    bookList.put("eph", "以弗所书");
    bookList.put("php", "腓立比书");
    bookList.put("col", "歌罗西书");
    bookList.put("1th", "帖撒罗尼迦前书");
    bookList.put("2th", "帖撒罗尼迦后书");
    bookList.put("1ti", "提摩太前书");
    bookList.put("2ti", "提摩太后书");
    bookList.put("tit", "提多书");
    bookList.put("phm", "腓利门书");
    bookList.put("heb", "希伯来书");
    bookList.put("jam", "雅各书");
    bookList.put("1pe", "彼得前书");
    bookList.put("2pe", "彼得后书");
    bookList.put("1jo", "约翰一书");
    bookList.put("2jo", "约翰二书");
    bookList.put("3jo", "约翰三书");
    bookList.put("jud", "犹大书");
    bookList.put("rev", "启示录");
    return bookList;
  }

	public static void main(String[] args) {
		SpringApplication.run(PlanReaderApplication.class, args);
	}
}
