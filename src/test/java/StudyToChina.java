import java.io.IOException;
import java.util.Map;

import org.jsoup.helper.HttpConnection;
import org.jsoup.nodes.Document;
/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-17 18:24
 */
public class StudyToChina {
    public static void main(String[] args) {
        Document document;
        String resp = "";
        try {
//            Map<String, String> map = CourseHttpHelper.login2jwc(jwcAccount, password);
            String url = "http://jwcxxcx.ccsu.cn/jwxt/xszqcjglAction.do?method=queryxscj";
            url = "https://www.xuexi.cn/";
//            url = "http://jwcxxcx.ccsu.cn/jwxt/";
            url = "https://www.xuexi.cn/cc72a0454287bdedb7e2c156db55e818/71eb7214c6c0c1f5e6ec6e29564decb4.html";
            url = "https://www.xuexi.cn/b0b2a39e854d4612c6858aea76861d98/648fafc83297345be269377aefc53c9e.html";
//            document = HttpConnection.connect(url).header("Cookie", map.get("cookie"))
//                    .data("kksj", xnxq).data("xsfs", "zhcj").get();
            document = HttpConnection.connect(url).get();
            resp = document.toString();
        } catch (IOException e) {

        }
        if (resp.contains("出错页面")) {
            System.out.println("出错页面");
        }
//        if (!resp.contains("html") && resp.contains("script")) {
//            int index = resp.indexOf("alert('");
//            resp = resp.substring(index, resp.length());
//            index = resp.indexOf("');");
//            resp = resp.substring(0, index);
//            resp = resp.split("'")[1];
//        }
        System.out.println("页面头==============================");
        System.out.println(resp);
        System.out.println("页尾==============================");
//        return this.parseDcumentToList(document);
    }

}
