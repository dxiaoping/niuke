package CodeAnalysis.mybatis;

import CodeAnalysis.mybatis.dao.StudentDao;
import CodeAnalysis.mybatis.dao.UserDao;
import CodeAnalysis.mybatis.pojo.Student;
import CodeAnalysis.mybatis.pojo.User;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2019-10-18 11:46
 */
public class MapperTest {

    @Test
    public void test() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        User user = userDao.selectById(5);
//        sqlSession.commit();
        User user1 = userDao.selectById(5);
        Student student = studentDao.selectBySno(1001);
        System.out.println(user.hashCode());
        System.out.println(user1.hashCode());
        System.out.println(student);
//        Configuration configuration = new Configuration();
//        XMLMapperBuilder builder = new XMLMapperBuilder(inputStream,
//                configuration,resource,configuration.getSqlFragments());
//        builder.parse();

    }

    public static void main(String[] args){
        //创建datasource，具体过程封装在工厂类中，不在详述
//        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
//        TransactionFactory transactionFactory = new JdbcTransactionFactory();
//        Environment environment = new Environment("Production", transactionFactory, dataSource);
//        Configuration configuration = new Configuration(environment);
//        configuration.setLazyLoadingEnabled(true);
//        configuration.setUseActualParamName(false); // to test legacy style reference (#{0} #{1})
//        configuration.getTypeAliasRegistry().registerAlias(Blog.class);
//        configuration.addMapper(BoundBlogMapper.class);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
//
//        SqlSession session = sqlSessionFactory.openSession();
//        BoundBlogMapper mapper = session.getMapper(BoundBlogMapper.class);
//        Blog b = mapper.selectBlogWithPostsUsingSubSelect(1);
//        session.close();
    }
}